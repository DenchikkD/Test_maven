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
        myHashMap.put(null,1);
        assertEquals(expected,myHashMap.containsKey(null));
        expected=false;
        assertEquals(expected,myHashMap.containsKey(""));
    }

}