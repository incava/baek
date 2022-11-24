# t = int(input())
# for tc in range(1,t+1):
#     a,b = input().split()
#     flag = False
#     if  b * len(a) == a * len(b):
#         flag = True
#     print("#%d %s" %(tc,'yes' if flag else 'no'))
    #최소공배수
def lcm(a,b):
    for i in range(max(a,b),a*b+1):
        if i % a == 0 and i % b == 0:
            return i
