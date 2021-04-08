package com.anthony4834.objectmaster;

public class Run {

	public static void main(String[] args) {
		
		Human john = new Human("John");
		Human jeff = new Human("Jeff");
		Wizard gandalf = new Wizard("Gandalf");
		Ninja sasuke = new Ninja("Sasuke");
		Samurai kakashi = new Samurai("Kakashi");
		Samurai naruto = new Samurai("Naruto");
		Samurai sage = new Samurai("Sage");
		
		john.attackHuman(jeff);
		gandalf.fireball(john);
		gandalf.heal(jeff);
		sasuke.steal(gandalf);
		sasuke.run();
		kakashi.deathBlow(jeff);
		kakashi.meditate();
		kakashi.howMany();
	}

}
