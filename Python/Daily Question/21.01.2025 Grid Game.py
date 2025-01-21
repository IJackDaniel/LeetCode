# 2017. Grid Game
# 21.01.2025
# 
# Not solved. Time Limit Exceeded
# По идее, алгоритм верный, однако по времени не проходит, и я пока не знаю как можно оптимизировать программу.
# In theory, the algorithm is correct, but time does not pass, and I do not yet know how to optimize the program.

class Solution:
    def gridGame(self, grid) -> int:
        mn = sum(grid[0]) + sum(grid[1])
        for j in range(len(grid[0])):
            sum1 = sum(grid[1][0:j])
            sum2 = sum(grid[0][j+1:len(grid[0])])
            if sum1 == 0:
                sum1 = sum2
            if sum2 == 0:
                sum2 = sum1
            mn = min(mn, max(sum1, sum2))
        return mn


sl = Solution()
print(sl.gridGame([[2,5,4],[1,5,1]]))  # 4
print(sl.gridGame([[3,3,1],[8,5,2]]))  # 4
print(sl.gridGame([[1,3,1,15],[1,3,3,1]]))  # 7
print(sl.gridGame([[20,3,20,17,2,12,15,17,4,15],[20,10,13,14,15,5,2,3,14,3]]))  # 63!

# print(sl.gridGame())
