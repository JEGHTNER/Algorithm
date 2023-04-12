import sys

line = sys.stdin.readline().rstrip()
cmd = []
lst = []
index = 0
flag = 0
num = ""
for i in line:
    if i == '-' or i == '+':
        if i == '-':
            flag = 1
        cmd.append(i)
        lst.append(int(num))
        num = ""
    else:
        num += i
lst.append(int(num))

for idx in range(len(cmd)):
    if cmd[idx] == '-':
        index = idx
        break
if flag == 1:
    print(sum(lst[0 : index + 1]) - sum(lst[index + 1:]))
else:
    print(sum(lst))
