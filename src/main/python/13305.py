import sys
input = sys.stdin.readline
n = int(input())
distance = list(map(int,input().split()))
price = list(map(int,input().split()))
tempPrice = price[0]
tempDistance = 0
result = 0
for i in range(len(distance)):
    tempDistance+=distance[i]
    if tempPrice > price[i+1]: # 거기서 넣어야한다. 즉 여태까지 거리만큼 계산후
        # price를 바꿔준다.
        result+= tempDistance * tempPrice
        tempDistance = 0
        tempPrice = price[i+1]

print(result + tempDistance * tempPrice)