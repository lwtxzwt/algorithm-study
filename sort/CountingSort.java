import java.util.Arrays;

/**
 * 计数排序
 * @author lwtxzwt
 */
public class CountingSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10,21,23,25,27,29,22,24,26,28,30};
    countingSort(numbers);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  private static void countingSort(int[] numbers) {
    if (numbers.length < 2) return;
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    // 取最大值、最小值
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] < minValue) minValue = numbers[i];
      if (numbers[i] > maxValue) maxValue = numbers[i];
    }

    int range = maxValue - minValue;
    int[] count = new int[range + 1];

    for (int i = 0; i < numbers.length; i++) {
      count[numbers[i] - minValue]++;
    }

    int index = 0;
    for (int i = 0; i < range; i++) {
      while (count[i] > 0) {
        numbers[index++] = i + minValue;
        count[i]--;
      }
    }
  }
}
