from typing import List
from typing import Optional
from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        window_indices = deque()
        ans = []
        for i in range(len(nums)):
            if len(window_indices)>0 and window_indices[0] == i-k:
                window_indices.popleft()
            while len(window_indices)>0:
                if nums[window_indices[-1]] < nums[i]:
                    window_indices.pop()
                else:
                    break
            window_indices.append(i)
            if i >= k-1:
                ans.append(nums[window_indices[0]])
        return ans

def main():
    sol = Solution()
    print('Output:', sol.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))
    print('Expected:', [3,3,5,5,6,7])

if __name__ == "__main__":
    main()