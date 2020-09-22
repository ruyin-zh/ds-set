package com.wsyt.base.ds.learn.sort

import scala.collection.mutable._
import scala.util.Random

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

  def generateRandomArr():Seq[Int] = {
    val buffer: ArrayBuffer[Int] = ArrayBuffer.newBuilder[Int].result()
    val inclusive: Range.Inclusive = 0 to 30
    for (_ <- inclusive) {
      buffer += rand.nextInt(100)
    }

    buffer
  }

  def main(args: Array[String]): Unit = {
    val ints: Seq[Int] = generateRandomArr()
    for (elem <- ints) {
      println(elem)
    }
  }


  def swap(arr: Array[Int ],i:Int, j:Int): Unit = {
    val temp: Int = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def printArr(seq:Seq[Int]) = {
    for (elem <- seq) {
      print(s"$elem ":String)
    }
  }

}
