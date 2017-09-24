package shopping;

import java.util.Collection;
import java.util.HashMap;


import entity.Menutbl;

public class ShoppingCar {
	private HashMap<Integer,CarItemBean> items = null;
	private int numOfItems = 0;
	
	public ShoppingCar(){
		this.items = new HashMap<Integer,CarItemBean>();
	}
	
	public synchronized void addItem(Integer bid,Menutbl menu){
		if(!items.containsKey(bid)){
			CarItemBean item = new CarItemBean(menu);
			items.put(bid, item);
			this.numOfItems++;
		}
	}
	
	public synchronized void deleteItem(Integer bid){
		if(items.containsKey(bid)){
			items.remove(bid);
			this.numOfItems--;
		}
	}

	public HashMap<Integer, CarItemBean> getItems() {
		return items;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public double getTotalPrice(){
		double total = 0;
		Collection<CarItemBean> cols = items.values();
		for(CarItemBean item:cols){
			total += item.getItemPrice();
		}
		return total;
	}
	
	public void clearCar(){
		this.numOfItems = 0;
		this.items.clear();
	}
	
	public synchronized boolean isExist(Integer bid){
		if(items.containsKey(bid)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
