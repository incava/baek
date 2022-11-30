import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (m,n) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(m){Array(n){0}}
    val visited = Array(m){Array(n){Array(2){0}}}
    val xx = arrayListOf(1,0,-1,0)
    val yy = arrayListOf(0,1,0,-1)
    repeat(m){x->
        var temp = br.readLine().toList()
        repeat(n){y->
            graph[x][y]=temp[y]-'0'
        }
    }
    fun bfs(x:Int,y:Int):Int{
        val que:Queue<Triple<Int,Int,Int>> = LinkedList() //3개의 매개변수를 큐에 넣는데 first와 second는 2차원 배열 x,y값 / third는 벽의 여부를 판단.
            que.offer(Triple(x,y,0))
        visited[x][y][0] = 1
        while(que.isNotEmpty()){
            val temp = que.element()
            if (temp.first == m-1 && temp.second == n-1)
                return visited[temp.first][temp.second][temp.third]
            que.poll()
            var cnt = temp.third
            val tempv1 = visited[temp.first][temp.second][0] //벽0번방문여부 및 카운트값
            val tempv2 = visited[temp.first][temp.second][1] //벽1번방문여부 및 카운트값
            for(i in 0 until xx.size){
                val tempxx = temp.first+xx[i]
                val tempyy = temp.second+yy[i]
                if(tempxx<0 || tempxx >=m || tempyy < 0 || tempyy >=n || visited[tempxx][tempyy][cnt]!=0) //이미 방문했으면
                    continue
                else if(graph[tempxx][tempyy] == 0){
                    if(cnt == 0) { //다음것이 0이고 깬적이 없으면
                        visited[tempxx][tempyy][0] = tempv1 + 1
                        que.offer(Triple(tempxx,tempyy,0))
                    }
                    else { //다음것이 0이고 깬적이 있으면
                        visited[tempxx][tempyy][1] = tempv2 + 1
                        que.offer(Triple(tempxx,tempyy,1))
                    }
                }
                else if(graph[tempxx][tempyy] == 1){
                    if (cnt == 0) { // 다음것이 1이고 깬적이 없으면
                        visited[tempxx][tempyy][1] = tempv1 + 1
                        que.offer(Triple(tempxx,tempyy,1))
                    }
                    else
                        continue // 만약 전에도 1이였고 이번에도 1이면 continue
                }
            }
        }
        return -1
    }
    bw.write("${bfs(0,0)}")
    bw.close()
}