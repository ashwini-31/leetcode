class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        count = collections.Counter()
        for b in words2:
            count =count | collections.Counter(b)
        return [a for a in words1 if collections.Counter(a) & count == count]    
        