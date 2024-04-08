package com.learning.day4;

import java.util.Scanner;
import java.util.Stack;

public class D04P03 {

	public static int evaluateExpression(String expression) {
		char[] a = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Integer> values = new Stack<Integer>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < a.length; i++) {

			// Current character is a whitespace, skip it
			if (a[i] == ' ')
				continue;

			// Current character is a number,push it to stack 
			if (a[i] >= '0' && a[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();

				// There may be more than one digits in number
				while (i < a.length && a[i] >= '0' && a[i] <= '9')
					sbuf.append(a[i++]);
				values.push(Integer.parseInt(sbuf.toString()));

				i--;
			}

			// Current character is an opening brace,
			// push it to 'ops'
			else if (a[i] == '(')
				ops.push(a[i]);

			// Closing brace encountered,
			// solve entire brace
			else if (a[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			// Current token is an operator.
			else if (a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') {
				while (!ops.empty() && hasPrecedence(a[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				// Push current token to 'ops'.
				ops.push(a[i]);
			}
		}

		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		
		return values.pop();
	}

	// Returns true if 'op2' has higher
	// or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	
	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the expression: ");
		String expression = scanner.nextLine();

		try {
			double result = evaluateExpression(expression);
			System.out.println("Result: " + result);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
