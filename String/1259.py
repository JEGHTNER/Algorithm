import sys

while True:
    flag = 0
    num = sys.stdin.readline().strip()
    if num == "0":
        break
    else:
        for i in range(len(num)):
            if num[i] != num[-1 -i]:
                flag += 1
    if flag != 0:
        print("no")
    else:
        print("yes")
                
