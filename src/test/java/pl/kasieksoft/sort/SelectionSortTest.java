package pl.kasieksoft.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectionSortTest {

    @Test
    void shouldSortArray() {
        //given
        int[] array = {10, 34, 2, 56, 7, 67, 88, 42, 35, 12};
        //when
        int[] result = SelectionSort.sort(array);
        //then
        assertTrue(isSorted(result));
    }

    @Test
    void shouldSortArrayOf10000Elements() {
        //given
        int[] array = randomArray(10_000);
        //when
        long startTime = System.currentTimeMillis();
        int[] result = SelectionSort.sort(array);
        System.out.println("Sorting took " + (System.currentTimeMillis() - startTime) + " ms.");
        //then
        assertTrue(isSorted(result));
    }

    @Test
    void shouldReturnTrueForEmptyArray() {
        //given
        int[] array = new int[10];
        //when
        int[] result = SelectionSort.sort(array);
        //then
        assertTrue(isSorted(result));
    }

    @Test
    void shouldSortArrayOfEqualElements() {
        //given
        int[] array = {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
        //when
        int[] result = SelectionSort.sort(array);
        //then
        assertTrue(isSorted(result));
    }

    @Test
    void shouldSortArrayOfElementsInReverseOrder() {
        //given
        int[] array = {97, 77, 75, 64, 32, 30, 25, 14, 7, 2};
        //when
        int[] result = SelectionSort.sort(array);
        //then
        assertTrue(isSorted(result));
    }

    private boolean isSorted(int[] array) {
        if (array.length == 0) {
            return true;
        }
        int previousElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < previousElement) {
                return false;
            }
            previousElement = array[i];
        }
        return true;
    }

    private int[] randomArray(int length) {
        Random r = new Random();
        int[] integers = new int[length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = r.nextInt();
        }
        return integers;
    }
}