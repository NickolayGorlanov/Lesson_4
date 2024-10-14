
class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Массив должен быть размером 4x4");
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super("Ошибка в ячейке: [" + row + "][" + col + "]");
    }
}

public class ArrayProcessor {

    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (String[] row : arr) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {

                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        String[][] incorrectDataArray = {
                {"1", "2", "3", "4"},
                {"5", "X", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        String[][] incorrectSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        try {

            System.out.println("Сумма элементов массива: " + processArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {

            System.out.println("Сумма элементов массива: " + processArray(incorrectDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {

            System.out.println("Сумма элементов массива: " + processArray(incorrectSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}