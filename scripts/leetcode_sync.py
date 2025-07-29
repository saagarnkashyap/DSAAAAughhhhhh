import requests
from github import Github, GithubException
import time
import os
import sys

LEETCODE_USERNAME = os.getenv("LEETCODE_USERNAME")
LEETCODE_COOKIE = os.getenv("LEETCODE_COOKIE")
GH_TOKEN = os.getenv("GH_TOKEN") or os.getenv("GITHUB_TOKEN")
REPO_NAME = os.getenv("GITHUB_REPOSITORY")
BRANCH = "main"
FOLDER = "submissions"

headers = {
    "Cookie": f"LEETCODE_SESSION={LEETCODE_COOKIE}",
    "Referer": "https://leetcode.com",
    "Content-Type": "application/json",
}

def get_accepted_submissions():
    url = f"https://leetcode.com/api/submissions/"
    all_subs = []
    offset = 0
    while True:
        res = requests.get(url + f"?offset={offset}&limit=20", headers=headers)
        if res.status_code != 200:
            print("❌ Error fetching submissions.")
            break
        data = res.json()
        accepted = [s for s in data.get('submissions_dump', []) if s.get('status_display') == 'Accepted']
        all_subs += accepted
        if not data.get('has_next'):
            break
        offset += 20
    return all_subs

def push_to_github(filename, content):
    if not GH_TOKEN or not REPO_NAME:
        print("❌ GitHub token or repository name not set.")
        sys.exit(1)
    g = Github(GH_TOKEN)
    repo = g.get_repo(REPO_NAME)
    path = f"{FOLDER}/{filename}"
    try:
        repo.get_contents(path, ref=BRANCH)
        print(f"⏩ Skipped (already exists): {filename}")
    except GithubException as e:
        if e.status == 404:
            # File does not exist, create it
            try:
                repo.create_file(path, f"Add {filename}", content, branch=BRANCH)
                print(f"✅ Uploaded: {filename}")
            except GithubException as create_exc:
                if create_exc.status == 403:
                    print(f"❌ Permission denied for {filename}. Check workflow permissions.")
                else:
                    print(f"❌ Failed to create {filename}: {create_exc}")
        elif e.status == 403:
            print(f"❌ Permission denied when accessing {filename}. Check workflow permissions.")
        else:
            print(f"❌ Unexpected error for {filename}: {e}")

def format_filename(slug, lang):
    ext = {"python3": "py", "cpp": "cpp", "java": "java"}.get(lang, "txt")
    return f"{slug}.{ext}"

if __name__ == "__main__":
    if not LEETCODE_COOKIE:
        print("❌ LEETCODE_COOKIE environment variable not set.")
        sys.exit(1)

    subs = get_accepted_submissions()
    print(f"📦 Found {len(subs)} accepted submissions.")
    for sub in subs:
        filename = format_filename(sub.get("title_slug", "unknown"), sub.get("lang", "txt"))
        push_to_github(filename, sub.get("code", ""))
        time.sleep(1)
