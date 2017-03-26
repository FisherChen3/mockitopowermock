package com.javacodegeeks.mockitotutorial.spy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by Fisher on 3/25/2017.
 */
// when you call the method of a spied object, the real method will be called, unless a predefined behavior was defined
public class SpyExampleTest {

    @Test
    public void spyExampleTest(){
        Map<String,String> hashMap = new HashMap<String,String>();
        Map<String,String> hashMapSpy = spy(hashMap);

        System.out.println(hashMapSpy.get("key"));   // null
        hashMapSpy.put("key","A value");
        System.out.println(hashMapSpy.get("key"));   // A value


        hashMap.put("key","val2");
        // hashMap and hashMapSpy are different map object
        System.out.println(hashMap.get("key"));    // val2
        System.out.println(hashMapSpy.get("key"));   // A value

        when(hashMapSpy.get("key")).thenReturn("Another value");

        // predefined behavior was defined
        System.out.println(hashMapSpy.get("key"));   // Another value

//        Assert.fail();
    }

}
