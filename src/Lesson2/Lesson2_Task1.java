package Lesson2;/*

*/

import java.util.Scanner;

public class Lesson2_Task1 {
    public static void main(String[] args) {
        Scanner coordinate = new Scanner(System.in);
        System.out.println("Введите координаты вектора A:");
        Vektor vektor1 = new Vektor(coordinate.nextDouble(), coordinate.nextDouble(), coordinate.nextDouble());
        vektor1.outputVector();
        System.out.println("Введите координаты вектора B:");
        Vektor vektor2 = new Vektor(coordinate.nextDouble(), coordinate.nextDouble(), coordinate.nextDouble());
        vektor2.outputVector();
        System.out.println("длина вектора А: "+vektor1.length());
        System.out.println("длина вектора В: "+vektor2.length());
        System.out.println("скалярное произведение векторов А и В: "+vektor1.scalarProductOfVectors(vektor2));
        System.out.print("произведение векторов А и В: ");
        vektor1.vektorMuliply(vektor2).outputVector();
        System.out.print("сумма векторов А и В: ");
        vektor1.sumOfTwoVectors(vektor2).outputVector();
        System.out.print("разность векторов А и В: ");
        vektor1.differenceOfTwoVectors(vektor2).outputVector();
        System.out.print("разность векторов В и А: ");
        vektor2.differenceOfTwoVectors(vektor1).outputVector();
        System.out.print("угол между векторами А и В: ");
        System.out.println(vektor1.angleBetweenVectors(vektor2));
        System.out.println();
        System.out.println("Введите количество произвольных векторов");
        int n = coordinate.nextInt();
        for(int i = 0; i<n;i++){
            System.out.print(i+1+"  :  ");
            Vektor.arrayOfRandomVectors(n)[i].outputVector();
        }
    }
}

class Vektor {
    double x;
    double y;
    double z;

    public Vektor(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void outputVector() {
        System.out.println("( "+x + " , " + y + " , " + z+" )");
    }


    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProductOfVectors(Vektor vektor) {
        return x * vektor.x + y * vektor.y + z * vektor.z;
    }

    public Vektor vektorMuliply(Vektor vektor) {
        return new Vektor(y * vektor.z - z * vektor.y, z * vektor.x - x * vektor.z, x * vektor.y - y * vektor.x);
    }

    public double angleBetweenVectors(Vektor vektor) {
        double scal = scalarProductOfVectors(vektor);
        return scal / length() * vektor.length();
    }

    public Vektor sumOfTwoVectors(Vektor vektor) {
        return new Vektor(x + vektor.x, y + vektor.y, z + vektor.z);
    }

    public Vektor differenceOfTwoVectors(Vektor vektor) {
        return new Vektor(x - vektor.x, y - vektor.y, z - vektor.z);
    }

    public static Vektor[] arrayOfRandomVectors(int n) {
        Vektor[] array = new Vektor[n];
        for (int i = 0; i < n; i++) {
            Vektor vektor = new Vektor(Math.random(), Math.random(), Math.random());
            array[i] = vektor;
        }
        return array;
    }
}