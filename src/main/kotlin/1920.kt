fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    var compArr = br.readLine().split(' ').map { it.toInt() }


    for(i in 0 until m){
        var wanted = compArr[i]
        var first = 0
        var last = n
        var flag = false
        while(true){
            var temp = first + (last-first)/2
            if(wanted == arr[temp]){
                break
            }
            else if(last-first <= 1){
                flag = true
                break
            }
            else if(wanted > arr[temp]){
                first = temp
            }
            else if(wanted < arr[temp]){
                last = temp
            }
        }
        if (flag) bw.write("0\n") else bw.write("1\n")
    }
    bw.close()
}