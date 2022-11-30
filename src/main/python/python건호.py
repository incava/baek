a = input().split()
b = map(float,input().split())
c = dict()
for i in range(len(a)):
    c[a[i]] = next(b)
print(c)