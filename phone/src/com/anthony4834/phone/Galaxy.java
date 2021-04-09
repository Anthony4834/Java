package com.anthony4834.phone;

public class Galaxy extends Phone implements Ringable {
	
	public Galaxy(String version, int batt, String carrier, String tone) {
		super(version, batt, carrier, tone);
		
	}

	@Override
	public String ring() {
		return String.format("Galaxy %s says %s", this.getVersionNumber(), this.getRingTone());
	}

	@Override
	public String unlock() {
		return String.format("Unlocking from fingerprint");
	}

	@Override
	public void displayInfo() {
		System.out.println(String.format("Galaxy %s from %s", this.getVersionNumber(), this.getCarrier()));
	}

}
