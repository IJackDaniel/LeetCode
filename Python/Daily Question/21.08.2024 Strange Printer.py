# 664. Strange Printer
# 21.08.2024
# НЕВЫПОЛНЕНА
# def strangePrinter(self, s: str) -> int:

"""
Разбить всю строку на подстроки
Массивы, в которых хранятся последовательности только от одной буквы
Массив с массивами?
Самый большой массив по количеству элементов => самый первый вывод

"""


def strangePrinter(s):
    unic = sorted(list(set(s)))
    dictionary = {}
    for sym in unic:
        dictionary[sym] = []

    string = s[0]
    for i in range(len(s) - 1):
        a = s[i]
        b = s[i+1]
        if a == b:
            string += b
        else:
            dictionary[string[0]].append(string)
            string = s[i+1]
    dictionary[string[0]].append(string)

    arr = []
    for key, data in dictionary.items():
        arr.append(len(data))
    arr.sort(reverse=True)
    arr[0] = 1
    return sum(arr)


print(strangePrinter("aaabbbaccca"))
print(strangePrinter("tbgtgb"))


"""
def strangePrinter(s):
    unic = sorted(list(set(s)))
    dictionary = {}
    for sym in unic:
        dictionary[sym] = []

    string = s[0]
    for i in range(len(s) - 1):
        a = s[i]
        b = s[i+1]
        if a == b:
            string += b
        else:
            dictionary[string[0]].append(string)
            string = s[i+1]
        print(i)
        print(string)
        print(dictionary)
        print()
    dictionary[string[0]].append(string)
    return dictionary
"""