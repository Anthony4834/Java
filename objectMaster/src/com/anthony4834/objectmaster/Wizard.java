package com.anthony4834.objectmaster;
//String name, int strength, int stealth, int intel, int health
public class Wizard extends Human {
	public Wizard(String name) {
		super(name);
		this.setIntel(8);
		this.setHealth(50);
	}
	public void heal(Human target) {
		target.setHealth(target.getHealth() + this.getIntel());
		System.out.println(String.format("Wizard %s healed %s by %s points, increasing their health to %s", this.getName(), target.getName(), this.getIntel(), target.getHealth()));
	}
	public void fireball(Human target) {
		target.setHealth(target.getHealth() - this.getIntel() * 3);
		System.out.println(String.format("Wizard %s used fireball on %s, decreasing their health by %s points to %s", this.getName(), target.getName(), this.getIntel() * 3, target.getHealth()));
	}
}
