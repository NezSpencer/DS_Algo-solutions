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

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
    var bribeCount = 0
    var isChaotic = false
    for((i,j) in q.withIndex()) {
        val value = i+1 // make it 1-index
        if(j - value > 2) {
            isChaotic = true;
            break;
        }
        else {
        /**
        any person that bribes a person at position j can only move at most to position j-1 else the move is chaotic. Therefore to find the number of people that bribed person at original position j, check for numbers greater than j between the range j - 1 (in our case j -2, since array is 1-indexed) and final position of person j i.e i.
        */
            for(x in Math.max(0,j -2)..i) {
                if(q[x] > j)
                    bribeCount++
            }
        }
    }
    println(if(isChaotic) "Too chaotic" else bribeCount.toString())
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
