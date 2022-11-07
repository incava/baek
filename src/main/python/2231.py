N = int(input())
def 분해합(N):
    for i in range(1,N+1):
        temp = i
        answer = temp
        while(temp): # 결국 temp는 0이 될때 False로 전환.
            answer = answer + temp % 10
            temp = temp // 10
        if answer == N:
            return i
    return 0
print(분해합(N))