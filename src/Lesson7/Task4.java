package Lesson7;

/*
Дан массив целых чисел и массив "весов". Каждому числу из первого массива
соответствует "вес" из второго.Реализуйте алгоритм случайного
выбора числа из первого массива, с учетом веса из второго.
 */

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};
        int[] weights = new int[]{10, 30, 55, 5};
        RandomWithWeights RR = new RandomWithWeights(numbers, weights);
        for (int i = 0; i < 100; i++) {
            System.out.println(RR.randomWithWeights());
        }
    }
}

class RandomWithWeights {
    private int[] numbers;
    private int[] weights;

    public RandomWithWeights(int[] numbers, int[] weights) {
        this.numbers = numbers;
        this.weights = weights;
    }


    public int randomWithWeights() {
        int[] numbersDiapason = new int[numbers.length];
        int random = 0;
        int sumWeight = 0;


        for (int i = 0; i < numbers.length; i++) {
            sumWeight += weights[i];
            numbersDiapason[i] = sumWeight;
        }

        int random1 = (int) (Math.random() * (sumWeight));
        for (int i = 0; i < numbers.length; i++) {
            random = numbers[i];
            if (random1 <= numbersDiapason[i])
                break;
        }
        return random;
    }
}
