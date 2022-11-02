import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val array = ArrayList<IntArray>()
    var result = Array(3){0}
    for(i in 0 until n)
        array.add(br.readLine().split(" ").map { it.toInt() }.toIntArray())

    fun cal(x:Int,y:Int,size:Int):Boolean{
        val temp = array[x][y]
        for (i in x until x+size){
            for (j in y until y+size){
                if (temp!=array[i][j])
                    return true
            }
        }
        result[temp+1]+=1
        return false
    }

    fun cut(x:Int,y:Int,size:Int){
        if (size==1) {
            result[array[x][y]+1] += 1
            return
        }
        else {
            if (cal(x, y, size)) {
                var temp = size/3
                for(i in 0 until 3){
                    for (j in 0 until  3){
                        cut(x+i*temp, y+j*temp, temp)
                    }
                }
            }
        }
        return
    }
    cut(0,0,n)
    for (i in result)
        println(i)
}