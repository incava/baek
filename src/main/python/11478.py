
N = input()
dic = {}
for i in range(len(N)):
    for j in range(i+1,len(N)+1):
        dic[N[i:j]] = 1
        print(i,j)
print(len(dic))


