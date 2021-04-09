package com.anthony4834.calculator;

public class Calculator implements java.io.Serializable {
	private static final long serialVersionUID = 0;
	private double operandOne;
	private double operandTwo;
	private char operation;
	
	public double showResult() {
		if(this.getOperation() == '+') {
			return this.getOperandOne() + this.getOperandTwo();
		} else {
			return this.getOperandOne() - this.getOperandTwo();
		}
	}
	
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	
	
}
