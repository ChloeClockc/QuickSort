public class QuickSort
{
    public static void qsort( int low,int high,int array[])
    {
      if (high <=low || array == null || array.length <= 1) //数组为空，数组就一个元素以及左边下标大于右边等非法输入考虑
      {
          return;
      }

        int l=low;
        int h=high;
        int pivot=array[(low+high)/2]; //设定标杆值

        while (l<h)
        {   //l一直在h左边
            while ( array[h] >pivot)   //不能有等于 否则会导致h越界(所有值一样情况下,最左边值为标杆时)
            {
                --h;
            }
            while (array[l] <pivot)//不能有等于 否则会导致h越界(所有值一样情况下,最右边值为标杆时)
            {
                l++;
            }
            if (l < h)
            {
                int temp = array[l];
                array[l] = array[h];
                array[h] = temp;
//                 完成一轮，此时变为, 0, 4, 8, 2, 55, 3, 4, 8, 6, 4, 1, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10
                int i=1;  String out="";
                for(int re:array)
                {
                    out+=(re+",");
                }
                System.out.println(out);
                i++;
//                System.out.println(i); 想输出 “第i次结果为多少这种格式，可是i循环加不能用，所以就注释掉了”

                l++;
                h--; // 继续进行与标杆对比的操作
            } else if (l == h)
            {
                l++; //此时左右下标汇合，意味着标杆左右侧大致分好了，下面是分别对左右进行排序，所以l+1，一次为右边部分开始下标。
            }
        }
            qsort(low,h,array);
            qsort(l,high,array);
    }

        public static  void main (String[] args)
        {
           int [] array = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
//             int [] array = new int[]{9, 4, 8,7};
//           int [] array = new int[]{1,1,1,1}; //测试与标杆值对比的等于情况
             qsort(0,array.length-1,array); // 第一次把输入带进排序函数
             String out="";
             for(int re:array)   //循环输出数组值
             {
                 out+=(re+",");
             }
            System.out.println( "排序结果为");
             System.out.println(out);
        }
}



