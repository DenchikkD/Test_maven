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
    public void remove(){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        boolean expected=false;
        myHashMap.put("",16);
        myHashMap.put("5",11);
        myHashMap.put("17",61);
        myHashMap.put("08",91);
        myHashMap.put("45678",21);
        myHashMap.put(null,31);
        assertEquals(expected,myHashMap.remove("1"));
        expected=true;
        assertEquals(expected,myHashMap.remove(null));
        assertEquals(expected,myHashMap.remove("08"));
        assertFalse("no",myHashMap.remove("1"));
        assertSame("BLA",false,myHashMap.remove(""));
    }


}