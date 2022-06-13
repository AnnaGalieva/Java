//Написать программу вычисления n-ого треугольного числа

package Java;
import java.util.Scanner;

public class dz1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);           //получение данных из терминала
        System.out.printf("Введите целое число: ");
        int i = iScanner.nextInt();
        System.out.printf("n-е треугольное число: %d\n", Number(i));
        iScanner.close();
    }

    public static int Number(int n){
        return (n * (n + 1)) / 2;                   //формула
        
    }
}






