def TF(word):
    stk = []
    for j in range(len(word)):
        if word[j] == '(':
                stk.append('(')
        else:
            if not stk:
                return print('NO')
            else:
                stk.pop()
    return print('YES') if not stk else print('NO')

n = int(input())
for i in range(n):
    TF(input())