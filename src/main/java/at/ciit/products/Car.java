package at.ciit.products;

import java.util.List;

import at.ciit.products.Engine;
import at.ciit.products.Product;
import at.ciit.products.Wheel;
import at.ciit.products.options.EngineOptions;
import at.ciit.products.options.WheelOptions;

public class Car extends Product {
	
	private List<Wheel> wheels;
	
	private Engine engine;
	
	private EngineOptions engineType;
	
	private WheelOptions wheelType;

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public WheelOptions getWheelType() {
		return wheelType;
	}

	public void setWheelType(WheelOptions wheelType) {
		this.wheelType = wheelType;
	}

	public void setEngineType(EngineOptions engineType) {
		this.engineType = engineType;
	}

	public EngineOptions getEngineType() {
		return engineType;
	}
}
