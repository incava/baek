def fib(n):
    global fib_count
    if n == 1 or n ==2:
        fib_count+=1
        return 1
    else:
        return (fib(n-1)+fib(n-2))

def fibonacci(n):
    global fibonacci_count
    f[1] = f[2] = 1
    for i in range(3,n+1):
        f[i] = f[i-1] + f[i-2] 
        fibonacci_count+=1
    return f[n]

n = int(input())
f=[False for _ in range(n+1)]
fib_count=0
fibonacci_count=0
fib(n)
fibonacci(n)
print(fib_count,fibonacci_count)