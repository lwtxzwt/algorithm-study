import java.util.Arrays;

/**
 * 桶排序
 * @author lwtxzwt
 */
public class BucketSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10,21,23,25,27,29,22,24,26,28,30};
    bucketSort(numbers, 10);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  private static void bucketSort(int[] numbers, int bucketSize) {
    if (numbers.length < 2) return;
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    // 取最大值、最小值
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] < minValue) minValue = numbers[i];
      if (numbers[i] > maxValue) maxValue = numbers[i];
    }

    // 计算桶数量
    int bucketCount = (maxValue - minValue) / bucketSize + 1;
    int[][] buckets = new int[bucketCount][bucketSize];
    int[] indexs = new int[bucketCount];

    // 将数组中值分配到各个桶里
    for (int i = 0; i < numbers.length; i++) {
      int bucketIndex = (numbers[i] - minValue) / bucketSize;
      if (indexs[bucketIndex] == buckets[bucketIndex].length) {
        ensureCapacity(buckets, bucketIndex);
      }
      buckets[bucketIndex][indexs[bucketIndex]++] = numbers[i];
    }

    // 对每个桶进行排序，这里使用了快速排序
    int k = 0;
    for (int i = 0; i < buckets.length; i++) {
      if (indexs[i] == 0) {
        continue;
      }
      quickSortC(buckets[i], 0, indexs[i] - 1);
      for (int j = 0; j < indexs[i]; j++) {
        numbers[k++] = buckets[i][j];
      }
    }
  }

  /**
   * 扩容
   * @param buckets
   * @param bucketIndex
   */
  private static void ensureCapacity(int[][] buckets, int bucketIndex) {
    int[] tempArr = buckets[bucketIndex];
    int[] newArr = new int[tempArr.length * 2];
    for (int j = 0; j < tempArr.length; j++) {
      newArr[j] = tempArr[j];
    }
    buckets[bucketIndex] = newArr;
  }

  /**
   * 快排
   * @param arr
   * @param p
   * @param r
   */
  private static void quickSortC(int[] arr, int p, int r) {
    if (p >= r) {
      return;
    }

    int q = partition(arr, p, r);
    quickSortC(arr, p, q - 1);
    quickSortC(arr, q + 1, r);
  }

  /**
   * 快排分区
   * @param arr
   * @param p
   * @param r
   * @return
   */
  private static int partition(int[] arr, int p, int r) {
    int pivot = arr[r];
    int i = p;
    for (int j = p; j < r; j++) {
      if (arr[j] <= pivot) {
        swap(arr, i, j);
        i++;
      }
    }

    swap(arr, i, r);
    return i;
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
