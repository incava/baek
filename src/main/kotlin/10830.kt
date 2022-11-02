fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val line = readln().split(" ").filter { it.isNotBlank() }
    val n = line.first().toInt()
    val exp = line.last().toLong()
    var Aarray = ArrayList<IntArray>()
    for (i in 0 until n){
        var temp = br.readLine().split(' ').map { it.toInt()}.toMutableList()
        for (j in 0 until  n)
            temp[j] %= 1000
            Aarray.add(temp.toIntArray())
        }
    fun cal(array1: ArrayList<IntArray>,array2: ArrayList<IntArray>): ArrayList<IntArray> {
        var rstArray = ArrayList<IntArray>()
        for (i in 0 until n) { // n행렬
            var tempArray = IntArray(n)
            for (j in 0 until n) { // K행렬
                for (k in 0 until n) {
                    tempArray[j] += array1[i][k] * array2[k][j]
                }
                tempArray[j] %= 1000
            }
            rstArray.add(tempArray)
        }
        return rstArray
    }

    fun test(ary:ArrayList<IntArray>,exp:Long):ArrayList<IntArray>{
        if (exp == 1L) {
            return ary
        }
        else{
            var temp = test(ary,exp/2)
            return if (exp%2==1L) cal(cal(temp,temp),ary) else cal(temp,temp)
        }
    }
        test(Aarray,exp).forEach { row ->
        row.forEach { column -> print("$column ") }
        println()
    }
}