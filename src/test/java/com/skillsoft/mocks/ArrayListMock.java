package com.skillsoft.mocks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListMock {

    @Test
    public void mockArrayList() {

        ArrayList someArrayList = mock(ArrayList.class);

        when(someArrayList.contains("Alice")).thenReturn(true);
        when(someArrayList.contains("Bob")).thenReturn(false);

        when(someArrayList.subList(10, 13)).thenReturn(Arrays.asList("Alice", "Bob", "Charles"));


        assertTrue(someArrayList.contains("Alice"));
        assertFalse(someArrayList.contains("Bob"));
        assertLinesMatch(Arrays.asList("Alice", "Bob", "Charles"), someArrayList.subList(10, 13));

        System.out.println(someArrayList.toArray());
    }
}
