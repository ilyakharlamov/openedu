package W1.T3

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
    val size = s.nextInt()
    val arr = Array<Int>(size, {s.nextInt()})
    val arrIdx = Array<Int>(size, {0});
    for (i in 0..size-1) {
        var j = i
        while (j>0 && arr[j]<arr[j-1]) {
            arr.swap(j,j-1)
            j--
        }
        assert(arr.isSorted(0, i))
        arrIdx[i]=j+1
    }
    assert(arr.isSorted(0, size-1))
    out.write(arrIdx.joinToString(" "))
    out.write("\n")
    out.write(arr.joinToString(" "))
}

private fun Array<Int>.swap(j: Int, i: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j]=tmp
}

private fun Array<Int>.isSorted(lo: Int, hi: Int): Boolean {
    return (lo + 1..hi).all({this[it - 1] < this[it]})
}
