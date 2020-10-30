package com.wsyt.base.ds.learn.sort

/**
  *
  * @author ruyin_zh
  * @date 2020-10-29
  * @title 基数排序
  * @description  1、描述:基数排序是一种非比较型排序,核心是将数值按位切割成不同数字,进而每个位进行比较;基数排序不是比较排序,而是通过分配和手机的过程来实现排序;
  *               2、实现方式:目前存在两类,一类为LSD(Least Significant Digit first),一类为MSD(Most Significant Digit first);
  *               3、LSD步骤:1)、准备一个二维数组(记录桶元素)及一个一维数组(记录个数--避免循环二维数组一列的所有元素),一维下标为10,表示数值在0-9之间;
  *                         2)、从低位开始,进行多趟分配与收集;
  *                         3)、每一趟的分配及收集的结果重新映射到原数组中,每一趟的重新映射都是局部有序,最后一趟会保证全局有序;
  *               4、MSD步骤:1)、
  *                         2)、
  *                         3)、
  *
  */
object RadixSort {


  def main(args: Array[String]): Unit = {
    //val arr = Array(1,3,4,6,7,9,11,12,15,81,92,211,985,123,453,1000)
    val arr = Array(81,1,985,453)

    lsdRadixSort(arr,1000)

    //msdRadixSort(arr,arr.length,1000)
    BaseUtil.printArr(arr)
  }


  private def lsdRadixSort(arr:Array[Int], maxVal:Int): Unit ={
    //代表位数对应的系数,1、10、100...
    var coefficient = 1
    //
    var arrIndex = 0
    val length = arr.length
    //映射桶当中的数据
    val bucket = Array.ofDim[Int](10,length)
    //不同桶当中的数据个数
    val counter = Array.ofDim[Int](10)

    //根据系数从小到大进行筛选,由系数决定循环次数
    while (coefficient <= maxVal){
      //将数组arr中的数值放在对应的桶内
      arr.foreach(num => {
        //定位分隔的每个数所在位置
        val digit = num / coefficient % 10
        //bucket数组与counter组合记录元素位置及元素个数
        bucket(digit)(counter(digit)) = num
        counter(digit) = counter(digit) + 1
      })

      //循环每个桶当中的数据
      for (i <- 0 until 10){
        val count: Int = counter(i)
        if (count > 0){
          for (j <- 0 until count){
            arr(arrIndex) = bucket(i)(j)
            arrIndex = arrIndex + 1
          }
        }

        counter(i) = 0
      }

      coefficient = coefficient * 10
      arrIndex = 0
    }
  }


  /**private def msdRadixSort(arr:Array[Int], length:Int, maxVal:Int): Unit ={
    val bucket = Array.ofDim[Int](10,length)
    val counter = Array.ofDim[Int](10)

    var arrIndex = length - 1
    var coefficient = maxVal

    while (coefficient >= 1){

      arr.foreach(num => {
        val digit = num / coefficient % 10
        bucket(digit)(counter(digit)) = num
        counter(digit) = counter(digit) + 1
      })

      for (i <- 9 to 0 by -1){
        val ct: Int = counter(i)
        if (ct > 0){
          if (ct == 1){
            arr(arrIndex) = bucket(i)(0)
            arrIndex = arrIndex - 1
          }else{
            msdRadixSort(bucket(i),arrIndex,coefficient / 10)
          }
        }

        //counter(i) = 0
      }
      coefficient = coefficient / 10
      //arrIndex = 0
    }

  }*/
}
