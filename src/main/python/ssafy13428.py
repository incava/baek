# t = int(input())
# for q in range(1,t+1):
#     arr = []
#     num = int(input())
#     length = len(str(num))
#     maxNum = num
#     minNum = num
#     for i in range(length): #앞에있는수 
#         for j in range(i+1,length): #뒤에있는 수
#             temp1 = (arr[i]*10**(length-i-1)) # 빼려는 수
#             temp2 = (arr[j]*10**(length-i-1)) # 넣으려는 수
#             temp3 = (arr[i]*10**(length-j-1)) # 넣으려는 수
#             temp4 = (arr[j]*10**(length-j-1)) # 빼려는 수
#             temp = num - temp1 + temp2 + temp3 - temp4
#             if temp < 10**(length-1):
#                 continue
#             minNum = min(temp,minNum)
#             maxNum = max(temp,maxNum)
#     print("#%d %d %d"%(q,minNum,maxNum))

t = int(input())
for q in range(1,t+1):
    arr = list(input())
    length = len(arr)
    maxNum = int(''.join(arr))
    minNum = int(''.join(arr))
    for i in range(length-1): #앞에있는수 
        for j in range(i+1,length): #뒤에있는 수
            arr[i] , arr[j] = arr[j] , arr[i]
            if arr[0] !='0':
                minNum = min(minNum,int(''.join(arr)))
                maxNum = max(maxNum,int(''.join(arr)))
            arr[j] , arr[i] = arr[i] , arr[j]
    print("#%d %d %d"%(q,minNum,maxNum))