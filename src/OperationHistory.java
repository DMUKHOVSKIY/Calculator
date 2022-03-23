import java.util.Arrays;

public class OperationHistory implements DataBase {
    private double[] arr = new double[5];
    private int counter;

    @Override
    public void addObject(Object obj) {
        if (counter == arr.length)
            counter = 0;
        arr[counter] = (double) obj;
        counter++;
    }

    @Override
    public void printObject() {
        System.out.println(Arrays.toString(arr));
    }

}
