import sys
input = sys.stdin.readline
N = int(input())
arr=[]
arr=list(map(int,input().split()))
Arr = list(set(arr))
def mergeSort(data):
    if len(data) <= 1:
        return data
    medium = len(data) // 2
    left = mergeSort(data[:medium])
    right = mergeSort(data[medium:])
    return merge(left, right)
def merge(left, right):
    result = [] # 두 개의 분할된 리스트를 병합하여 result를 만듦.
    
    while len(left) > 0 and len(right) > 0 : # 양 쪽 리스트에 원소가 남아 있다면
        # 두 하위 리스트의 첫 원소를 비교해 작은 것부터 result에 추가.
        if left[0] <= right[0]:
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))
            
    if len(left) > 0 : # 왼쪽 리스트에 원소 남아 있으면
        result.extend(left)
    if len(right) > 0 : # 오른쪽 리스트에 원소 남아 있으면
        result.extend(right)
    return result
Arr = mergeSort(Arr)
for i in arr:
    print(Arr.index(i),end=" ")