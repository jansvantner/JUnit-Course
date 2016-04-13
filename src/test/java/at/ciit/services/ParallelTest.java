package at.ciit.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import at.ciit.products.Car;
import at.ciit.products.states.ProductState;
import at.ciit.services.factories.CarFactory;

@Ignore
//@RunWith(ConcurrentTestRunner.class)
public class ParallelTest {

	CarFactory factory;
	Branch branchVienna;
	Branch branchSalzburg;
	List<Car> carsToManufacture;
	
	@Before
	public void setUp() {
		factory = new CarFactory();
		branchVienna = new Branch(Region.AT);
		branchSalzburg = new Branch(Region.AT);
		carsToManufacture = new ArrayList<Car>();
		for (int i = 0; i < 15; i++) {
			carsToManufacture.add(new Car());			
		}
	}
	
	
	@Test
	public void testManufactoringForDifferentBranches() {
		int i = 0;
		for (Car car : carsToManufacture) {
			Branch b = (i%3 == 0)? branchVienna: branchSalzburg;
			factory.manufacture(car, b);
			i++;
		}
		
		Assert.assertEquals(5, branchVienna.getStored().size());
		Assert.assertEquals(10, branchSalzburg.getStored().size());
	}
	
	@Test
	public void testStateOfCars() {
		for (Car car : carsToManufacture) {
			factory.manufacture(car, branchVienna);
		}
		for (Car car : carsToManufacture) {
			Assert.assertEquals(ProductState.IN_TRANSPORT, car.getState());
		}
	}
	
}
