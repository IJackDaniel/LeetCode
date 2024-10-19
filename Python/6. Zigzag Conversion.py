# 6. Zigzag Conversion
# Date of problem solution: 11.07.2024
# 
# def convert(self, s: str, numRows: int) -> str:

# Код написан методом "в тупую" и поэтому очень неэффективен. Как-нибудь перепишу

def convert(s, numRows):
    ln = len(s)
    if numRows == 1:
        return s

    matrix = [["9" for _ in range((numRows-1) * (ln // (numRows * 2 - 2) + 1))] for _ in range(numRows)]

    iteration_num = 0
    i = 0
    j = 0
    flag = False

    while iteration_num != ln:

        matrix[i][j] = s[iteration_num]

        if not flag:
            i += 1
            if i == numRows:
                i -= 1
                flag = True

        if flag:
            i -= 1
            j += 1
            if i == 0:
                flag = False

        iteration_num += 1

    result = ""
    for num in range(numRows):
        result += "".join(matrix[num])
    result = result.replace("9", "")

    return result
