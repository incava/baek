fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    var arr = Array(2){ LongArray(2) {1}}
    val div = 1_000_000_007
    arr[1][1] = 0
    fun mulCal(arr1:Array<LongArray>,arr2:Array<LongArray>):Array<LongArray>{
        var tempArr = Array(2){ LongArray(2) {0}}
        for (i in arr1.indices){
            for(j in 0 until arr2[0].size){
                for (k in 0 until 2){
                    tempArr[i][j] = (tempArr[i][j] + arr1[i][k] * arr2[k][j]) % div
                }
            }
        }
        return tempArr
    }
    fun multipleTest(arr:Array<LongArray>,n:Long) : Array<LongArray>{
       if (n==1L)
        return arr
       else{
           var test = multipleTest(arr,n/2)
           return if (n%2==1L) mulCal(mulCal(test,test),arr) else mulCal(test,test)
       }
    }
    print(multipleTest(arr,n)[1][0])
}

