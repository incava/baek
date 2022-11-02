fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, Am) = br.readLine().split(' ').map { it.toInt() }
    var Aarray = ArrayList<IntArray>()
    for (i in 0 until n)
        Aarray.add(br.readLine().split(' ').map { it.toInt() }.toIntArray())
    val (Bm, K) = br.readLine().split(' ').map { it.toInt() }
    var Barray = ArrayList<IntArray>()
    for (i in 0 until Bm)
        Barray.add(br.readLine().split(' ').map { it.toInt() }.toIntArray())

    for (i in 0 until n){ // n행렬

        for (j in 0 until K){ // K행렬
            var result = 0
            for (k in 0 until Am){
                result+=Aarray[i][k] * Barray[k][j]
            }
            print("$result ")
        }
        println()
    }
}