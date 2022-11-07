n = input()
result = 0
flag = -1
num = ''
for i in n:
    if i =="+" or i == "-":
        if flag == 1: #전게 +일때
            result -= int(num)
        else:
            result +=int(num)
        num = ''
        if i == '-':
            flag = True
    else: # 숫자일때
        num += i
print(result+(-1 * flag * int(num)))