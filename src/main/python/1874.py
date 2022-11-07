import sys
def plus(num):
    stk.append(num)
    answer.append('+')
def minus():
    stk.pop()
    answer.append('-')
input = sys.stdin.readline
n = int(input().strip())
stk=[]
answer=[]
now = 1
for _ in range(n): #n번 
    num=int(input().strip())
    while(now <= num): #없거나 크면  append
        plus(now)
        now+=1
    if stk[-1]==num: #pop
        minus()
    else: #NO
        print('NO')
        sys.exit()

for i in answer:
    print(i)