import java.util.Arrays;

public class MyBubbleSort {

    public static void bubbleSort(int array[]) 
    {
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) 
        {
            boolean isSorted = true;

            for (int j = 0; j < (array.length - i - 1); j++)
            {
                int tmp = 0;
                if (array[j] > array[j+1])
                {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            
            sortBorder = lastExchangeIndex;
            if (isSorted)
            {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(" MyBubbleSort ");
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}