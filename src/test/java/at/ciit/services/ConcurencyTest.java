package at.ciit.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import at.ciit.products.Car;
import at.ciit.products.states.ProductState;
import at.ciit.services.factories.CarFactory;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;

@Ignore
//@RunWith(ConcurrentTestRunner.class)
public class ConcurencyTest {

	private static CarFactory factory;
	private static Branch branch;
	private static List<Car> carsToManufacture;
	
	@Rule 
	public ConcurrentRule rule = new ConcurrentRule();
	
	@BeforeClass
	public static void setUp() {
		factory = new CarFactory();
		branch = new Branch(Region.AT);
		carsToManufacture = new ArrayList<Car>();
		for (int i = 0; i < 5; i++) {
			carsToManufacture.add(new Car());			
		}
	}
	
	@Test
    @Concurrent (count = 5)
	public void testStateOfCars() {
		for (Car car : carsToManufacture) {
			factory.manufacture(car, branch);
		}
		for (Car car : carsToManufacture) {
			Assert.assertEquals(ProductState.IN_TRANSPORT, car.getState());
		}
	}
	
}
