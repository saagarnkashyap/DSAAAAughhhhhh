import requests
from github import Github
import time
import os

LEETCODE_USERNAME = os.getenv("LEETCODE_USERNAME")
LEETCODE_COOKIE = os.getenv("LEETCODE_COOKIE")
GITHUB_TOKEN = os.getenv("GITHUB_TOKEN")
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
        accepted = [s for s in data['submissions_dump'] if s['status_display'] == 'Accepted']
        all_subs += accepted
        if not data['has_next']:
            break
        offset += 20
    return all_subs

def push_to_github(filename, content):
    g = Github(GITHUB_TOKEN)
    repo = g.get_repo(REPO_NAME)
    path = f"{FOLDER}/{filename}"
    try:
        repo.get_contents(path, ref=BRANCH)
        print(f"⏩ Skipped (already exists): {filename}")
    except:
        repo.create_file(path, f"Add {filename}", content, branch=BRANCH)
        print(f"✅ Uploaded: {filename}")

def format_filename(slug, lang):
    ext = {"python3": "py", "cpp": "cpp", "java": "java"}.get(lang, "txt")
    return f"{slug}.{ext}"

if __name__ == "__main__":
    subs = get_accepted_submissions()
    print(f"📦 Found {len(subs)} accepted submissions.")
    for sub in subs:
        filename = format_filename(sub["title_slug"], sub["lang"])
        push_to_github(filename, sub["code"])
        time.sleep(1)
