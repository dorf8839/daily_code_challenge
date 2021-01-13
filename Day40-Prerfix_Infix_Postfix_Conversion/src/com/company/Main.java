package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Prerfix, Infix, and Postfix Conversion ===== */");
        //Convert infix to postfix
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Original Infix Expression:\n" + exp);
        System.out.println("Converted Postfix Expression:\n" + infixToPostfix(exp));

        //Convert infix to prefix
        exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Original Infix Expression:\n" + exp);
        System.out.println("Converted Prefix Expression:\n" + infixToPrefix(exp));

        //Convert postfix to infix
        exp = "abcd^e-fgh*+^*+i-";
        System.out.println("Original Postfix Expression:\n" + exp);
        System.out.println("Converted Infix Expression:\n" + getInfix(exp));
    }

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");
        // initializing empty stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)) {
                result += c;
                // If the scanned character is an '(',
                // push it to the stack.
            } else if (c == '(') {
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            } else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else { // an operator is encountered
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    // Function to check if
    // given character is
    // an operator or not.
    static boolean isOperator(char c) {
        return (!(c >= 'a' && c <= 'z') &&
                !(c >= '0' && c <= '9') &&
                !(c >= 'A' && c <= 'Z'));
    }

    // Function to find priority
    // of given operator.
    static int getPriority(char C) {
        if (C == '-' || C == '+') {
            return 1;
        } else if (C == '*' || C == '/') {
            return 2;
        } else if (C == '^') {
            return 3;
        }
        return 0;
    }

    // Function that converts infix
    // expression to prefix expression.
    static String infixToPrefix(String infix) {
        // stack for operators.
        Stack<Character> operators = new Stack<Character>();
        // stack for operands.
        Stack<String> operands = new Stack<String>();
        for (int i = 0; i < infix.length(); i++) {
            // If current character is an
            // opening bracket, then
            // push into the operators stack.
            if (infix.charAt(i) == '(') {
                operators.push(infix.charAt(i));
            }
            // If current character is a
            // closing bracket, then pop from
            // both stacks and push result
            // in operands stack until
            // matching opening bracket is
            // not found.
            else if (infix.charAt(i) == ')') {
                while (!operators.empty() && operators.peek() != '(') {
                    // operand 1
                    String op1 = operands.peek();
                    operands.pop();
                    // operand 2
                    String op2 = operands.peek();
                    operands.pop();
                    // operator
                    char op = operators.peek();
                    operators.pop();
                    // Add operands and operator
                    // in form operator +
                    // operand1 + operand2.
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }
                // Pop opening bracket
                // from stack.
                operators.pop();
            } else if (!isOperator(infix.charAt(i))) {
                // If current character is an
                // operand then push it into
                // operands stack.
                operands.push(infix.charAt(i) + "");
            } else {
                // If current character is an
                // operator, then push it into
                // operators stack after popping
                // high priority operators from
                // operators stack and pushing
                // result in operands stack.
                while (!operators.empty() &&
                        getPriority(infix.charAt(i)) <=
                                getPriority(operators.peek())) {

                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    char op = operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }
                operators.push(infix.charAt(i));
            }
        }

        // Pop operators from operators
        // stack until it is empty and
        // operation in add result of
        // each pop operands stack.
        while (!operators.empty()) {
            String op1 = operands.peek();
            operands.pop();

            String op2 = operands.peek();
            operands.pop();

            char op = operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }
        // Final prefix expression is
        // present in operands stack.
        return operands.peek();
    }

    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }

    // Get Infix for a given postfix
    // expression
    static String getInfix(String exp) {
        Stack<String> s = new Stack<String>();
        for (int i = 0; i < exp.length(); i++) {
            // Push operands
            if (isOperand(exp.charAt(i))) {
                s.push(exp.charAt(i) + "");
            } else {
                // We assume that input is
                // a valid postfix and expect
                // an operator.
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + exp.charAt(i) +
                        op1 + ")");
            }
        }
        // There must be a single element
        // in stack now which is the required
        // infix.
        return s.peek();
    }
}
