package practica2MicroReactivos;

import java.math.BigDecimal;

public class Product2 {

	public String name;
	public BigDecimal price;
	public Tax tax;
	
	public Product2(String name, BigDecimal price, Tax tax) {
		super();
		this.name = name;
		this.price = price;
		this.tax = tax;
	}
}
