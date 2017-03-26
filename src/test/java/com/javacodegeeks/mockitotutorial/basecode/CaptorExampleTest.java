package com.javacodegeeks.mockitotutorial.basecode;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

/**
 * Created by Fisher on 3/26/2017.
 */
public class CaptorExampleTest {

    @Test
    public void captorTest(){

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        Stack<String> stack = Mockito.mock(Stack.class);

        stack.add("Java Code Geeks");
        stack.add("Mockito");

        Mockito.verify(stack,times(2)).add(argument.capture());

        List<String> values = argument.getAllValues();

        assertEquals("Java Code Geeks", values.get(0));
        assertEquals("Mockito", values.get(1));

//        assertEquals("Java Code Geeks", argument.getValue());

    }

}
