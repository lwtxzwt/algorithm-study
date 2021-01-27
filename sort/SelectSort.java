import java.util.Arrays;

/**
 * 选择排序
 * @author lwtxzwt
 */
public class SelectSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10};
    selectSort(numbers);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  private static void selectSort(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      int min = i;
      for (int j = i; j < numbers.length; j++) {
        if (numbers[j] < numbers[min]) min = j;
      }

      swap(numbers, i, min);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }

    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
