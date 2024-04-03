package com.learning.core;

// Interface to represent a drug
interface MedicineInfo {
	void displayLabel();
}

// Tablet class implementing MedicineInfo
class Tablet implements MedicineInfo {
	@Override
	public void displayLabel() {
		System.out.println("Store Tablets in a cool dry place");
	}
}

// Syrup class implementing MedicineInfo
class Syrup implements MedicineInfo {
	@Override
	public void displayLabel() {
		System.out.println("Syrup is consumable only on prescription");
	}
}

// Ointment class implementing MedicineInfo
class Ointment implements MedicineInfo {
	@Override
	public void displayLabel() {
		System.out.println("Ointment is for external use only");
	}
}

public class D01P01 {
	public static void main(String[] args) {
		// Declare instances of Medicine
		MedicineInfo tablet = new Tablet();
		MedicineInfo syrup = new Syrup();
		MedicineInfo ointment = new Ointment();

		// Check polymorphic behavior
		tablet.displayLabel();
		syrup.displayLabel();
		ointment.displayLabel();
	}
}
