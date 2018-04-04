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

import javax.jws.WebService;

import vn.quantda.example.garageSoapWS.model.Car;

/**
 * Note the existence of the @WebService annotation to tell "jaxws" that this
 * interface will implement a web service. In other words, the methods of this
 * interface can be called by a client of the service.
 * 
 * @author QuanTDA1
 *
 */
@WebService
public interface CarSoapService {

	public Car getCar(final int carId);

	public List<Car> getAllCars();

	public Car addCar(String brand, String model, String category, String color, String price);

}