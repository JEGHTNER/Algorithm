import heapq

class Job:
    def __init__(self, begin, cost):
        self.begin = begin
        self.cost = cost
    
    def __lt__(self, other):
        return self.cost < other.cost
    
    def __repr__(self):
        return f"{self.begin}({self.cost})"

def solution(jobs):
    cur_time = 0
    work_time = 0
    answer = 0
    jobs.sort(key=lambda x: x[0])
    count = 0
    end = 0
    jobs_idx = 0
    pq = []
    while count < len(jobs):
        while jobs_idx < len(jobs) and jobs[jobs_idx][0] <= end:
            heapq.heappush(pq, Job(jobs[jobs_idx][0], jobs[jobs_idx][1]))
            jobs_idx += 1
        if not pq:
            end = jobs[jobs_idx][0]
        else:
            job = heapq.heappop(pq)
            answer += job.cost + end - job.begin
            end += job.cost
            count+=1
    
    return answer // len(jobs)