package W1.T5

import java.util.*
import java.io.File
import java.io.Writer

fun main(args: Array<String>) {
    val out = File("output.txt").printWriter()
    val s = Scanner(File("input.txt").inputStream())
    solution(s,out)
    out.close()
}

fun solution (s: Scanner, out: Writer) {
    val size = s.nextInt()
    val money = Array<Int>(size, {s.nextInt()})
    val people = Array<Int>(size,{0})
    for (manId in 0..money.size-1) {
        people[manId]=manId;
        var j = manId
        while (j-->0 && money[people[j+1]] < money[people[j]]) {
            people.swap(j+1,j)
        }
    }
    writeSwaps(out, people)
    out.write("No more swaps needed.\n")
    out.write(people.map { money[it] }.joinToString (" ")+"\n")
}

fun writeSwaps(out: Writer, people: Array<Int>) {
    val tmp = Array<Int>(people.size, {it->it})
    for (i in 0..people.size - 1) {
        val cur = people[i]
        val curIdx = tmp.indexOf(cur)
        if ( curIdx > i) {
            tmp.swap(i, curIdx)
            out.write("Swap elements at indices ${i+1} and ${curIdx+1}.\n")
        }
    }
}

fun Array<Int>.swap(j: Int, i: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j]=tmp
}
