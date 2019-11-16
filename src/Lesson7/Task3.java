package Lesson7;


/*

Задание*:
Напишите свой класс Stringbuilder с поддержкой операции undo. Для этого
делегируйте все методы стандартному Stringbuilder, а в Вашем классе храните
список всех операций для выполнения undo(). Это будет реализацией шаблона
"Команда": ru.wikipedia.org/wiki/Команда_(шаблон_проектирования)

*/

import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {

        UndobleStringBuilder stringBuilder = new UndobleStringBuilder();
        stringBuilder.append("wjfgqow").append("wflqjf").append("kjfhg").reverse().reverse().undo();

        System.out.println(stringBuilder.toString());


    }


}


/**
 * StringBuilder с поддержкой операции undo
 * java.lang.StringBuilder — класс с модификатором <b>final</b>,
 * поэтому нет наследования, используем делегирование.
 */

abstract class Action {
    abstract public void undo();
}

class UndobleStringBuilder {
    private StringBuilder stringBuilder;
    private Stack<Action> actions = new Stack<>();

    public UndobleStringBuilder() {
        stringBuilder = new StringBuilder();
    }



    public void undo(){
        if(!actions.isEmpty()){
            actions.pop().undo();
        }
    }




    public UndobleStringBuilder reverse() {
        stringBuilder.reverse();
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.reverse();
            }
        };
        actions.add(action);

        return this;
    }





    public UndobleStringBuilder append(String string) {
        stringBuilder.append(string);
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - string.length(), stringBuilder.length());
            }
        };

        actions.add(action);


        return this;

    }

public String toString(){
        return stringBuilder.toString();
}


}
