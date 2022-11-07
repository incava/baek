N = int(input())
def pibonachi(N):
    if N == 0:
        return 0
    if N == 1:
        return 1
    return pibonachi(N-1)+pibonachi(N-2) #이게 즉 n 
print(pibonachi(N))
