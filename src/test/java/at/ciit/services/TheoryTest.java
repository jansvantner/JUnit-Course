package at.ciit.services;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import at.ciit.products.Car;
import at.ciit.products.options.EngineOptions;
import at.ciit.products.options.WheelOptions;

@RunWith(Theories.class)
public class TheoryTest {
    @DataPoints
    public static EngineOptions[] engines() {
        return EngineOptions.values();
    }
    @DataPoints
    public static WheelOptions[] wheels() {
        return WheelOptions.values();
    }
	
	private Corporation corp;
	private Car car;

	@Before
	public void init() {
		corp = new Corporation();
		car = new Car();
	}

	@Theory
	public void slovakiaRegion_SupportsOnlyEngine1_8(EngineOptions engine, WheelOptions wheel) {
		Assume.assumeThat(engine, not(EngineOptions.DIESEL_1_8));
		car.setEngineType(engine);
		car.setWheelType(wheel);
		
		Assert.assertFalse("Should fail for parameters: " + engine + " - " + wheel, 
				corp.checkAvailabily(car, Region.SK));
	}
	
}
