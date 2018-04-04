package vn.quantda.example.garageSoapWS.service;

import java.util.List;

import vn.quantda.example.garageSoapWS.model.Car;

public interface CarService {

	public Car getCarById(int carId);
	public List<Car> getAllCars();
	public Car addCar(String brand, String model, String category, String color, String price);
}
