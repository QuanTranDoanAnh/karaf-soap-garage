package vn.quantda.example.garageSoapWS.model.dao;

import java.util.List;

import vn.quantda.example.garageSoapWS.model.Car;

public interface CarDao {
	public Car getCar(final int idCar);
	public List<Car> findAllCars();
	public Car addCar(String brand, String model, String category, String color, String price);
}
