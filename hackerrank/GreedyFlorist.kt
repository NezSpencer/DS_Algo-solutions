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

// Complete the getMinimumCost function below.
fun getMinimumCost(k: Int, c: Array<Int>): Int {
    var minCost = 0
    //sort array
    for((i,j) in c.withIndex()) {
        var max = j
        var maxIndex = i
        for(p in i+1 until c.size) {
            val pItem = c[p]
            if(max < pItem) {
                max = pItem
                maxIndex = p
            }
        }
        c[maxIndex] = c[i]
        c[i] = max
    }
    if(k >= c.size) {
        c.forEach{ minCost += it }
        return minCost
    }
    var count = 0
    var priceMult = 1
    while(count < c.size) {
        for(i in count until count + k) {
            if(i >= c.size) break
            minCost += priceMult * c[i]
            count++
        }
        priceMult++
    }
    return minCost
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)
}
