package vn.quantda.example.garageSoapWS.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.osgi.service.log.LogService;

import vn.quantda.example.garageSoapWS.model.Car;

public class CarDaoImpl implements CarDao {

	// @PersistenceContext allows retrieving EntityManager. The unitName is provided
	// in thepersistence.xml file (in the tag <persistence-unit name="garage"
	// transaction-type="JTA">)
	//
	@PersistenceContext(unitName = "garage")
	protected EntityManager entityManager;

	protected LogService logService;

	/**
	 * The method getCar allows retrieve a Car with an Id
	 */
	@Override
	public Car getCar(int idCar) {
		logService.log(LogService.LOG_INFO, getClass().getSimpleName() + "[getCar(" + idCar + ")]");
		if (entityManager == null) {
			logService.log(LogService.LOG_INFO, getClass().getSimpleName()
					+ "/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\");
			logService.log(LogService.LOG_INFO, getClass().getSimpleName()
					+ "/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\EntityManager is null/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\");
			logService.log(LogService.LOG_INFO, getClass().getSimpleName()
					+ "/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\/!\\");
		}
		return entityManager.find(Car.class, idCar);
	}

	/**
	 * The method findAllCars allows finding all Cars
	 */
	@Override
	public List<Car> findAllCars() {
		logService.log(LogService.LOG_INFO, getClass().getSimpleName() + "[findAllCars()]");

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);
		Root<Car> rootEntry = cq.from(Car.class);
		CriteriaQuery<Car> all = cq.select(rootEntry);
		TypedQuery<Car> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	/**
	 * The method addCar allows adding a Car to the DB
	 */
	@Override
	public Car addCar(String brand, String model, String category, String color, String price) {
		logService.log(LogService.LOG_INFO, getClass().getSimpleName() + "[ajouterVoiture(" + brand + "," + model + ","
				+ category + "," + color + "," + price + ")]");

		Car car = new Car();
		car.setBrand(brand);
		car.setModel(model);
		car.setCategory(category);
		car.setColor(color);
		car.setPrice(Integer.parseInt(price));

		entityManager.persist(car);
		return car;
	}

	public void setLogService(final LogService logService) {
		this.logService = logService;
	}
	

}
