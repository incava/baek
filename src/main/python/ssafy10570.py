from math import ceil, sqrt
t = int(input())
for tc in range(1,t+1):
    a,b = map(int,input().split())
    first = int(ceil(sqrt(a)))
    last = int(sqrt(b))+1
    cnt = 0
    for i in range(first,last):
        temp1 = str(i)
        temp2 = str(i**2)
        if temp1[0]==temp1[-1] and temp2[0]==temp2[-1]:
            cnt+=1
    print("#{} {}".format(tc,cnt))