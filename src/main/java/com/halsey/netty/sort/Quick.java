//package com.halsey.netty.sort;
//
///**
// * create by zhangyaohai
// * 2018-03-01 19:50
// **/
//class　Quick
//        {
//        　public　void　sort(int　arr[],int　low,int　high)
//        　{
//        　int　l=low;
//        　int　h=high;
//        　int　povit=arr[low];
//
//        　while(l<h)
//        　{
//        　while(l<h&&arr[h]>=povit)
//        　h--;
//        　if(l<h){
//        　int　temp=arr[h];
//        　arr[h]=arr[l];
//        　arr[l]=temp;
//        　l++;
//        　}
//
//        　while(l<h&&arr[l]<=povit)
//        　l++;
//
//        　if(l<h){
//        　int　temp=arr[h];
//        　arr[h]=arr[l];
//        　arr[l]=temp;
//        　h--;
//        　}
//        　}
//        　print(arr);
//        　System.out.print("l="+(l+1)+"h="+(h+1)+"povit="+povit+"\n");
//        　if(l>low)sort(arr,low,l-1);
//        　if(h<high)sort(arr,l+1,high);
//        　}
//        }
//
//
///*//////////////////////////方式二////////////////////////////////*/
//        更高效点的代码：
//public<TextendsComparable<?superT>>
//        T[]quickSort(T[]targetArr,intstart,intend)
//        {
//        inti=start+1,j=end;
//        Tkey=targetArr[start];
//        SortUtil<T>sUtil=newSortUtil<T>();
//
//        if(start>=end)return(targetArr);
//
//
///*从i++和j--两个方向搜索不满足条件的值并交换
//*
//*条件为：i++方向小于key，j--方向大于key
//*/
//        while(true)
//        {
//        while(targetArr[j].compareTo(key)>0)j--;
//        while(targetArr[i].compareTo(key)<0&&i<j)i++;
//        if(i>=j)break;
//        sUtil.swap(targetArr,i,j);
//        if(targetArr[i]==key)
//        {
//        j--;
//        }else{
//        i++;
//        }
//        }
//
///*关键数据放到‘中间’*/
//        sUtil.swap(targetArr,start,j);
//
//        if(start<i-1)
//        {
//        this.quickSort(targetArr,start,i-1);
//        }
//        if(j+1<end)
//        {
//        this.quickSort(targetArr,j+1,end);
//        }
//
//        returntargetArr;
//        }
//
//
///*//////////////方式三：减少交换次数，提高效率/////////////////////*/
//private<TextendsComparable<?superT>>
//        voidquickSort(T[]targetArr,intstart,intend)
//        {
//        inti=start,j=end;
//        Tkey=targetArr[start];
//
//        while(i<j)
//        {
///*按j--方向遍历目标数组，直到比key小的值为止*/
//        while(j>i&&targetArr[j].compareTo(key)>=0)
//        {
//        j--;
//        }
//        if(i<j)
//        {
///*targetArr[i]已经保存在key中，可将后面的数填入*/
//        targetArr[i]=targetArr[j];
//        i++;
//        }
///*按i++方向遍历目标数组，直到比key大的值为止*/
//        while(i<j&&targetArr[i].compareTo(key)<=0)
///*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/
//        {
//        i++;
//        }
//        if(i<j)
//        {
///*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
//        targetArr[j]=targetArr[i];
//        j--;
//        }
//        }
///*此时i==j*/
//        targetArr[i]=key;
//
///*递归调用，把key前面的完成排序*/
//        this.quickSort(targetArr,start,i-1);
//
//
//        /*递归调用，把key后面的完成排序*/
//    this.quickSort(targetArr,j+1,end);
//
//        }