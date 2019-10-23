import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun getMaxIndex(array: Array<Array<Int>>, start: Int) : Int {
    var max = array[start]
    var maxIndex = start
    for(i in start until array.size) {
        val item = array[i]
        if(max[0] < item[0]) {
            max = item
            maxIndex = i
        }
    }
    return maxIndex
}
// Complete the luckBalance function below.
fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    var luckCount = 0
    var kSum = 0
    for((i,round) in contests.withIndex()) {
        val pos = getMaxIndex(contests, i)
        val temp = contests[i]
        contests[i] = contests[pos]
        contests[pos] = temp
        val currentK = contests[i][1]
        if(kSum + currentK <= k) {
            luckCount += contests[i][0]
            kSum += currentK
        }
        else {
            luckCount -= contests[i][0]
        }
    }
    return luckCount
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val contests = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        contests[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}
