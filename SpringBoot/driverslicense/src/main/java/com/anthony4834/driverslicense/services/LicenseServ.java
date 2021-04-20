package com.anthony4834.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony4834.driverslicense.models.License;
import com.anthony4834.driverslicense.repositories.LicenseRepo;

@Service
public class LicenseServ {
	private final LicenseRepo licenseR;
	
	public LicenseServ(LicenseRepo r) {
		this.licenseR = r;
	}
	
	public List<License> findAll() {
		return licenseR.findAll();
	}
	public License findByPerson_id(Long id) {
		Optional<License> l = licenseR.findByPerson_id(id);
		if(l.isPresent()) {
			return l.get();
		}
		return null;
	}
	public License createLicense(License l) {
		return licenseR.save(l);
	}
	public License findLicense(Long id) {
		Optional<License> l = licenseR.findById(id);
		if(l.isPresent()) {
			return l.get();
		}
		return null;
	}
}
