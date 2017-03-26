package com.javacodegeeks.mockitotutorial.basecode;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Fisher on 3/26/2017.
 */
public class ThenReturnExampleTest {

    /**
     * This will test multiple return values.
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Java Code Geeks").thenReturn("Mockito");
        String result = i.next() + " " + i.next();
        assertEquals("Java Code Geeks Mockito", result);

    }

    /**
     * This test demonstrates how to return values based on the input
     */
    @Test
    public void test2() {

        Comparable c = mock(Comparable.class);
        when(c.compareTo("Java Code Geeks")).thenReturn(100);
        when(c.compareTo("Mockito")).thenReturn(200);
        assertEquals(200, c.compareTo("Mockito"));

    }

    /**
     * This test demonstrates how to return values independent of the input value
     * by using anyInt()
     */
    @Test
    public void test3() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(0);
        assertEquals(0,c.compareTo(9));
    }

}
