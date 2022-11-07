import re
n = input()
arr  = re.split('([-|+])',n)
result = []
temp = 0
flag = False
print(arr)
for i in arr:
    if flag==True: #전게 +일때
        temp = temp+int(i)
        flag = False
    elif i == '+':
        flag = True
    elif i == '-':
        result.append(temp)
        result.append(i)
    else: # 숫자일때
        temp = int(i)
result.append(temp)
print(result)
total = result[0]
for i in range(2,len(result),2):
    total-=result[i]
print(total)