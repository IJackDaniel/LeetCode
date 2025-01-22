# 1765. Map of Highest Peak
# 22.01.2025
#
# Код абсолютно неверный. Я не знаю как это делать

class Solution:
    def highestPeak(self, isWater):
        ground = [[0 * len(isWater[0])] * len(isWater)]
        for i in range(len(isWater)):
            for j in range(len(isWater[0])):
                if isWater[i][j] == 0:
                    ground[i][j] += 1

        for _ in range(len(isWater)):
            for i in range(1, len(isWater) - 1):
                for j in range(1, len(isWater[0]) - 1):
                    if ground[i][j] >= ground[i - 1][j] and ground[i][j] >= ground[i + 1][j] and ground[i][j] >= ground[i][j - 1] and ground[i][j] >= ground[i][j + 1]:
                        ground[i][j] += 1
        return ground


sl = Solution()
res = sl.highestPeak([[0,1],[0,0]])
for i in range(len(res)):
    print(*res[i])
