package com.company;

import java.util.Stack;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // String str = in.nextLine();
        // System.out.print(makePostfix(str));
        System.out.println(makePostfix("(2+9)*7-8"));
        System.out.println(calc("(2+9)*7-8"));
        Stack<Character> stack = new Stack<>();



        stack.push('(');
        stack.push('2');
        stack.push('+');
        stack.push('9');
        stack.push(')');
        stack.push('*');
        stack.push('7');
        stack.push('-');
        stack.push('8');

//             while (!stack.isEmpty()) {
//              System.out.println(stack.pop());
//            }
    }


    static String makePostfix(String expression) {
        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
            char current = expression.charAt(i);
            if (isOperator(current)){
                result.append(' ');
                while (!stack.isEmpty() && priority(stack.lastElement()) > priority(current)) {
                    result.append(stack.pop());
                    result.append(' ');
                }
                stack.push(current);
            }
            else if (current == '('){
                stack.push(current);
            }
            else if (current == ')'){
                while (stack.lastElement() != '('){
                    result.append(' ');
                    result.append(stack.pop());
                }
                stack.pop();

            }
            else {
                result.append(current);
            }
        }
        while (!stack.isEmpty()){
            result.append(' ');
            result.append(stack.pop());
        }


        return result.toString();
    }

    static Double calc (String expression){
        Double result = 1.0;
        String[] str = makePostfix(expression).split(" ");
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < str.length; i++){
            for (int j = 0; j < str[i].length(); j++){
                char current = str[i].charAt(j);
                if (!isOperator(current)){
                    stack.push(Double.parseDouble(str[i]));
                }
                else {
                    double t1 = stack.pop();
                    double t2 = stack.pop();

                    switch (current)
                    {
                        case '+':
                            stack.push(t1 + t2);
                            break;
                        case '-':
                            stack.push(t2 - t1);
                            break;
                        case '*':
                            stack.push(t1 * t2);
                            break;
                        case '/':
                            stack.push(t2 / t1);
                            break;
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            result =  stack.pop();
        }
        return result;
    }




    static int priority(char ch){
        switch (ch) {
            case ('+'):
            case ('-'):
                return 1;
            case ('*'):
                return 2;
            case ('/'):
                return 3;
            default:
                return 0;
        }
    }

    static boolean isOperator(char c){
        if (c == '+' || c == '-' || c =='*' || c == '/' ){
            return true;
        }
        return false;
    }
}



