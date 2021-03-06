import java.util.Arrays;

public class MyCockTailSort {

    public static void cockTailSort(int array[]) 
    {
        int tmp = 0;

        for (int i = 0; i < array.length/2; i++)
        {
            boolean isSorted = true;

            for (int j = i; j < array.length-i-1; j++)
            {
                if (array[j] > array[j+1])
                {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1]= tmp;
                    
                    isSorted = false;
                }
            }

            if (isSorted)
            {
                break;
            }

            isSorted = true;
            for (int j = array.length-i-1; j>i; j--)
            {
                if (array[j] < array[j-1])
                {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1]= tmp;
                    
                    isSorted = false;
                }
            }

            if (isSorted)
            {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(" MyCockTailSort ");
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        cockTailSort(array);
        System.out.println(Arrays.toString(array));
    }
}