package Java.seminar4.dz4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class dz {    
        public static void main(String[] args) {
            // Сначала определяем обратное польское выражение
            String expression = "1+((2+3)*4)-5";
            List<String> infixExpressionList = toInfixExpressionList(expression);
            System.out.println("Инфиксное выражение соответствует списку"+ infixExpressionList);
            List<String> suffixExpresionList = parseSuffixExpresionList(infixExpressionList);
            System.out.println("Суффиксное выражение соответствует списку:"+ suffixExpresionList);
            System.out.printf("Expression=%d", calculate(suffixExpresionList));
        }
        
        public static List<String> parseSuffixExpresionList(List<String> list){
            // Определяем два стека
            Stack<String> s1 = new Stack<>(); // Стек символов
            List<String> s2 = new ArrayList<String>();
            // Обходим список
            for (String item: list) {
                // Если это число, введите s2
                if(item.matches("\\d+")){
                    s2.add(item);
                }else if(item.equals("(")){
                    s1.push(item);
                }else if(item.equals(")")) {
                    // Если это правая скобка ")", операторы в верхней части стека s1 будут появляться по очереди, а s2 будет нажиматься, пока не встретится левая скобка, тогда эта пара скобок будет отброшена
                    while (!s1.peek().equals("(")){
                        s2.add(s1.pop());
                    }
                    s1.pop();// Открываем круглые скобки и убираем скобки
                }else {
                    // Рассматриваем вопрос приоритета операторов
                    // Когда приоритет элемента меньше или равен оператору в верхней части стека, выталкиваем s1 и добавляем s2, а затем продолжаем сравнение элемента с новым верхним элементом стека
                    // Отсутствие возможности сравнения приоритетов
                    while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                        s2.add(s1.pop());
                    }
                    // элемент помещается в стек
                    s1.push(item);
                }
            }
            // По очереди показываем остальные операторы от s1 до s2
            while (s1.size() != 0){
                s2.add(s1.pop());
            }
            return s2;
    
        }        
               // Преобразование инфиксного выражения в список постфиксных выражений
         
        public static List<String> toInfixExpressionList(String s){
            // Определяем список, помещаем инфиксное выражение
            List<String> list = new ArrayList<String>();
            int i = 0; // Это указатель, используемый для обхода строки инфиксного выражения
            String str;// Склейка нескольких цифр
            char c;// Каждый раз, когда проходит символ, он помещается в c
            do{
                // Если c не является числом, его нужно добавить к ls
                if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                    list.add("" + c);
                    i++;
                }else{ // Если это число, нужно учитывать несколько цифр
                    str = "";//Пустой строкой
                    while (i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57){ // Обработка целых чисел
                        str += c;// Склейка
                        i++;
                    }
                    list.add(str);
                }
            }while (i < s.length());
            return list;
        }
    
    
        // Помещаем обратное польское выражение и по очереди помещаем данные и операторы в ArrayList
        public static List<String> getListString(String suffixExpression){
            // Разделить строку
            String[] split = suffixExpression.split(" ");
            List<String> list = new ArrayList<String>();
            for (String ele: split) {
                list.add(ele); // Помещаем символы по порядку
            }
            return list;
        }
    
        // Завершаем операцию обратного польского выражения
        public static int calculate(List<String> ls){
            // Создаем стек.
            Stack<String> stack = new Stack<>();
            // Обход
            for (String item:ls) {
                // Используем регулярные выражения для извлечения чисел
                if(item.matches("\\d+")){// Соответствие нескольким цифрам
                    stack.push(item);
                }else {
                    // выполняем две операции с числами и затем помещаем стек
                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    int res = 0;
                    if(item.equals("+")){
                        res = num1 + num2;
                    }else if(item.equals("-")){
                        res = num1 - num2;
                    }else if(item.equals("*")){
                        res = num1 * num2;
                    }else if(item.equals("/")){
                        res = num1 / num2;
                    }else {
                        throw new RuntimeException("Неправильный оператор");
                    }
                    stack.push(res + "");
                }
            }
            // Последние данные в стеке - результат
            return Integer.parseInt(stack.pop());
        }
    }
    
    // Добавляем класс Operation для возврата приоритета, соответствующего оператору
    class Operation{
        private static int ADD = 1;
        private static int SUB = 1;
        private static int MUL = 2;
        private static int DIV = 2;
        // Напишите метод для возврата соответствующего номера приоритета
        public static int getValue(String operation){
            int result = 0;
            switch (operation){
                case "+":
                    result = ADD;
                    break;
                case "-":
                    result = SUB;
                    break;
                case "*":
                    result = MUL;
                    break;
                case "/":
                    result = DIV;
                    break;
                    default:
                        break;
            }
            return result;
        }
    }
    
    