import java.util.PriorityQueue
import kotlin.math.min

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val pq1 = PriorityQueue<Int>(reverseOrder()) //최대를 뽑는것
    val pq2 = PriorityQueue<Int>() //최소를 뽑는것
    var num:Int
    num = br.readLine().toInt()
    pq1.add(num)
    bw.write("${num}\n")

    for (i in 0 until n-1){
        num = br.readLine().toInt()
    if (pq1.size == pq2.size){ // 둘다 같으면 qp1에 넣고 가운데 중심맞추기 위해 확인 후 pq2에 넣기

        if (pq2.peek() < num) // pq1 위를 확인 후 num이 더 작으면 pq1에 넣어야하므로
        {
            pq1.add(pq2.poll()) // pq2에 넣고 num을 pq1에 넣는다.
            pq2.add(num)
        }
        else pq1.add(num) //만약 num이 더크면 그냥 qp2에 넣으면 끝.
        bw.write("${pq1.peek()}\n")
    }
    else{ // pq2에 넣어야하므로
        if (pq1.peek() > num) // pq1 위를 확인 후 num이 더 크면 pq2에 넣어야하므로
        {
            pq2.add(pq1.poll()) // pq2에 넣고 num을 pq1에 넣는다.
            pq1.add(num)
        }
        else pq2.add(num) //만약 num이 더크면 그냥 qp2에 넣으면 끝.
        bw.write("${min(pq1.peek(),pq2.peek())}\n")
    }
        /////////////////여기까지가 넣기는 끝.
    }
//    while(pq2.isNotEmpty()) print("${pq2.poll()} ")
//    while (pq1.isNotEmpty()) print("${pq1.poll()} ")
//    println()
    bw.close()
}