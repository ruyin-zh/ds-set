package com.wsyt.base.ds.learn.sort

/**
 *
 * @Author ruyin_zh
 * @Date 2020/9/22
 * @Title 插入排序--简单排序
 * @Desc 从左到右以第二个元素为起始向前比较并交换
 *       从数组第二个位置开始向前比较:
 *         1)、依次与前面元素对比,若小于(也可大于)前面元素则交换位置,然后继续与前面元素对比直至数组头部;
 *         2)、循环1)步骤直至外层循环结束;
 *       若数组有序,时间复杂度将为n,空间复杂度为1;
 *
 * */
object InsertionSort {

  def sort(arr: Array[Int]): Unit ={
    val length: Int = arr.length

    //此处从1开始仅表示数组中需要比较的元素数
    for (i <- 1 until length){
      //此处从外层循环位置依次步长减1比较
      for (j <- i until 0 by -1 if arr(j) < arr(j-1)){
        BaseUtil.swap(arr,j,j-1)
      }
    }
  }

}
