import sys
from collections import deque

T = int(sys.stdin.readline())

for tc in range(T):
    answer = ""
    p = sys.stdin.readline().rstrip() #RDD
    n = int(sys.stdin.readline())
    queue = deque(sys.stdin.readline().rstrip().lstrip('[').rstrip(']').split(','))
    if queue == deque(['']):
        queue.pop()
    error_flag = False
    reverse_flag = 1
    for command in p:
        if command == 'R':
            reverse_flag *= -1
        elif command == 'D':
            if queue:
                if reverse_flag == -1:
                    queue.pop()
                else:
                    queue.popleft()
            else:
                error_flag = True
                break
    if error_flag:
        print("error")
    else:
        if reverse_flag == 1:
            answer +="["
            for num in queue:
                answer += num + ","
            if (answer[-1] == ","):
                answer = answer[:-1]
            answer += "]"
            print(answer)
        else:
            queue.reverse()
            answer +="["
            for num in queue:
                answer += num + ","
            if (answer[-1] == ","):
                answer = answer[:-1]
            answer += "]"
            print(answer)


