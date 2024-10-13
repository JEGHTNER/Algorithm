import heapq

def mix(a, b):
    return (a + (b * 2))

def solution(scoville, K):
    heapq.heapify(scoville)
    cnt = 0
    # print(scoville)
    while(scoville[0] < K):
        if len(scoville) < 2:
            return -1
        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)
        heapq.heappush(scoville, mix(a,b))
        # print(scoville)
        cnt+=1
    # print(cnt, scoville)
    return cnt