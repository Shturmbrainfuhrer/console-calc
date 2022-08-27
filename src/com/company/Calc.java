package com.company;

import java.util.Stack;

public class Calc {
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

    static Double calcPostfix(String postfixExpression) {
        Double result = 1.0;
        String[] str = postfixExpression.split(" ");
        Stack<Double> stack = new Stack();

        for (String s : str) {
            for (int j = 0; j < s.length(); j++) {
                char current = s.charAt(j);
                if (!isOperator(current)) {
                    stack.push(Double.parseDouble(s));
                } else {
                    double t1 = stack.pop();
                    double t2 = stack.pop();

                    switch (current) {
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

    static Double calc(String expression) {
        String postfix = Calc.makePostfix("(21+9)*7-8");
        return Calc.calcPostfix(postfix);
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
