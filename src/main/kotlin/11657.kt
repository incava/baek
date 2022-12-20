fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(' ').map { it.toInt() }
    val inf = Int.MAX_VALUE
    val distance:Array<Long> = Array(n+1){inf.toLong()} // 거리
    val arrayList = ArrayList<Triple<Int,Int,Int>>()
    repeat(m){
        val (a,b,c) = br.readLine().split(' ').map { it.toInt() } // a는 시작도시 b는 도착도시 c는 비용
        arrayList.add(Triple(a,b,c))
    }


    fun bellman(start:Int):Boolean{
        distance[start] = 0
        for(i in 0 until n){
            for(temp in arrayList){
                if(distance[temp.first]!= inf.toLong() && distance[temp.second] > distance[temp.first] + temp.third){
                    distance[temp.second] = distance[temp.first] + temp.third
                    if (i == n - 1)
                        return true // 만약 마지막이면서 if문을 지났다는 것은 음수 순환이 일어났다는 뜻.
                }
            }
        }
        return false
    }

    if (bellman(1))
        bw.write("-1\n")
    else
        {
            distance.drop(2).forEach{ if (it==inf.toLong()) bw.write("-1\n") else bw.write("${it}\n") }
        }
    bw.close()
}