package com.wsyt.base.ds.learn.sort

/**
  *
  * @author ruyin_zh
  * @date 2020-09-22
  * @title
  * @description
  *
  */
object Base {

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
