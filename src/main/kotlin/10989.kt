fun main(args: Array<String>){
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val N: Int = br.readLine().toInt()
    var counting = IntArray(10001)
    for(i in 0 until N){ // array담기
        counting[br.readLine().toInt()-1] +=1
    }
    br.close()
    //counting.forEach { println(it) }
    for (i in counting.indices) {
        bw.write("${i+1}\n".repeat(counting[i]))
        }
    bw.close()
    }