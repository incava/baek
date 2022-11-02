import java.util.*

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    //val bw = System.`out`.bufferedWriter()
    val (n,m) = br.readLine().split(' ').map { it.toInt() }
    val deQueue:Deque<Int> = LinkedList()
    val arr = br.readLine().split(' ').map { it.toInt() }
    var cnt = 0
    for (i in 1 .. n)
        deQueue.add(i)
    for(j in 0 until m){
        val temp = arr[j]
        if (deQueue.peekFirst()!=temp){
            val index = deQueue.indexOf(temp)
            var mid = deQueue.size % 2
            mid = if (mid == 0) deQueue.size / 2 - 1 else deQueue.size / 2
            if (mid >= index){
                while(deQueue.peekFirst()!=temp){
                    deQueue.addLast(deQueue.pollFirst())
                    cnt+=1
                }
            }
            else {
                while (deQueue.peekFirst() != temp) {
                    deQueue.addFirst(deQueue.pollLast())
                    cnt += 1
                }
            }
        }
        deQueue.pollFirst()
    }
    println(cnt)
}