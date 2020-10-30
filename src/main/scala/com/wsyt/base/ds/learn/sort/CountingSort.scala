package com.wsyt.base.ds.learn.sort

/**
  *
  * @author ruyin_zh
  * @date 2020-09-23
  * @title 计数排序
  * @description  1、描述:核心在于将输入的数据值转化为键存储在额外开辟的数组空间中,计数排序要求输入数据必须是确定范围的整数
  *               2、步骤:1)、找出待排序数组的最大和最小的元素;
  *                      2)、统计数组中每个值为i的元素出现的次数,存入数组C的第i项;
  *                      3)、反向填充目标数组:将每个元素i放在新数组的第C(i)项,每放入一个元素就将C(i)减1;
  *               3、稳定性:稳定
  *
  */
object CountingSort {


  def main(args: Array[String]): Unit = {

    //val arr = Array(4,4,5,2,3,5,7,7,8,9,9,1,1,2,6)

    val arr = Array(103,101,104,101,103,102,105,109,101,108,102,107,103,106,104)

    sort(arr)
  }

  def sort(arr:Array[Int]): Unit ={

    val maxMinVal = getMaxMinValue(arr)

    val sortedArr: Array[Int] = countingSort(arr,maxMinVal)

    BaseUtil.printArr(sortedArr)
  }

  /**
    *
    * 计数排序
    *
    * */
  private def countingSort(arr:Array[Int], maxMinVal: (Int,Int)):Array[Int] = {
    val maxVal = maxMinVal._1
    val minVal = maxMinVal._2
    //计算实际数组大小
    val bucketSize = maxVal - minVal + 1

    val bucket = new Array[Int](bucketSize)

    //针对每项数值进行统计
    arr.foreach(value => { bucket(value - minVal) = bucket(value - minVal) + 1})

    var arrIndex = 0
    //依次从每个bucket中取出全部元素
    for(i <- 0 until bucketSize){
      while (bucket(i) > 0){
        //恢复实际位置数值
        arr(arrIndex) = i + minVal
        arrIndex = arrIndex + 1
        bucket(i) = bucket(i) - 1
      }
    }

    arr
  }

  /**
    *
    * 计算最大最小值,方便后续数组申请
    *
    * */
  private def getMaxMinValue(arr:Array[Int]):(Int,Int) = {
    var maxVal = arr(0)
    var minVal = maxVal

    arr.foreach(value => {
      if (maxVal < value){
        maxVal = value
      }

      if (minVal > value){
        minVal = value
      }
    })

    Tuple2(maxVal,minVal)
  }

}
