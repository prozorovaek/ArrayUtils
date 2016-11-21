import java.util.Random;

public class ArrayUtils {
    static int[] intArray1 = { 13, 34, 49, 21, 18 };
    static int[] intArray2 = { 87, 54, 13, 26, 67 };

    /**
     * Вывод массива
     */
    protected static void printArray(int[] inputArray) {
        int arrayCounter = 0;
        System.out.println("Our array:");
        for (int intValue : inputArray) {
            System.out.println("[" + arrayCounter + "]=" + intValue + "; ");
            arrayCounter++;
        }
    }

    /**
     * Усечение массива
     */
    protected static int[] truncationArray(int[] inputArray) {
        int[] truncatedArray = new int[inputArray.length - 1];
        System.arraycopy(inputArray, 0, truncatedArray, 0,
                inputArray.length - 1);
        return truncatedArray;
    }

    /**
     * Расширение массива
     */
    protected static int[] expansionArray(int[] inputArray) {
        int[] truncatedArray = new int[inputArray.length + 1];
        System.arraycopy(inputArray, 0, truncatedArray, 0, inputArray.length);
        return truncatedArray;
    }

    /**
     * Сортировка массива методом пузырька
     */
    protected static int[] sortingArray(int[] inputArray) {
        for (int outerCounter = inputArray.length - 1; outerCounter >= 2; outerCounter--) {
            boolean sorted = true;
            for (int innerCounter = 0; innerCounter < outerCounter; innerCounter++) {
                if (inputArray[innerCounter] > inputArray[innerCounter + 1]) {
                    int temp = inputArray[innerCounter];
                    inputArray[innerCounter] = inputArray[innerCounter + 1];
                    inputArray[innerCounter + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return inputArray;
    }

    /**
     * Сравнение массивов
     */
    protected static boolean isSameArrays(int[] inputFirstArray,
            int[] inputSecondArray) {
        if (inputFirstArray.length != inputSecondArray.length) {
            return false;
        }

        int[] sortedFirstArray = sortingArray(inputFirstArray);
        int[] sortedSecondArray = sortingArray(inputSecondArray);

        boolean result = true;
        for (int arrayIndex = 0; arrayIndex < sortedFirstArray.length; arrayIndex++) {
            if (sortedFirstArray[arrayIndex] != sortedSecondArray[arrayIndex]) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Перемешивание массива
     */
    protected static int[] mixArray(int[] inputArray) {
        int index, temp;
        Random random = new Random();
        for (int i = inputArray.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = inputArray[index];
            inputArray[index] = inputArray[i];
            inputArray[i] = temp;
        }
        return inputArray;
    }

    public static void main(String[] args) {
        printArray(truncationArray(intArray1));
        printArray(sortingArray(intArray1));
        printArray(sortingArray(intArray2));
        System.out.println(isSameArrays(intArray1, intArray2));
        printArray(mixArray(intArray1));
        printArray(truncationArray(intArray1));
    }
}
