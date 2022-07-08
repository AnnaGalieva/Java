//+Написать программу, определяющую правильность расстановки скобок в выражении.
/*Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь
Пример 3: [6+(3*3)] - истина
Пример 4: {a}[+]{(d*3)} - истина
Пример 5: <{a}+{(d*3)}> - истина
Пример 6: {a+]}{(d*3)} - ложь*/
package Java.seminar4;

import java.util.Stack;
//import java.util.Arrays;
public class task {
    static boolean check (Stack<Character> st, char[] bee){
        for (int i = 0; i<bee.length; i++){
            switch (bee[i]){
                case '(' :
                    st.addElement(bee[i]);
                    break;
                case '[' :
                    st.addElement(bee[i]);
                    break;
                case '{' :
                    st.addElement(bee[i]);
                    break;
                case '<' :
                    st.addElement(bee[i]);
                    break;
                case ')' :
                    if (st.empty() || st.pop() != '(') return false ;
                    break;
                case ']' :
                    if (st.empty() || st.pop() != '[') return false ;
                    break;
                case '}' :
                    if (st.empty() || st.pop() != '{') return false ;
                    break;
                case '>' :
                    if (st.empty() || st.pop() != '<') return false ;
                    break;
            }
        }
        if (st.empty()) return true;
            else return false;
    }

    public static void main(String[] args) {
        var exp = "[6+(3*3)]";
        char [] bee = exp.toCharArray();
        Stack<Character> st = new Stack<>();
        if (check (st,bee)){
            System.out.println("истина");
        } else 
            System.out.println("ложь");
}
}




/*public class task {
    public static void createStack(String str) {
        char[] breckets = {'[', ']', '{', '}', '(', ')', '<', '>'};
        
       
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            for (int j = 0; j < breckets.length; j++){
                if (breckets[j] == c){
                    st.push(c);
                }
            }
        }
        System.out.print(str);
        int i =0;
        while(i < st.size()){
            char l = st.pop();
            if (l == '{' || l == '(' || l == '[' || l == '<'){
                System.out.println("False");
            } 
            else {

            }
            ;
        }
        
        
    }
    public static void main(String [] args) {
        
        String exp =  "a+(d*3)";
        String exp1 = "[a+(1*3)";
        String exp2 = "[6+(3*3)]";
        String exp3 = "{a}[+]{(d*3)}";
        String exp4 = "<{a}+{(d*3)}>";
        String exp5 = "{a+]}{(d*3)}";
        

       createStack(exp);
       createStack(exp1);
       createStack(exp2);
       createStack(exp3);
       createStack(exp4);
       createStack(exp5);
        
        
    }
}

// public class task {
//    public static void main(String[] args) {
//     String data = "a+(d*3)";
//     System.out.println(data);
//     Stack<String> st = new Stack<>();
//     for (int i = 0; i < data.length(); i++) {
//     if (data.charAt(i) == '(' || data.charAt(i) == ')'){
//     System.out.println(data.charAt(i));
//     }
//     }
//     }
// }


//     import java.util.Stack;
    
//     public class task {
//     public static void main(String[] args) {
//     String d = "a+(d*3)";
//     String a = "[a+(1*3)";
//     String b = "[6+(3*3)]";
//     String c = "{a}[+]{(d*3)}";
//     String e = "<{a}+{(d*3)}>";
//     String f = "{a+]}{(d*3)}";
//     find(d);
//     find(a);
//     find(b);
//     find(c);
//     find(e);
//     find(f);
//     }
// }
// public class task {
//     public static void find(String data) {
//     Stack<String> st = new Stack<>();
//     for (int i = 0; i < data.length(); i++) {
//     if (data.charAt(i) == '(' || data.charAt(i) == ')'
//     || data.charAt(i) == '{' || data.charAt(i) == '}'
//     || data.charAt(i) == '<' || data.charAt(i) == '>'
//     || data.charAt(i) == '[' || data.charAt(i) == ']'
//     ) {
//     st.push(String.valueOf(data.charAt(i)));
    
    
//     }
//     }
//     //System.out.println(st);
//     if (st.size() % 2 == 0){
//     System.out.println("True");*/

