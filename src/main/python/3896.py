from math import sqrt
def isprime(num):
    for i in range(2,int(sqrt(num))+1):
        if num % i == 0:
            return 0
    return 1

T = int(input())
for i in range(T):
    k = int(input())
    temp2 = k+1
    if isprime(k)==0: #합성수
        while(isprime(k)==0):
            k-=1
        while(isprime(temp2)==0):
            temp2+=1
        print(temp2-k)
    else:
        print(0)   