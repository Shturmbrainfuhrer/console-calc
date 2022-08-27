package com.company;

import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        if (in.hasNextLine()) {
            String expression = in.nextLine();
            String postfix = Calc.makePostfix(expression);
            System.out.println(Calc.calcPostfix(postfix));
        }
    }
}



