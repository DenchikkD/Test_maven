package hashMap;

import java.util.HashMap;

/**
 * Created by Iliren on 29.09.2016.
 */
public class MyHashMapMain {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        System.out.println(map.get(15));


        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(5,null);
        myHashMap.put(null,1);
            myHashMap.put(8765,5);

            myHashMap.put(3456,15);
            myHashMap.put(9876,45);
            myHashMap.put(654,54);
            myHashMap.put(654,57);




        System.out.println(myHashMap);
        System.out.println(myHashMap.get(15));
        System.out.println(myHashMap.containsKey(null));
    }
}
