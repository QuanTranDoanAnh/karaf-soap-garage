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
package vn.quantda.example.garageSoapWS.webui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.quantda.example.garageSoapWS.jaxws.CarSoapService;
import vn.quantda.example.garageSoapWS.model.Car;

public class CarServlet extends HttpServlet {
    
	private static final long serialVersionUID = -5896342395456213489L;
    private CarSoapService carService;
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        ServletOutputStream os = resp.getOutputStream();
        List<Car> cars = carService.getAllCars();
        os.println("<html><body>");
        os.println("<h2>Cars</h2>");
        os.println("<table>");
        os.println("<tr><th>Id</th><th>Brand</th><th>Model</th><th>Category</th><th>Color</th><th>Price</th></tr>");
        for (Car car : cars) 
        {
            os.println(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", car.getIdCar(), car.getBrand(), car.getModel(), car.getCategory(), car.getColor(), car.getPrice()));
        }
        os.println("</table>");
        os.println("<h2>Ajouter car</h2>");
        //Creation d'un formulaire dont l'action est definie dans le fichier blueprint.xml
        os.println("<form name='input' action='/carui' method='post'>");
        os.println("<table>");
        os.println("<tr><td>Brand</td><td><input type='text' name='brand'/></td></tr>");
        os.println("<tr><td>Model</td><td><input type='text' name='model'/></td></tr>");
        os.println("<tr><td>Category</td><td><input type='text' name='category'/></td></tr>");
        os.println("<tr><td>Color</td><td><input type='text' name='color'/></td></tr>");
        os.println("<tr><td>Price</td><td><input type='text' name='price'/></td></tr>");
        os.println("<tr><td colspan='2'><input type='submit' value='Ajouter'/></td></tr>");
        os.println("</form>");
        os.println("</table>");
        os.println("</body></html>");
    }
    
    
    /**
     * Methode permettant de recuperer ce qui est envoye par le formulaire (en POST) et d'enregistrer une nouvelle car en base
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String category = req.getParameter("category");
        String color = req.getParameter("color");
        String price = req.getParameter("price");
        
        carService.addCar(brand, model, category, color, price);
        resp.sendRedirect("/carui");
    }

    public void setCarService(CarSoapService carService) 
    {
        this.carService = carService;
    }
    
}