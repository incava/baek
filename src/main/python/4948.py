from math import sqrt
def isprime(su):
    for k in range(2,int(sqrt(su))+1):
        if su % k == 0:
            return 0 #소수가아니다.
    return 1

while(True):
    n = int(input())
    count = 0
    if n == 0:
        break
    for i in range(n+1,2*n+1): # n보다 크고 2n보다 크거나 같다.
        count = count + isprime(i)
    print(count)