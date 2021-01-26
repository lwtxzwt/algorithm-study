import java.util.Arrays;

/**
 * 快速排序
 * @author lwtxzwt
 */
public class QuickSort {


  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10};
    quickSort(numbers, 0, numbers.length - 1);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  public static void quickSort(int[] numbers, int p, int r) {
    if (p >= r) {
      return;
    }

    int left = p;
    int right = r;
    int mid = (p + r) / 2;
    int key = numbers[mid];

    while (left < right) {
      while (key <= numbers[right] && left < right) {
        right--;
      }

      while (key >= numbers[left] && left < right) {
        left++;
      }

      if (left < right) {
        int tmp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = tmp;
      }
    }

    numbers[mid] = numbers[left];
    numbers[left] = key;
    quickSort(numbers, p, right - 1);
    quickSort(numbers, right + 1, r);
  }

}
