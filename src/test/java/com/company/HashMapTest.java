package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void getSizeReturnsCorrectSizeTest() {
        HashMap map = new HashMap();
        map.put(1,100L);
        map.put(2,200L);
        map.put(3,300L);
        int expectedSize = 3;
        int actualSize = map.getSize();
        assertEquals(expectedSize,actualSize);

    }

    @Test
    public void isEmptyTest() {
        HashMap map = new HashMap();
        boolean expected1 = true;
        boolean actual1 = map.isEmpty();
        assertEquals(expected1,actual1);
        map.put(1,100L);
        boolean expected2 = false;
        boolean actual2 = map.isEmpty();
        assertEquals(expected2,actual2);
    }

    @Test
    public void putCorrectlyAddsElementTest() {
        HashMap map = new HashMap();
        map.put(1,100L);
        map.put(2,200L);
        map.put(3,300L);
        long expectedValue1 = 100L;
        long actualValue1 = map.get(1);
        long expectedValue2 = 200L;
        long actualValue2 = map.get(2);
        long expectedValue3 = 300L;
        long actualValue3 = map.get(3);
        assertEquals(expectedValue1, actualValue1);
        assertEquals(expectedValue2, actualValue2);
        assertEquals(expectedValue3, actualValue3);
        int expectedSize = 3;
        int actualSize = map.getSize();
        assertEquals(expectedSize, actualSize);
    }
    @Test
    public void putCorrectlyAddsElementIfKeyAlreadyExistsTest(){
        HashMap map = new HashMap();
        map.put(1,100L);
        map.put(1,200L);
        long expectedValue = 200L;
        long actualValue = 200L;
        int expectedSize = 1;
        int actualSize = map.getSize();
        assertEquals(expectedSize,actualSize);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void putCorrectlyReturnsOldValueIfKeyAlreadyExistsTest(){
        HashMap map = new HashMap();
        map.put(1, 100L);
        long oldValue = map.put(1,200L);
        long expectedValue = 100L;
        long actualValue = oldValue;
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void putCorrectlyWorksIfCollisionTest(){
        HashMap map = new HashMap();
        map.put(11,100L);
        map.put(21,200L);
        long actualValue1 = map.get(11);
        long actualValue2 = map.get(21);
        long expectedValue1 = 100L;
        long expectedValue2 = 200L;
        assertEquals(expectedValue1, actualValue1);
        assertEquals(expectedValue2, actualValue2);
    }

    @Test
    public void get() {
        HashMap map = new HashMap();
        map.put(1,100L);
        map.put(2,200L);
        long expectedValue = 200L;
        long actualValue = map.get(2);
        assertEquals(expectedValue, actualValue);
    }
}
