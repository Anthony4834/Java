package com.anthony4834.objectmaster;

public class Samurai extends Human {
	private static int samuraiCount = 0;
	
	public Samurai(String name) {
		super(name);
		this.setHealth(200);
		samuraiCount++;
	}
	public void deathBlow(Human target) {
		target.setHealth(0);
		this.setHealth(getHealth() / 2);
		System.out.println(String.format("Samurai %s used Death Blow on %s - Killing %s and decreasing %s's health by %s to %s", this.getName(), target.getName(), target.getName(), this.getName(), this.getHealth(), this.getHealth()));
	}
	public void meditate() {
		int healAmount = this.getHealth() / 2;
		this.setHealth(this.getHealth() + healAmount);
		System.out.println(String.format("Samurai %s used Meditate, healing him for %s points to %s", this.getName(), healAmount, this.getHealth()));
	}
	public void howMany() {
		System.out.println(String.format("Samurais active: [%s]", samuraiCount));
	}
}
