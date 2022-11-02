fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (N,C) = br.readLine().split(' ').map { it.toInt() }
    var arr = Array<Long>(N){0}
    for (i in 0 until N){
        arr[i] = br.readLine().toLong()
    }
    arr.sort()
    var first = 1L //최소길이
    var last = arr[N-1] - arr[0] // 최대길이
    var temp:Long
    var mid:Long
    var result = 0L

    while(last>=first){ //탐색의 범위가 벗어나면 그만!
        mid = (last+first) / 2 //절단
        temp= 1L //공유기 설치 갯수
        var prev = arr[0]
        for (i in 1 until N){
            if (arr[i]-prev>=mid){ //거리차를 계산해 기준보다 이상이여야한다.
                temp +=1
                prev = arr[i]
            }
        }
        if (temp >= C) { //공유기 설치를 줄이기 위해. -> 줄여야 더 거리가 최대가 되기때문.
            result = mid
            first = mid + 1
        }
        else
            last = mid - 1
    }
    println(result)
}