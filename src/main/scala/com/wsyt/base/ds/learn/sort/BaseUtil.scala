package com.wsyt.base.ds.learn.sort

import scala.collection.mutable._
import scala.util.Random
import java.util._

/**
  *
  * @author ruyin_zh
  * @date 2020-09-22
  * @title
  * @description
  *
  */
object BaseUtil {

  private val rand = Random

  def main(args: Array[String]): Unit = {
    println(checkEquals())
  }


  def generateRandomArr():Seq[Int] = {
    val buffer: ArrayBuffer[Int] = ArrayBuffer.newBuilder[Int].result()
    val inclusive: Range.Inclusive = 0 to 30
    for (_ <- inclusive) {
      buffer += rand.nextInt(100)
    }

    buffer
  }

  def swap(arr: Array[Int],i:Int, j:Int): Unit = {
    val temp: Int = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def printArr(seq:Seq[Int]) = {
    for (elem <- seq) {
      print(s"$elem ")
    }
  }


  def checkEquals(): Boolean ={
    val arr: Array[Int] = generateRandomArr().toArray
    val arrBuf: ArrayBuffer[Int] = ArrayBuffer.newBuilder[Int].result()

    for (i <- arr.indices){
      arrBuf += arr(i)
    }

    Arrays.sort(arr)
    val cpArr: Array[Int] = arrBuf.toArray
    //SelectionSort.sort(cpArr)
    //BubbleSort.sort(cpArr)
    //InsertionSort.sort(cpArr)
    ShellSort.sort(cpArr)
    //MergeSort.sort(cpArr)

    var result = true
    for (i <- arr.indices) {
      if (arr(i) != cpArr(i)){
        result = false
      }
    }

    result
  }

}
