import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10};
    insertSort(numbers);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  public static void insertSort(int[] numbers) {
    for (int i = 1; i < numbers.length; i++) {
      int tmp = numbers[i];
      for (int j = i - 1; j >= 0; j--) {
        if (numbers[j] > tmp) {
          numbers[j + 1] = numbers[j];
        } else {
          numbers[j + 1] = tmp;
          break;
        }
      }
    }
  }
}
