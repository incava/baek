fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val array = ArrayList<IntArray>()

    for (i in 0 until n) {
        var temp = br.readLine()
        var word = IntArray(n) { 0 }
        for (i in 0 until temp.length) {
            word[i] = temp[i] - '0'
        }
        array.add(word)
    }
    fun cal(x: Int, y: Int, size: Int):Boolean{
        val temp = array[x][y]
        for (i in x until x+size){
            for (j in y until y+size){
                if (temp!=array[i][j])
                    return true
            }
        }
        print(temp)
        return false
    }

    fun test(x: Int, y: Int, size: Int) {
        if (size == 1) {
            print(array[x][y])
            return
        }
        else {
            if (cal(x,y,size)){
                print("(")
                test(x,y,size/2)
                test(x,y+size/2,size/2)
                test(x+size/2,y,size/2)
                test(x+size/2,y+size/2,size/2)
                print(")")
            }
            return
        }
    }
    test(0,0,n)
}
