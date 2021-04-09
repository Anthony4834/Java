package com.anthony4834.calculator;

public class Run {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		c.setOperandOne(9123);
		c.setOperation('-');
		c.setOperandTwo(742894);
		System.out.println(c.showResult());
	}
}
