package com.company;

import java.util.Stack;
import java.util.Vector;

public class Main {

        public static void main(String[] args) {
           System.out.print(makePostfix("(2+9)*7-8"));
            Stack<Character> stack = new Stack<>();

            stack.push('(');
            stack.push('2');
            stack.push('+');
            stack.push('9');
            stack.push(')');
            // stack.push('*');
            //stack.push('7');
           // stack.push('-');
           // stack.push('8');

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
                   while (!stack.isEmpty() && priority(stack.lastElement()) > priority(current)) {
                       result.append(stack.pop());
                   }
                        stack.push(current);
                    }
                else if (current == '('){
                    stack.push(current);
                }
                else if (current == ')'){
                    while (stack.lastElement() != '('){
                        result.append(stack.pop());
                    }
                    stack.pop();

                }
                else {
                    result.append(current);
                }
            }
            while (!stack.isEmpty()){
                result.append(stack.pop());
            }


            return result.toString();
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


