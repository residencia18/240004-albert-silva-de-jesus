package com.example.atividades.atividade11;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CustomSortTest {

  @Test
  void testCustomSort() {
    // Arrange
    List<Integer> unsorted = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);

    CustomSort customSort = new CustomSort();

    // Act
    List<Integer> sorted = customSort.customSort(unsorted);

    // Assert
    List<Integer> expected = Arrays.asList(9, 6, 5, 5, 4, 3, 2, 1, 1);
    assertEquals(expected, sorted);
  }

  @Test
  void testCustomSort_EmptyList() {
    // Arrange
    List<Integer> emptyList = Arrays.asList();

    CustomSort customSort = new CustomSort();

    // Act
    List<Integer> sorted = customSort.customSort(emptyList);

    // Assert
    assertTrue(sorted.isEmpty());
  }

  @Test
  void testCustomSort_SingleElementList() {
    // Arrange
    List<Integer> singleElementList = Arrays.asList(42);

    CustomSort customSort = new CustomSort();

    // Act
    List<Integer> sorted = customSort.customSort(singleElementList);

    // Assert
    List<Integer> expected = Arrays.asList(42);
    assertEquals(expected, sorted);
  }
}
