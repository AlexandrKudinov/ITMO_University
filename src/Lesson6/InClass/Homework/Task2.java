package Lesson6.InClass.Homework;

/*
Написать класс BaseConverter для конвертации из градусов по Цельсию в
Кельвины , Фаренгейты , и так далее. У метода должен быть метод convert, который
и делает конвертацию.
 */
public class Task2 {
public static void main(String[] args){
    double temperature = 36.6;
    System.out.println(temperature+"  "+new BaseCelsium().convert(temperature));
    System.out.println(temperature+"  "+new ConvertToKelvin().convert(temperature));
    System.out.println(temperature+"  "+new ConvertToFahrenheit().convert(temperature));
}
}

class BaseCelsium{
   public double convert(double value){
       return value;
   }
}

class ConvertToKelvin extends BaseCelsium{
    @Override
    public double convert (double value){
        return value+273.15;
    }

}
class ConvertToFahrenheit extends BaseCelsium{
    @Override
    public double convert (double value){
        return value*9/5+32;
    }

}

