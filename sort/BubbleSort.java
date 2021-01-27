import java.util.Arrays;

/**
 * 冒泡排序
 * @author lwtxzwt
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10};
    bubbleSort(numbers);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  private static void bubbleSort(int[] numbers) {
    for (int i = 0; i < numbers.length - 1; i++) {
      boolean tag = false;
      for (int j = 0; j < numbers.length - 1 - i; j++) {
        if (numbers[j] > numbers[j + 1]) {
          swap(numbers, j, j + 1);
          tag = true;
        }
      }
      if (tag == false) {
        break;
      }
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
