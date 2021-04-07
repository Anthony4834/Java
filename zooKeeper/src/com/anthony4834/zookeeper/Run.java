package com.anthony4834.zookeeper;

public class Run {
	public static void main(String[] args) {
		Gorilla harambe = new Gorilla(200);
		harambe.throwSomething();
		System.out.println(String.format("Energy level: %s", harambe.getEnergyLevel()));
		harambe.eatBanana();
		System.out.println(String.format("Energy level: %s", harambe.getEnergyLevel()));
		harambe.climb();
		System.out.println(String.format("Energy level: %s", harambe.getEnergyLevel()));
	}
}
