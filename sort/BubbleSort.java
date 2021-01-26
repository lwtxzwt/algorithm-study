import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10};
    bubbleSort(numbers);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  public static void bubbleSort(int[] numbers) {
    for (int i = 0; i < numbers.length - 1; i++) {
      boolean tag = false;
      for (int j = 0; j < numbers.length - 1 - i; j++) {
        if (numbers[j] > numbers[j + 1]) {
          int tmp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = tmp;
          tag = true;
        }
      }
      if (tag == false) {
        break;
      }
    }
  }
}
