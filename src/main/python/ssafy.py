n = int(input())
for T in range(1,n+1):
    result = 0
    word = input()
    for j in range(len(word)):
        if ord(word[j]) == 97+j:
            result+=1
        else:
            break
    print("#%d %d" %(T, result))

t = int(input())
for T in range(t):
    field = input()
    count = 0
    arr = []
    for i in field:
        if i =='.':
            if len(arr):
                arr.pop()
        elif i == '(':
            if len(arr) and arr[0]=="|":
                arr.pop()
                arr.append('(')
            else:
                arr.append('(')
        elif i == ')':
            arr.pop()
            count+=1
        elif i =="|":
            if len(arr): 
                if arr[0]!="|":
                    count+=1
                    arr.pop()
            else:
                arr.append('|')
    print("#%d %d" %(T, count))