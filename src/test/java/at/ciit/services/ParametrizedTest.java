package at.ciit.services;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import at.ciit.products.Car;
import at.ciit.products.options.EngineOptions;
import at.ciit.products.options.WheelOptions;
import at.ciit.services.Corporation;
import at.ciit.services.Region;

@RunWith(Parameterized.class)
public class ParametrizedTest {
	@Parameters(name = "Availability AT: ({0}, {1})={2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ EngineOptions.DIESEL_1_8, WheelOptions.SPORT, false },
				{ EngineOptions.DIESEL_1_8, WheelOptions.NORMAL, false },
				{ EngineOptions.DIESEL_2_4, WheelOptions.SPORT, true },
				{ EngineOptions.DIESEL_2_4, WheelOptions.NORMAL, false}
		});
	}

	
	/* Parameters should NOT be private */
	@Parameter(0)
	public EngineOptions inputEngine;
	@Parameter(1)
	public WheelOptions inputWheel;
	@Parameter(2)
	public boolean expectedAvailability;

	private Corporation corp;
	private Car car;

	@Before
	public void init() {
		corp = new Corporation();
		car = new Car();
	}

	@Test
	public void austriaRegion_supportsOnlySportWheelsWithDiesel_2_4() {
		car.setEngineType(inputEngine);
		car.setWheelType(inputWheel);
		Assert.assertEquals(expectedAvailability, corp.checkAvailabily(car, Region.AT));
	}
	
	@Test
	public void corporationIsNotNull() {
		Assert.assertNotNull(corp);
	}

}
