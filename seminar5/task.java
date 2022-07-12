/*На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b
или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения.
*Подумать над тем, как сделать минимальное количество команд*/
package Java.seminar5;
import java.util.*;
public class task {
    public static int findElement(int a, int b, int c, int d) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(a);
        int i = 0;
        int result1 = a;
        int result2 = a;
        while (result1 != b && result2 != b && deque.size() != 0) {
            int parent = deque.getFirst();
            deque.removeFirst();
            result1 = parent + c;
            if (result1 > b) {
                i++;
            } else {
                if (result1 == b) {
                    deque.addLast(result1);
                    i++;
                    break;
                } else {
                    deque.addLast(result1);
                    i++;
                }
            }
            result2 = parent * d;
            if (result2 > b) {
                i++;
            } else {
                deque.addLast(result2);
                i++;
            }
        }
        if (deque.isEmpty())
            return 0;
        else
            return i;
    }
    
    public static void main(String[] args) {

        int a = 1;
        int b = 7;
        int c = 2;
        int d = 1;
        int res = findElement(a, b, c, d);
        System.out.println(res);
    }

}

