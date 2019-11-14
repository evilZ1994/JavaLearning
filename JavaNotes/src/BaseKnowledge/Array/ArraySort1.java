package BaseKnowledge.Array;

public class ArraySort1 {

    public static void main(String[] args) {
        // 冒泡排序
        int data[] = new int[]{4, 2, 6, 3, 8, 7, 10, 9, 5, 1};
        print(data);
        bubbleSort(data);
        System.out.println();
        print(data);

        // 数组转置
        System.out.println('\n');
        int data2[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        print(data2);
        transport(data2);
        System.out.println();
        print(data2);

        // 二维方阵转置
        System.out.println('\n');
        int data3[][] = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        print2D(data3);
        transport2D(data3);
        System.out.println();
        print2D(data3);

    }

    private static void bubbleSort(int data[]) {
        // 冒泡排序
        for (int i=0; i<data.length-1; i++) {
            for (int j=0; j<data.length-i-1; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    private static void transport(int data[]) {
        // 数组转置，比如[1,2,3]转置后为[3,2,1]
        for (int i=0; i<data.length/2; i++) {
            int temp = data[i];
            data[i] = data[data.length-i-1];
            data[data.length-i-1] = temp;
        }
    }

    private static void transport2D(int data[][]) {
        // 二维方阵转置
        for (int i=0; i<data.length; i++) {
            for (int j=i+1; j<data.length; j++) {
                int temp = data[i][j];
                data[i][j] = data[j][i];
                data[j][i] = temp;
            }
        }
    }

    private static void print(int data[]) {
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    private static void print2D(int data[][]) {
        for (int[] temp : data) {
            for (int i : temp) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }
}
