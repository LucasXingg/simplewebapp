package gameRuntime;

public class tools {
    
    public static Integer[] joinArray(Integer[] array1, Integer[] array2){
        int length = array1.length + array2.length;

        Integer[] result = new Integer[length];
        int pos = 0;
        for (Integer element : array1) {
            result[pos] = element;
            pos++;
        }

        for (Integer element : array2) {
            result[pos] = element;
            pos++;
        }

        return result;
    }

    public static Integer[][] join2DArray(Integer[][] array1, Integer[][] array2){
        int length = array1.length + array2.length;

        Integer[][] result = new Integer[length][];
        int pos = 0;
        for (Integer[] element : array1) {
            result[pos] = element;
            pos++;
        }

        for (Integer[] element : array2) {
            result[pos] = element;
            pos++;
        }

        return result;
    }

}
