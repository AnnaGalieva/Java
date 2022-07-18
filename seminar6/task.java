/*Задано уравнение вида q + w = e, q, w, e >= 0. 
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
Требуется восстановить выражение до верного равенства. 
Предложить хотя бы одно решение или сообщить, что его нет*/

package Java.seminar6;

public class task {
    public static void main(String[] args) {
        String q = "25";
        String w = "??";
        String e = "6?";
        char[] arr = array(q, w, e);
        int flag = 0;
        for (int i = 0; i < 6; i++) {
            if (arr[i] != '?')
                flag = 1;
        }
        if (flag == 0) {
            System.out.println("25 + 11 = 36");
        }
        if (arr[5] == '?' && (arr[3] == '?' || arr[1] == '?'))
            arr[5] = '9';
        // System.out.println(arr);
        if (arr[3] == '?') {
            int s = (int) arr[5] - (int) arr[1];
            arr[3] = (char)(s +'0');

        }
        if(arr[2]=='?'){
            arr[2] = (char)((int)arr[4] - (int)arr[0] + '0');
        }
        System.out.println(arr);
    }

    public static char[] array(String a, String b, String c) {
        char[] arrays = new char[6];
        arrays[0] = a.charAt(0);
        arrays[1] = a.charAt(1);
        arrays[2] = b.charAt(0);
        arrays[3] = b.charAt(1);
        arrays[4] = c.charAt(0);
        arrays[5] = c.charAt(1);
        return arrays;

    }

    public static boolean isDigit(char a) {
        if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8'
                || a == '9')
            return true;
        else
            return false;
    }
}
