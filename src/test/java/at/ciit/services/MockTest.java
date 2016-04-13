package at.ciit.services;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import at.ciit.products.Car;
import at.ciit.products.Engine;
import at.ciit.products.Wheel;
import at.ciit.products.options.EngineOptions;
import at.ciit.products.options.WheelOptions;
import at.ciit.services.factories.CarFactory;
import at.ciit.services.factories.EngineFactory;
import at.ciit.services.factories.WheelsFactory;

public class MockTest {

	private CarFactory factory;
	private EngineFactory engineFactory;
	private WheelsFactory wheelsFactory;
	private Branch branch;
	private Car car;
	
	private Engine expectedEngine;
	private Wheel[] expectedWheels = new Wheel[4];
	
	@Before
	public void setUp() {
		factory = new CarFactory();
		
		engineFactory = Mockito.mock(EngineFactory.class);
		wheelsFactory = Mockito.mock(WheelsFactory.class);
		branch = new Branch(Region.AT);
		
		factory.setEngineFactory(engineFactory);
		factory.setWheelFactory(wheelsFactory);
				
		car = new Car();
		expectedEngine = new Engine();
		for (int i = 0; i < 4; i++) {
			expectedWheels[i] = new Wheel();			
		}
	}
	
	@Test
	public void testCar() {
		Mockito.when(engineFactory.manufacture(Matchers.any(EngineOptions.class))).thenReturn(expectedEngine);
		Mockito.when(wheelsFactory.manufacture(Matchers.any(WheelOptions.class)))
			.thenReturn(expectedWheels[0]).thenReturn(expectedWheels[1])
			.thenReturn(expectedWheels[2]);
			
		System.out.println(expectedEngine);
		factory.manufacture(car, branch);
		
		Assert.assertEquals(expectedEngine, car.getEngine());
		Assert.assertEquals(4, car.getWheels().size());
		
		Mockito.verify(wheelsFactory, Mockito.times(4)).manufacture(Matchers.any(WheelOptions.class));
	}
	
}
