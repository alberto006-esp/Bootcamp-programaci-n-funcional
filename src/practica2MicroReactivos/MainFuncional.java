package practica2MicroReactivos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainFuncional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LISTA DE PRODUCTOS DOUBLE
		List<Product> shoppingCart = List.of(new Product("Clothes", 15.9,Tax.NORMAL),
				new Product("Bread", 1.5,Tax.SUPERREDUCED),
				new Product("Meat", 13.99, Tax.REDUCED),
				new Product("Cheese", 3.59, Tax.SUPERREDUCED),
				new Product("Coke", 1.89, Tax.REDUCED),
				new Product("Whiskey", 19.90, Tax.NORMAL));
		
		// CALCULO COSTE TOTAL SIN INMPUESTOS DOUBLE //
		Optional<Double> sumaSinImpuestos = shoppingCart.stream().map(product -> product.price).reduce((x, y) -> x + y);
		System.out.println("Cantidad total sin impuestos con Double: "+ sumaSinImpuestos.get() +"€");
		
		// CALCULO COSTE TOTAL CON INMPUESTOS DOUBLE //
		Optional<Double> sumaTotal = shoppingCart.stream().map(product -> product.price + ((product.price * product.tax.percent)/100)).reduce((x,y) -> x+y);
		System.out.println("Cantidad total con impuestos con Double: "+ sumaTotal.get() +"€");
		
		// Productos que empiezan por C.
		String productsWithC= shoppingCart.stream()
				.filter(x-> x.name.startsWith("C"))
				.sorted((x,y) -> x.name.compareToIgnoreCase(y.name)).map(x->x.name)
				.collect(Collectors.joining(",","Productos que empiezan por C: ","."));
		System.out.println(productsWithC);
		
		Optional<Double> sumaTotalEmpiezanPorC = shoppingCart.stream()
				.filter(x-> x.name.startsWith("C"))
				.map(product -> product.price + ((product.price * product.tax.percent)/100)).reduce((x,y) -> x+y);
		System.out.println("Suma total productos empiezan por C: "+sumaTotalEmpiezanPorC.get()+"€");
		
		//Lista de productos BigDecimal
		List<Product2> shoppingCart2 = List.of(new Product2("Clothes", new BigDecimal(15.9),Tax.NORMAL),
				new Product2("Bread", new BigDecimal(1.5),Tax.SUPERREDUCED),
				new Product2("Meat", new BigDecimal(13.99), Tax.REDUCED),
				new Product2("Cheese", new BigDecimal(3.59), Tax.SUPERREDUCED),
				new Product2("Coke", new BigDecimal(1.89), Tax.REDUCED),
				new Product2("Whiskey", new BigDecimal(19.90), Tax.NORMAL));
		
		BigDecimal amount = shoppingCart2.stream()
				.map(x -> x.price.add(x.price.multiply(new BigDecimal(x.tax.percent)).divide(new BigDecimal(100))))
				.reduce(BigDecimal.ZERO, (x,y) -> x.add(y)).setScale(2, RoundingMode.CEILING);
		
		// CALCULO COSTE TOTAL CON INMPUESTOS BIGDECIMAL //
        BigDecimal totalWithTaxes = shoppingCart2.stream()
                .map(product -> product.price.add(product.price.multiply(new BigDecimal(product.tax.percent)).divide(new BigDecimal(100))))
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING); 
        System.out.println("Cantidad total con impuestos con BigDecimal: "+totalWithTaxes +"€");
		
		
	}

}
