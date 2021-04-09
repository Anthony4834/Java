package com.anthony4834.phone;

public class IPhone extends Phone implements Ringable {
	
	public IPhone(String version, int batt, String carrier, String tone) {
		super(version, batt, carrier, tone);
	}
	
	@Override
	public String ring() {
		return String.format("iPhone %s says %s", this.getVersionNumber(), this.getRingTone());
	}

	@Override
	public String unlock() {
		return String.format("Unlocking from FaceID");
	}

	@Override
	public void displayInfo() {
		System.out.println(String.format("iPhone %s from %s", this.getVersionNumber(), this.getCarrier()));
	}

}
