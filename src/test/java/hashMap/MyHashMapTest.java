package hashMap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denni on 9/29/2016.
 */
public class MyHashMapTest {
    @Test
    public void containsKey() throws Exception {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        boolean expected = false;
        assertEquals(expected, myHashMap.containsKey(""));
        assertEquals(expected, myHashMap.containsKey(null));
        expected = true;
        myHashMap.put("",1);
        assertEquals(expected,myHashMap.containsKey(""));
//        expected=false;
//        assertEquals(expected,myHashMap.containsKey(""));
    }
    @Test
    public void removeg(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        boolean expected=false;
        myHashMap.put(null,1);
        assertEquals(expected,myHashMap.remove(""));
        expected=true;
//        myHashMap.put(null,1);
        assertEquals(expected,myHashMap.remove(null));
    }


}