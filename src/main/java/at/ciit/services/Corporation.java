package at.ciit.services;

import at.ciit.products.Car;
import at.ciit.products.options.EngineOptions;
import at.ciit.products.options.WheelOptions;

public class Corporation {

	public boolean checkAvailabily(Car p, Region region) {
		if (Region.AT.equals(region)) {
			return p.getEngineType().equals(EngineOptions.DIESEL_2_4) 
					&& p.getWheelType().equals(WheelOptions.SPORT);
		}
		if (Region.DE.equals(region)) {
			return true;
		}
		if (Region.SK.equals(region)) {
			return (p.getEngineType().equals(EngineOptions.DIESEL_1_8))
					&& (p.getWheelType().equals(WheelOptions.SPORT) || p.getWheelType().equals(WheelOptions.NORMAL));
		}
		if (Region.US.equals(region)) {
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Branch b = new Branch(Region.SK);
		Car c = new Car();
		c.setEngineType(EngineOptions.DIESEL_2_4);
		c.setWheelType(WheelOptions.SPORT);
		b.order(c);
		
		System.out.println("--- customer deciding ----");
		b.sell(c);
		
	}

}
