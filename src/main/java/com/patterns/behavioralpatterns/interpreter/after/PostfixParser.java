package com.patterns.behavioralpatterns.interpreter.after;

import static com.patterns.behavioralpatterns.interpreter.after.PostfixExpression.minus;
import static com.patterns.behavioralpatterns.interpreter.after.PostfixExpression.plus;
import static com.patterns.behavioralpatterns.interpreter.after.PostfixExpression.variable;

import java.util.Stack;

public class PostfixParser {

	public static PostfixExpression parse(String expression) {
		Stack<PostfixExpression> stack = new Stack<>();
		for(char c : expression.toCharArray()) {
			stack.push(getExpression(c, stack));
		}
		
		return stack.pop();
	}

	private static PostfixExpression getExpression(char c, Stack<PostfixExpression> stack) {
		switch (c) {
		case '+':
			return plus(stack.pop(), stack.pop());
		case '-':
			PostfixExpression right = stack.pop();
			PostfixExpression left = stack.pop();
			return minus(left, right);
			
		default:
			return variable(c);
		}
	}

}
