import os
import random
import subprocess
from datetime import datetime, timedelta

# ---------------- CONFIG ----------------
repos = [
    "E:/Personal/projects/go-green-art",
    "E:/Personal/projects/DSAAAAughhhhhh",
    "E:/Personal/projects/PWD"
]

FILENAME = "update.txt"
COMMIT_MESSAGE = "ughh commits"
COMMITS_PER_DAY = (1, 3)   # 1 to 3 commits per day
start_date = datetime(2025, 6, 6)  # streak start
end_date = datetime(2025, 9, 21)   # streak end (108 days)
# ---------------------------------------

def random_time_for_day(day):
    """Return a random datetime on the given day."""
    hour = random.randint(8, 23)  # realistic: between 8am and 11pm
    minute = random.randint(0, 59)
    second = random.randint(0, 59)
    return day.replace(hour=hour, minute=minute, second=second)

def make_commit(repo_path, commit_time):
    filepath = os.path.join(repo_path, FILENAME)
    with open(filepath, "a") as f:
        f.write(f"Commit at {commit_time.isoformat()}\n")
    
    subprocess.run(["git", "add", FILENAME], cwd=repo_path)
    env = os.environ.copy()
    date_str = commit_time.strftime("%Y-%m-%dT%H:%M:%S")
    env["GIT_AUTHOR_DATE"] = date_str
    env["GIT_COMMITTER_DATE"] = date_str
    subprocess.run(["git", "commit", "-m", COMMIT_MESSAGE], cwd=repo_path, env=env)
    print(f"[{repo_path}] Committed at {commit_time}")

current_day = start_date
while current_day <= end_date:
    # 5% chance to "skip" a day → but we immediately fix it next day with extra commits
    if random.random() < 0.05:
        current_day += timedelta(days=1)
        commits_today = random.randint(2, 4)  # next day heavier
    else:
        commits_today = random.randint(*COMMITS_PER_DAY)
    
    for _ in range(commits_today):
        repo_path = random.choice(repos)
        commit_time = random_time_for_day(current_day)
        make_commit(repo_path, commit_time)

    current_day += timedelta(days=1)

print("✅ All commits generated. Push each repo manually.")
