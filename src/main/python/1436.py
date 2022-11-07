N = int(input()) # N번째 인지 입력값
M = 664 #초깃값
count = 0
def sixCheck(M): # 6이 연속 3번인지 확인하는 함수
    cnt = 0 # 연속을 세는 변수
    while(M): 
        if M % 10 == 6: # 일의자리숫자가 6이면?
            cnt = cnt + 1 #연속 변수 +1
        else:    #아니면? 다시 0으로 초기화
            cnt = 0 
        if cnt == 3: #연속 3번이라면 return
            return True
        M = M // 10
    return False #끝났는데도 없으면 false return 

while(N > count): # 666연속 갯수를 N만큼 찾으면 
    M = M + 1  #else쓰기 싫어서 위에 썼고, 없으면 다음 값 주기
    if sixCheck(M) == True: #찾으면 count +1
        count = count + 1 
print(M)