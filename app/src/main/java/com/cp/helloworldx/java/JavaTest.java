package com.cp.helloworldx.java;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
class ParentGeneric<T> {

}

class SubClass extends ParentGeneric<String> {

}

class SubClass2<T> extends ParentGeneric<T> {

}

public class JavaTest {



    //获取实际的泛型类型
    public static <T> Type findGenericType(Class<T> cls) {
        Type genType = cls.getGenericSuperclass();
        Type finalNeedType = null;
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            finalNeedType = params[0];
        }
        return finalNeedType;
    }


    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        SubClass2<Integer> subClass2 = new SubClass2<Integer>();
        //打印 subClass 获取的泛型
        System.out.println("subClass: " + findGenericType(subClass.getClass()));
        //打印subClass2获取的泛型
        System.out.println("subClass2: " + findGenericType(subClass2.getClass()));

        Number number = new Integer(666);
        List<Integer> aa = new ArrayList<Integer>();
        aa.add(1);

        setNumberData(new ArrayList<Number>());
    }


    public static void setNumberData(List<? super Number> data){
        data.add(111);
        data.add(11.22f);
    }
}
