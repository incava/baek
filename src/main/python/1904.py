# 1개로 1개
# 2개로 00 11 2개 
# 3개로 100 001 111 3개 
# 4개로 1100 1001 0011 0000 1111  5개 
# 5개는? 11111 00001 00100 10000 11100 11001 10011 00111  8개
# 6개는? 111111 000000 111100 001111 111001 100111 110011 110000 000011 100001  / 001100 100100 001001  13개
N = int(input())            
arr = [0] * (N + 1)  
arr[1]=1
arr[2]=2
def tile(N):
    for i in range(3,N+1):
        arr[i] = (arr[i-1] + arr[i-2] ) % 15746
    return arr[N]
print(tile(N))
