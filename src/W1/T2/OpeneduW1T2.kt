package W1.T2

import java.util.*
import java.io.File
import java.io.Writer

/**
 * Created by ilyakharlamov on 2017-03-05.
 */
fun main(args: Array<String>) {
    val out = File("output.txt").printWriter()
    val s = Scanner(File("input.txt").inputStream())
    solution(s,out)
    out.close()
}

fun solution (s: Scanner, out: Writer) {
    val l1 = s.nextLong()
    val l2 = s.nextLong()
    out.write((l2*l2+l1).toString())
}