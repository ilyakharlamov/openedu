package W1.T1

import java.util.*
import java.io.File
import java.io.Writer

/**
 * Created by ilyakharlamov on 2017-03-05.
 */
fun main(args: Array<String>) {
    val out = File("output.txt").printWriter()
    val s = Scanner(File("input.txt").inputStream())
    W1.T2.solution(s, out)
    out.close()
}

fun solution (s: Scanner, out: Writer) {
    val int1 = s.nextInt()
    val int2 = s.nextInt()
    out.write((int1 + int2).toString())
}