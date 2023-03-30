package model;

import java.util.Random;

public class DataModel {
    public static String[][] getData() {
        int NCOLS = 4;
        Random random = new Random();
        String[][] data;

        int NROWS = 10 + random.nextInt(20);

        data = new String[NROWS][NCOLS];

        for (int row = 0; row < NROWS; row++) {
            for (int col = 0; col < NCOLS; col++) {
                data[row][col] = String.valueOf(random.nextInt(1000));
            }
        }
        return data;
    }
}
