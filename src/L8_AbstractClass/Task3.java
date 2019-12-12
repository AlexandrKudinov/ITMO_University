package L8_AbstractClass;
/*

Написать Observable StringBuilder. Для этого понадобится абстрактный класс
OnChangeListener c методом onChange(StringBuilder sb), который вызывается
внутри собственного класса-наследника StringBuilder если тот изменился.

*/

import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {

        UndobleStringBuilder stringBuilder = new UndobleStringBuilder();
        stringBuilder.append("wjfgqow").reverse().append("wefawfsfasd").reverse().undo();

        UndobleStringBuilder stringBuilder1 = new UndobleStringBuilder();
        stringBuilder1.append("wefasdf");

    }


}


abstract class Action {
    abstract public void undo();
}

abstract class OnChangeListener {
    abstract void Onchange(StringBuilder sb);
}


class UndobleStringBuilder extends OnChangeListener {
    private int changeNumber = 1;
    private StringBuilder stringBuilder;
    private Stack<Action> actions = new Stack<>();

    void Onchange(StringBuilder sb) {
        System.out.print("изменение №" + changeNumber + ":  " + sb.toString());
        System.out.println();
        changeNumber++;
    }


    public UndobleStringBuilder() {
        stringBuilder = new StringBuilder();
    }


    public void undo() {
        if (!actions.isEmpty()) {
            actions.pop().undo();
            Onchange(stringBuilder);
        }
    }


    public UndobleStringBuilder reverse() {
        stringBuilder.reverse();
        Onchange(stringBuilder);

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
        Onchange(stringBuilder);
        Action action = new Action() {
            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - string.length(), stringBuilder.length());
            }
        };

        actions.add(action);


        return this;

    }

    public String toString() {
        return stringBuilder.toString();
    }


}
