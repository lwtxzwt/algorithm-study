import java.util.Arrays;

/**
 * 归并排序
 * @author lwtxzwt
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10};
    sort(numbers, 0, numbers.length - 1);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  private static void sort(int[] numbers, int start, int end) {
    if (start < end) {
      int middle = (start + end) / 2;
      sort(numbers, start, middle);
      sort(numbers, middle + 1, end);
      merge(numbers, start, middle, end);
    }
  }

  private static void merge(int[] numbers, int start, int middle, int end) {
    int[] tmp = new int[end - start + 1];
    int i = start;
    int j = middle + 1;
    int k = 0;

    while(i <= middle && j <= end){
      if(numbers[i] < numbers[j]){
        tmp[k++] = numbers[i++];
      }else{
        tmp[k++] = numbers[j++];
      }
    }
    while(i <= middle){
      tmp[k++] = numbers[i++];
    }
    while(j <= end){
      tmp[k++] = numbers[j++];
    }
    for(int index = 0; index < tmp.length; index++){
      numbers[index + start] = tmp[index];
    }
  }
}
