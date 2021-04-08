package com.anthony4834.objectmaster;//String name, int strength, int stealth, int intel, int health
public class Ninja extends Human {
	public Ninja(String name) {
		super(name);
		this.setStealth(10);
	}
	public void steal(Human target) {
		target.setHealth(target.getHealth() - this.getStealth());
		System.out.println(String.format("Ninja %s stole %s points of health from %s, decreasing their health to %s", this.getName(), this.getStealth(), target.getName(), target.getHealth()));
	}
	public void run() {
		this.setHealth(this.getHealth() - 10);
		System.out.println(String.format("Ninja %s fled from battle, decreasing his health by 10 points to %s", this.getName(), this.getHealth()));
	}
}
