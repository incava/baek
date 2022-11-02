fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toLong() }
    val div:Long = 1000000007
    fun test(dit: Long, exp: Long):Long{ //제곱
        if (exp == 1L) {
            return dit % div
        }
        else{
            var temp:Long = test(dit,exp/2)
            return if (exp%2==1L) ((temp*temp)%div * dit) % div else temp*temp % div
        }
    }
    fun factorial(N: Long):Long{
        var fac = 1L
        for( N in N downTo  1) {
            fac = (fac * N) % div
        }
        return fac % div
    }

    val numer = factorial(n)
    val denom = factorial(k) * factorial(n-k) % div
     println(numer * test(denom,div-2) % div)
}