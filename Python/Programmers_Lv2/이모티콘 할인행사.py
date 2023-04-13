# def solution(users, emoticons):
#     answer = [0, 0]
#     data = [10, 20, 30, 40]
#     discount = []
#
#     def dfs(tmp, d):  # 모든 경우의 할인율 조합을 구함
#         if d == len(tmp):
#             discount.append(tmp[:])
#             return
#         else:
#             for i in data:
#                 tmp[d] += i
#                 dfs(tmp, d + 1)
#                 tmp[d] -= i
#
#     dfs([0] * len(emoticons), 0)
#
#     for disc in discount:  # 만들어진 모든 조합을 하나씩 살펴봄
#         cnt = 0
#         get = 0
#         for i in users:
#             pay = 0
#             for j in range(len(disc)):
#                 if i[0] <= disc[j]:
#                     pay += emoticons[j] * (100 - disc[j]) // 100
#                 if pay >= i[1]:
#                     break
#             if pay >= i[1]:  # 만약 유저의 제한금액 초과시 플러스 구매
#                 pay = 0
#                 cnt += 1
#             get += pay
#         if cnt >= answer[0]:  # 현재 최대값을 넘어가면 갱신
#             if cnt == answer[0]:
#                 answer[1] = max(answer[1], get)
#             else:
#                 answer[1] = get
#             answer[0] = cnt
#
#     return answer

from itertools import product

def solution(users, emoticons):
    E = len(emoticons)
    result = [0, 0]
    percents = (10, 20, 30, 40)
    prod = product(percents, repeat=E)
    for p in prod:
        prod_members, prod_price = 0, 0
        for buy_percent, max_price in users:
            user_price = 0
            for item_price, item_percent in zip(emoticons, p):
                if item_percent >= buy_percent:
                    user_price += item_price * (100-item_percent) * 0.01

            if user_price >= max_price:
                prod_members += 1
            else:
                prod_price += user_price

        result = max(result, [prod_members, prod_price])

    return result


users = [[40, 10000], [25, 10000]]
emoticons = [7000, 9000]

print(solution(users, emoticons))
