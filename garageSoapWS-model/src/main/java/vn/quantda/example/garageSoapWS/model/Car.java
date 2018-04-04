package vn.quantda.example.garageSoapWS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The Car class is a JAVA object containing Get and Set methods
 * <p/>
 * By adding the @XmlRootElement annotation, we give the possibility to JAXB to transform this object 
 * into XML document XML vice versa.
 * <p/>
 * The XML representation of a Car looks like following :
 * <Car>
 * <idCar>1</idCar>
 * <brand>RENAULT</brand>
 * <model>SCENIC</model>
 * <category>Monospace</category>
 * <color>Gris</color>
 * <price>20000</price>
 * </Car> 
 */
@XmlRootElement(name="Car")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder= {"idCar","brand","model","category","color","price"})
@Entity
public class Car {
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCar;
	
	@Column(name = "brand", length = 30)
    private String brand;
    
    @Column(name = "model", length = 30)
    private String model;
    
    @Column(name = "category", length = 30)
    private String category;
    
    @Column(name = "color", length = 30)
    private String color;
     
    @Column(name = "price")
    private int price;

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
    
	@Override
    public String toString() 
    {
      return getClass().getSimpleName() + "[idCar=" + idCar + ", brand=" + brand + ", model=" + model + ", category=" + category + ", color=" + color + "]";
    }
}
