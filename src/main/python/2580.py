def check(x,y,num): # x,y는 좌표
    x1 = (x//3)*3
    y1 = (y//3)*3
    for i in range(x1,x1+3): # 3x3 같은수 체크
        for j in range(y1,y1+3):
            if arr[i][j] == num and (i != x or j != y): # 값이 같으면 0
                return 0
    for i in range(9): # 
        if (arr[i][y] == num and i!=x) or (arr[x][i] == num and i!=y): 
            return 0
    return 1

def Sudoku(depth):
    if depth==len(blank):
        for i in range(9):
            print(*arr[i])
        exit(0)
    for num in range(1,10):
        x = blank[depth][0]
        y = blank[depth][1]
        if check(x,y,num):
            arr[x][y] = num
            Sudoku(depth+1)
            arr[x][y] = 0

arr = [list(map(int,input().split())) for _ in range(9)]
blank=[]
for i in range(9):
    for j in range(9):
        if arr[i][j]==0:
            blank.append((i,j))
Sudoku(0)

    