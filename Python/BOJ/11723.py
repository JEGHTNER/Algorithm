import sys

def solution():
    m = int(sys.stdin.readline().strip())
    dic = {n : 0 for n in range(1, 21)}
    for i in range(m):
        inp = sys.stdin.readline().strip()
        if inp == "all":
            dic = {n: 1 for n in range(1,21)}
        elif inp == "empty":
            dic = {n: 0 for n in range(1, 21)}
        else:
            command, num = inp.split()
            if command == "add":
                dic[int(num)] += 1
            elif command == "check":
                if dic[int(num)] == 0:
                    print(0)
                else:
                    print(1)
            elif command == "remove":
                dic[int(num)] = 0
            elif command == "toggle":
                if dic[int(num)] == 0:
                    dic[int(num)] += 1
                else:
                    dic[int(num)] = 0

solution()