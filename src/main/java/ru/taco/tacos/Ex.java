package ru.taco.tacos;

import ru.taco.tacos.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex {
    static int missingInt(int[] array, int n) {
      int N = array.length + 1;
      int sum_array = (N * (N + 1)) / 2;
      return sum_array - Arrays.stream(array).sum();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5};
        System.out.println(Ex.missingInt(array, 5));
    }
}
