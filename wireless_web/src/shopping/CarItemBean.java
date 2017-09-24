package shopping;

import java.io.Serializable;

import entity.Menutbl;


public class CarItemBean implements Serializable {
	private Menutbl menu = null;
	
	private int number = 1;
	
	public CarItemBean() {
		super();
	}
	public CarItemBean(Menutbl menu) {
		this.menu = menu;
		this.number = 1;
	}
	public Menutbl getMenu() {
		return menu;
	}
	public void setProduct(Menutbl menu) {
		this.menu = menu;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public double getItemPrice(){
		int price = menu.getPrice()*number;
		return price;
	}
}
