package com.anthony4834.zookeeper;

public class Gorilla extends Mammal {
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	public void throwSomething() {
		System.out.println("Gorilla throws something | -5 energy");
		this.setEnergyLevel(this.getEnergyLevel() - 5);
	}
	public void eatBanana() {
		System.out.println("Gorilla eats a banana | +10 energy");
		this.setEnergyLevel(getEnergyLevel() + 10);
	}
	public void climb() {
		System.out.println("Gorilla climbs a tree | -10 energy");
		this.setEnergyLevel(getEnergyLevel() - 10);
	}
}
