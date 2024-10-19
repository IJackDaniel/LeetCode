from datetime import date


cur_date = date.today()
year = cur_date.year
month = cur_date.month
day = cur_date.day

if len(str(month)) == 1:
    month = f"0{month}"

num = input("Введите номер задачи: ")
name_raw = input("Введите название задачи: ")
name = f"{num}. {name_raw}"
file = open(f"{name}.py", "w")
file.write(f"# {name}" + "\n")
file.write(f"# Date of problem solution: {day}.{month}.{year}" + "\n")
file.write("# " + "\n")
file.write("# " + "\n")
file.close()
