import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
S = sys.stdin.readline().strip()

P = []
for i in range(N):
    P.append("I")
    P.append("O")
P.append("I")
p_len = len(P)

def getPi():
    pi = [0] * p_len
    j = 0
    for i in range(1, p_len):
        while j > 0 and P[i] != P[j]:
            j = pi[j - 1]

        if P[i] == P[j]:
            j+= 1
            pi[i] = j
    return pi

def kmp():
    ans = []
    pi = getPi()
    j = 0
    for i in range(M):
        while j > 0 and S[i] != P[j]:
            j = pi[j-1]
        if S[i] == P[j]:
            if j == p_len - 1:
                ans.append(i-p_len + 1)
                j = pi[j]
            else:
                j += 1
    return ans

print(len(kmp()))