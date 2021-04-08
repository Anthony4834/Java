package com.anthony4834.objectmaster;

public class Human {
	private int strength = 3;
	private int stealth = 3;
	private int intel = 3;
	private int health = 100;
	
	private String name;
	
	public Human(String name) {
		this.setName(name);
	}
	
	public void attackHuman(Human target) {
		target.setHealth(target.getHealth() - this.getStrength()); 
		if(target.getHealth() < 0) {
			target.setHealth(0);
		}
		System.out.println(String.format("%s attacked %s, lowering their health by %s points to %s",this.getName(), target.getName(), this.getStrength(), target.getHealth()));
		if(target.getHealth() == 0) {
			System.out.println(String.format("%s died", target.getName()));
		}
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
