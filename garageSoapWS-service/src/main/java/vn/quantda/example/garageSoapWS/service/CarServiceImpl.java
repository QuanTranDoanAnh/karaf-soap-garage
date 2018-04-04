package vn.quantda.example.garageSoapWS.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.quantda.example.garageSoapWS.model.Car;
import vn.quantda.example.garageSoapWS.model.dao.CarDao;

public class CarServiceImpl implements CarService {

	private CarDao carDao;
	
	// Get Log Service of OSGi
	private static final Logger LOG = LoggerFactory.getLogger(CarDao.class);
	
	
	@Override
	public Car getCarById(int carId) {
		LOG.info(getClass().getSimpleName() + "[getCarById({})]", carId);
		return carDao.getCar(carId);
	}

	@Override
	public List<Car> getAllCars() {
		LOG.info(getClass().getSimpleName() + "[getAllCars()]");
		return carDao.findAllCars();
	}

	@Override
	public Car addCar(String brand, String model, String category, String color, String price) {
		LOG.info(getClass().getSimpleName() + "[addCar(" + brand + "," + model + "," + category + "," + color + "," + price +")]");
		return carDao.addCar(brand, model, category, color, price);
	}

	public void setCarDao(final CarDao carDao) {
		this.carDao = carDao;
	}
	
	

	
}
