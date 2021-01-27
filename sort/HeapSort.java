import java.util.Arrays;

/**
 * 堆排序
 * @author lwtxzwt
 */
public class HeapSort {

  public static void main(String[] args) {
    int[] numbers = new int[]{1,3,5,7,9,2,4,6,8,10};
    heapSort(numbers);
    Arrays.stream(numbers).forEach(System.out::println);
  }

  private static void heapSort(int[] numbers) {
    for (int i = (numbers.length - 1) / 2; i >= 0; i--) {
      //从第一个非叶子结点从下至上，从右至左调整结构
      adjustHeap(numbers, i, numbers.length);
    }

    //调整堆结构+交换堆顶元素与末尾元素
    for (int i = numbers.length - 1; i > 0; i--) {
      //将堆顶元素与末尾元素进行交换
      int temp = numbers[i];
      numbers[i] = numbers[0];
      numbers[0] = temp;

      //重新对堆进行调整
      adjustHeap(numbers, 0, i);
    }
  }

  private static void adjustHeap(int[] numbers, int parent, int length) {
    //将temp作为父节点
    int temp = numbers[parent];
    //左孩子
    int left = 2 * parent + 1;

    while (left < length) {
      //右孩子
      int right = left + 1;
      // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
      if (right < length && numbers[left] < numbers[right]) {
        left++;
      }

      // 如果父结点的值已经大于孩子结点的值，则直接结束
      if (temp >= numbers[left]) {
        break;
      }

      // 把孩子结点的值赋给父结点
      numbers[parent] = numbers[left];

      //选取孩子结点的左孩子结点,继续向下筛选
      parent = left;
      left = 2 * left + 1;
    }
    numbers[parent] = temp;
  }

}
