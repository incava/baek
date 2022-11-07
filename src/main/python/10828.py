import sys
n = int(sys.stdin.readline())
arr = []
for i in range(n):


    cmd = sys.stdin.readline().strip()
    if cmd.find('push')!=-1:
        psh,num = cmd.split()
        arr.append(num)
    else:
        if cmd == 'empty':
            print(1) if not arr else print(0)
        elif cmd == 'size':
            print(len(arr))
        elif not arr: 
            print(-1)
        elif cmd == 'pop':
            print(arr.pop())
        elif cmd == 'top':
            print(arr[-1])