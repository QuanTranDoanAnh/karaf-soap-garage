/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vn.quantda.example.garageSoapWS.jaxws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.quantda.example.garageSoapWS.model.Car;
import vn.quantda.example.garageSoapWS.service.CarService;

public class CarSoapServiceImpl implements CarSoapService {

	private CarService carService;
	
	//Recuperation du logger de la classe VoitureMetierImpl
    private static final Logger LOG = LoggerFactory.getLogger(CarSoapService.class);
	
	@Override
	public Car getCar(int carId) {
		LOG.info(getClass().getSimpleName() + "[getCar({})]", carId);
		return carService.getCarById(carId);
	}

	@Override
	public List<Car> getAllCars() {
		LOG.info(getClass().getSimpleName() + "[getAllCars()]");
		return carService.getAllCars();
	}

	@Override
	public Car addCar(String brand, String model, String category, String color, String price) {
		LOG.info(getClass().getSimpleName() + "[addCar(" + brand + "," + model + "," + category + "," + color + "," + price + ")]");
		return carService.addCar(brand, model, category, color, price);
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}
    
}