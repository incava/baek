from heapq import merge
import numbers


list = numbers[:50]

def mergeSort(list,p,q):
    if p>=q: return  # 결국 p와 mid보다 큰경우, 즉 q가 1일때끝내라.
    mid = (p+q) // 2 
    mergeSort(list,p,mid) #왼쪽과 오른쪽으로 나누기 위함.
    mergeSort(list,mid+1,q)
    merge(list,p,mid+1,q) # 병합.

def merge(list,left,right,end):
    merged=[]
    l,r = left,right
    while l < right and r <= end:
        if list[l] <= list[r]: # 첫째항끼리 비교,작은 수가 list에 append
            merged.append(list[l])
            l+=1
        else:
            merged.append(list[r])
            r+=1
    while l < right:
        merged.append(list[l])
    while r <=end:
        merged.append(list[r])

