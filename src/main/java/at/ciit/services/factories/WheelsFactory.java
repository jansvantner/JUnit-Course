package at.ciit.services.factories;

import at.ciit.products.Wheel;
import at.ciit.products.options.WheelOptions;
import at.ciit.products.states.ProductState;

public class WheelsFactory {
	public Wheel manufacture(WheelOptions setup) {
		Wheel wheel = new Wheel();
		wheel.setType(setup);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}		
		wheel.setState(ProductState.MANUFACTURED);
		System.out.println("--- wheels manufactured ---");
		return wheel;
	}	
}
