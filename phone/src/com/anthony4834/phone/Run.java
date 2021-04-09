package com.anthony4834.phone;

public class Run {

	public static void main(String[] args) {
		IPhone iPhone10 = new IPhone("10", 99, "Verizon", "ZING");
		Galaxy s9 = new Galaxy("S9", 8, "AT&T", "RING RING RING");
		
		iPhone10.displayInfo();
		System.out.println(iPhone10.ring());
		System.out.println(iPhone10.unlock());
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
	}

}
