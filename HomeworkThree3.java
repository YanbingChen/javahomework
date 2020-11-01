package vanilla.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeworkThree3 {
    public static void main(String[] args){
        //初始化测试list为8,2,2.3,9,10,1,3.44,2.5,2,4,7
        ArrayList<Number> list= new ArrayList<>(Arrays.asList(8,2,2.3,9,10,1,3.44,2.5,2,4,7));
        sort(list);
        //以空格为分隔输出排序后结果
        for (int i=0;i< list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static void sort(ArrayList<Number> list){
        //每次从第1、2……n-1个比较至最末，每次都将最小的数放置最前
        for (int i=0; i< list.size();i++){
            Number tempmin=list.get(i);
            int tempminindex=i;
            for(int j=i+1; j< list.size();j++){
                if(tempmin.doubleValue()>list.get(j).doubleValue()){
                    tempmin= list.get(j);
                    tempminindex=j;
                }
            }
            if (tempminindex!=i){
                list.set(tempminindex,list.get(i));
                list.set(i,tempmin);
            }
        }
    }
}
