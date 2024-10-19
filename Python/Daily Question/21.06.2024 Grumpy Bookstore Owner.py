# 1052. Grumpy Bookstore Owner
# 21.06.2024
#
# def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:

def maxSatisfied(customers, grumpy, minutes):  # 0,05 секунд
    sat = [customers[i] if grumpy[i] == 0 else 0 for i in range(len(customers))]
    sat2 = [customers[i] if grumpy[i] == 1 else 0 for i in range(len(customers))]
    mx = 0
    mx_j = 0
    for j in range(len(sat) - minutes + 1):
        sm = sum(sat2[j: j+minutes])
        if mx < sm:
            mx = sm
            mx_j = j
    return sum(sat[:mx_j] + customers[mx_j: mx_j+minutes] + sat[mx_j+minutes:])
