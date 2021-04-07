package com.anthony4834.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		super(300);
	}
	public void fly() {
		System.out.println("Bat flies | -50 energy");
		this.setEnergyLevel(getEnergyLevel() - 50);
	}
	public void eatHumans() {
		System.out.println("Bat eats people, they scream | +25 energy");
		this.setEnergyLevel(getEnergyLevel() + 25);
	}
	public void attackTown() {
		System.out.println("Bat attacks town, it burns | -100 energy");
		this.setEnergyLevel(getEnergyLevel() - 100);
	}
}
