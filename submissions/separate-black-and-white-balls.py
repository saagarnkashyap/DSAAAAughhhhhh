class Solution:
    def minimumSteps(self, s: str) -> int:
        black, swap=0, 0
        for c in s:
            if c=='1': black+=1
            else: swap+=black
        return swap