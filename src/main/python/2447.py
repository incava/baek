N=int(input())

def star(N):
    if N == 1:
        return "*"
    c = []
    for j in range(3):
        if j == 1:
            c.append(star(N//3) + len(star(N//3)) * "  " + star(N//3))
        else:
            c.append(star(N//3) * 3)
        c.append("\n")
    return c
print(star(N))   
#return star(N//3)*3+" "*(N/3)(N/3)+star(N//3)*3

