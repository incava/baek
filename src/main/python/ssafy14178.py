t = int(input())
for tc in range(1,t+1):
    word = list(input())
    dic = dict()
    gorN = ""
    for i in word:
        if i in dic:
            del dic[i]
        else:
            dic[i]=1
    if dic:
        result = sorted(dic)
        elel = dict(sorted(dic.items()))
        for key in result:
            gorN+=key
    else:
        gorN = 'Good'
    print("#{} {}".format(tc,gorN))