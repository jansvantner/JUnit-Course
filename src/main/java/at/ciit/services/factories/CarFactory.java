package at.ciit.services.factories;

import java.util.ArrayList;
import java.util.List;

import at.ciit.products.Car;
import at.ciit.products.Engine;
import at.ciit.products.Wheel;
import at.ciit.products.states.ProductState;
import at.ciit.services.Branch;
import at.ciit.services.TransportCompany;

public class CarFactory {
	
	private static final int NUMBER_OF_WHEELS_PER_CAR = 4;
	
	private EngineFactory engineFactory = new EngineFactory();
	private WheelsFactory wheelFactory = new WheelsFactory();
	private TransportCompany transport = new TransportCompany();

	public void manufacture(Car p, Branch b) {
		manufactureWheels(p);	
		manufactureEngine(p);
		manufacture(p);				
		System.out.println("--- car manufactured ---");
		getTransport().moveToBranch(p, b);
	}

	public void manufacture(Car c) {
		try {			
			Thread.sleep(100);
			c.setWheels(getCarWheels());
			c.setEngine(getCarEngine());
			c.setState(ProductState.MANUFACTURED);	
		} catch (InterruptedException ignored) {
		}
	}

	private Engine getCarEngine() {
		return new Engine();
	}

	private List<Wheel> getCarWheels() {
		return new ArrayList<Wheel>();
	}

	private void manufactureEngine(Car p) {
		getEngineFactory().manufacture(p.getEngineType());
	}

	private void manufactureWheels(Car p) {
		for (int i = 0; i < NUMBER_OF_WHEELS_PER_CAR; i++) {
			getWheelFactory().manufacture(p.getWheelType());
		}		
	}

	public EngineFactory getEngineFactory() {
		return engineFactory;
	}

	public void setEngineFactory(EngineFactory engineFactory) {
		this.engineFactory = engineFactory;
	}

	public WheelsFactory getWheelFactory() {
		return wheelFactory;
	}

	public void setWheelFactory(WheelsFactory wheelFactory) {
		this.wheelFactory = wheelFactory;
	}

	public TransportCompany getTransport() {
		return transport;
	}

	public void setTransport(TransportCompany transport) {
		this.transport = transport;
	}
}
