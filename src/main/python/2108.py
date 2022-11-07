from collections import Counter
import sys
N = int(sys.stdin.readline())
arr =[] #result array
for i in range(N):
    arr.append(int(sys.stdin.readline()))
arr.sort()
print(round(sum(arr)/N))#산술

print(arr[(N-1)//2]) # 중앙값

count = Counter(arr).most_common()
if len(count) == 1:
    print(count[0][0]) #최빈
elif count[0][1] == count[1][1]:
    print(count[1][0]) #최빈
else:
    print(count[0][0]) #최빈

print(abs(arr[0]-arr[-1])) #범위