package Lesson9;

import java.util.Arrays;

/*
Напишите метод fill , который принимает массив объектов, и экземпляр интерфейса
Generator для получения нового значения по индексу.
 */

public class Task4{
public static void main(String[] args) {
     final Shape[] shapes = new Shape[]{
            new Ball(44),
            new Cylinder(33, 22),
            new Pyramid(33, 21),
            null};
    Shape[] shapes1 = new Shape[shapes.length];

         shapes1= (Shape[]) Fill.fill(shapes, new Generator() {
        @Override

        public Object newVolume(int index) {
           return new Shape() {
                @Override
                public double volume() {
                    return shapes[index].volume()*index;
                }
            };

        }


    });

}}


interface Generator{
    Object newVolume (int index);
}
class Fill {
    public static Object[] fill (Object[] objects, Generator generator){
        for(int i =0;i<objects.length;i++){
            objects[i]=generator.newVolume(i);
        }
        return objects;
    }
}

