word = input()
dic = dict()
left = 'qwertasdfgzxcvb'
for i in left:
    dic[i]=1
temp = word[0]
count = False
if temp in dic:
    count = True
flag = False
for i in range(1,len(word)):
    if count:
        if word[i] not in dic:
            count = False
        else:
            flag = True
            break
    else:
        if word[i] in dic:
            count = True
        else:
            flag = True
            break
if flag:
    print("no")
else:
    print("yes")
    