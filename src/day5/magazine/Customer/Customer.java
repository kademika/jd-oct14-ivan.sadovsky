package day5.magazine.Customer;

public class Customer {

private String name;
	
	public Customer(){
		name="Temporary customer";
	}

	public Customer(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}

