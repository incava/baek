from math import sqrt

N = int(input())
if N == 1:
    N = 0
else:   
    for i in range(2,N+1):
        while(N % i == 0):
            N = N // i 
            print(i)
        