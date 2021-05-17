package com.cp.helloworldx.dataStructuresAlgorithm.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionX {
    /**
     * List 与 array 之间转换
     */
    public void transform(){
        List<Long> list = new ArrayList<>();
        Long[] array = list.toArray(new Long[list.size()]);

        list = Arrays.asList(array);
    }
}
