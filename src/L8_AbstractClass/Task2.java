package L8_AbstractClass;


import java.util.Arrays;

/*
1)Написать метод filter, который принимает на вход массив (любого типа) и
 реализацию абстрактного класса filter c методом apply(Object o), чтобы убрать
  из массива лишнее. Проверьте как он работает на строках или других объектах.

2) Напишите метод fill, который принимает массив объектов, и экземпляр
абстрактного класса для получения нового значения по индексу.
*/

public class Task2 {
    public static void main(String[] args) {
      String[] strings = new String[]{
                "QWERQ",
                "WFQWFA",
                "AWFASDFASD",
                "ASDASDFASFDAV",
                "retertertSDASDVASV"};

        ArrayTransform.fill(strings, new Fill() {
            @Override
            public Object transform(int index) {
                strings[index]= strings[index]+index;
                return strings[index];
            }
        });
        System.out.println("werwqrqwr" + Arrays.toString(strings));

        String[] strings2 = (String[]) ArrayTransform.filter(strings, new Filter() {
            @Override
            public boolean contain(Object object) {
                return object.toString().length() < 12;
            }
        });
        System.out.println("werwqrqwr" + Arrays.toString(strings2));


    }


}

abstract class Filter {
    abstract public boolean contain(Object object);
}

abstract class Fill {
    abstract public Object transform(int index);
}


class ArrayTransform {

    public static Object[] filter(Object[] objects, Filter filter) {
        for (int i = 0; i < objects.length; i++) {
            if (filter.contain(objects[i])) {
                if (i != objects.length - 1) {
                    for (int j = i; j < objects.length - 1; j++)
                        objects[j] = objects[j + 1];

                }
                i--;
                objects = Arrays.copyOf(objects, objects.length - 1);
            }
        }
        return objects;
    }

    public static void fill(Object[] objects, Fill fill) {
        for (int i = 0; i < objects.length; i++) {
            objects[i] = fill.transform(i);
        }
    }


}








