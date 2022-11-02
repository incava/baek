fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (a,b,c) = br.readLine().split(" ").map { it.toLong() }
    fun test(dit: Long, exp: Long, div: Long):Long{
        if (exp == 1L) {
            return dit % div
        }
        else{
        var temp = test(dit,exp/2,div)
            return if (exp%2==1L) ((temp*temp)%div * dit) % div else temp*temp % div
        }
    }
    print(test(a,b,c).toInt())
}