package br.com.leo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListBDDTest {

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturn10() {
        //Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        //When & Then
        assertThat(list.size(), is(10));

    }


    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturMultipleValues() {
        //Given
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        //When & Then
        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMocckingList_When_GetIsCalled_ShouldReturErudio() {
        //Given
        var list = mock(List.class);
        when(list.get(0)).thenReturn("Erudio");

        //When & Then
        assertEquals("Erudio", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void testMocckingList_When_GetIsCalledWithArgumenMatcher_ShouldReturErudio() {
        //Given
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Erudio");
        //When & Then
        assertEquals("Erudio", list.get(0));
        assertEquals("Erudio", list.get(anyInt()));
    }

    @Test
    void testMocckingList_When_ThrowsAnException_ShouldReturErudio() {
        //Given
        var list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!!"));
        //When & Then
        assertThrows(RuntimeException.class,
         () -> {
            //When
            list.get(anyInt());
        }, () -> "Should have throw an RuntimeException");
    }
}
