package at.ciit.products;

import at.ciit.products.options.WheelOptions;

public class Wheel extends Product {
	
	private WheelOptions type;
	
	public WheelOptions getType() {
		return type;
	}

	public void setType(WheelOptions type) {
		this.type = type;
	}

}
