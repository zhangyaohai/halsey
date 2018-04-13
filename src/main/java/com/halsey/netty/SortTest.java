package com.halsey.netty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SortTest {  
//    public static void combiantion(String[] chs){
//        if(chs==null||chs.length==0){
//            return ;
//        }
//        List<String> list=new ArrayList<String>();
//        for(int i=1;i<=chs.length;i++){
//            combine(chs,0,i,list);
//        }
//    }
    //从字符数组中第begin个字符开始挑选number个字符加入list中  
//    public static String combine(String[] cs,int begin,int number,List<String> list){
//    	String s = "";
//        if(number==0){
//        	String[] str = list.toArray(new String[list.size()]);
//			s = StringUtils.join(str, "-");
//			System.out.println(s);
//            return s;
//        }
//        if(begin==cs.length){
//            return "";
//        }
//        list.add(cs[begin]);
//        combine(cs,begin+1,number-1,list);
//        list.remove(cs[begin]);
//       return combine(cs,begin+1,number,list);
//    }
    public static void main(String args[]) {
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		List<String> list2 = new ArrayList<String>();
		list2.add("c");
		list2.add("d");
		List<String> list3 = new ArrayList<String>();
		list3.add("e");
		list3.add("f");
		build(list1, list2, list3);
	}
	static List<String>  result = new ArrayList<String>();
    static int index = 0;
	public static void build(List<String>... lists){
		int size = lists.length;
		List<String> maxList = maxList(lists);
		for (int i = 0; i < maxList.size(); i++) {
			StringBuffer  sb = new StringBuffer();
			for(int j = 0;j<size; j++){
				if(lists.length < i)
					sb.append(lists[j].get(i)).append("-");
			}
			result.add(sb.toString());
		}
		System.out.println(result.toString());
		index++;
		List<String>[] listem = Arrays.copyOfRange(lists,index, lists.length-1);
		size--;
		if(size > 0){
			build(listem);
		}
	}

	public static List<String> maxList(List<String>... lists){
		final List<String> result = new ArrayList<>() ;
		Arrays.stream(lists).forEach(lis->{
			if(result.size() < lis.size()){
				result.clear();
				result.addAll(lis);
			}
		});
		return result;
	}

}
