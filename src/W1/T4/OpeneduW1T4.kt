package W1.T4

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
    s.useDelimiter(" ")
    val money = Array<Int>(size, {s.next().replace(".","").trim().toInt()})
    val people = Array<Int>(size,{0})
    for (manId in 0..money.size-1) {
        people[manId]=manId;
        var j = manId
        while (j-->0 && money[people[j+1]] < money[people[j]]) {
            people.swap(j+1,j)
        }
    }
    out.write("%s %s %s".format(people.first()+1, people[(people.size/2)]+1, people.last()+1))
}

fun Array<Int>.swap(j: Int, i: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j]=tmp
}
