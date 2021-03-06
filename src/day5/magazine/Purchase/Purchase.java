package day5.magazine.Purchase;

import java.util.Date;

import day5.magazine.Service.Store;
import day5.magazine.Customer.*;
import day5.magazine.Guitar.*;

public class Purchase {

	private Customer customer;
	private Guitar guitar;
	private int number;
	private Date date;

	public Purchase(Store store, GuitarType guitarType,
			GuitarBrand guitarBrand, String model, int number) {
		// TODO Auto-generated constructor stub
		Customer customerTemp = new Customer();
		customer = customerTemp;
		int k = guitarType.ordinal();
		int i = guitarBrand.ordinal();
		int j = store.getGuitarIndexByModel(k, i, model);
		this.number = number;
		this.date = new Date();

		try {
			if (j != -1) {

				this.guitar = store.getGuitar()[k][i][j];
				executePurchase(store, k, i, model, number);

			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.err.println("There is no such guitar in store!");
		} catch (IllegalStateException e) {			
			System.err.println("Illegal number! We don't have it in store");		
		}

	}

	public Purchase(Store store, GuitarType guitarType,
			GuitarBrand guitarBrand, String model, int number,
			String customerName, Date date) {
		// TODO Auto-generated constructor stub
		Customer customer = new Customer(customerName);
		this.customer = customer;
		int k = guitarType.ordinal();
		int i = guitarBrand.ordinal();
		int j = store.getGuitarIndexByModel(k, i, model);
		this.number = number;
		this.date = date;

		try {
			if (j != -1) {

				this.guitar = store.getGuitar()[k][i][j];
				executePurchase(store, k, i, model, number);

			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.err.println("There is no such guitar in store!");
		} catch (IllegalStateException e) {			
			System.err.println("Illegal number! We don't have it in store");		
		}

	}

	public Customer getCustomer() {
		return customer;
	}

	public Guitar getGuitar() {
		return guitar;
	}

	public int getNumber() {
		return number;
	}

	public Date getDate() {
		return date;
	}

	private void executePurchase(Store store, int k, int i, String model,
			int number) throws IllegalStateException {

		if (number < 1 || number > store.getGuitarNumberByModel(k, i, model)) {
			throw new IllegalStateException();
		}

		for(int idx=0; idx<number; idx++){
			int j = store.getGuitarIndexByModel(k, i, model);			
			store.getGuitar()[k][i][j] = null;
			
		}	

		int kol = 0;
		while (store.getPurchase()[kol] != null) {
			kol++;
		}
		store.getPurchase()[kol] = this;

	}

}