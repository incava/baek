fun main() {
    val br = System.`in`.bufferedReader()
    val (n,c) = br.readLine().split(' ').map { it.toInt() }
    var ary = br.readLine().split(' ').map { it.toInt() }
    var left = ArrayList<Long>()
    var right = ArrayList<Long>()
    var cnt:Long = 0
    fun dfs(start:Int,end:Int,lst:ArrayList<Long>,value:Long){
        if(start > end){
            lst.add(value)
            return
        }
        else{
            dfs(start+1,end,lst,value) //원래 있던 ary
            dfs(start+1,end,lst,value + ary[start]) //자신을 포함하고 sum까지의 ary
        }
    }
    fun binary_search(s:Int, e:Int, key:Long, arr:ArrayList<Long>):Int{
        var start = s
        var end = e
        while (start < end){
            var mid = (start + end)/2
            if (arr[mid] <= key) {
                 start = mid + 1
            }
            else {
                end = mid
            }
        }
    return end
    }

    dfs(0,n/2-1,left,0)
    dfs(n/2,n-1,right,0)
    right.sort()
    for(i in left){
        val x: Long = (c - i) // left 빼고 남은 무게.
        cnt += binary_search(0,right.size,x,right)
    }
    print(cnt)
}