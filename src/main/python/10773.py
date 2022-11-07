n = int(input())
stk = []
for i in range(n):
    temp = int(input())
    if temp:
        stk.append(temp)
    else:
        stk.pop()
print(sum(stk))