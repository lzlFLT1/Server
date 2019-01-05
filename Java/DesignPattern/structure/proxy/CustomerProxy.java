package kasei.javase.designpattern.structure.proxy;

public class CustomerProxy implements Person{
	private Customer customer = null;

	@Override
	public void print() {
		if(customer == null){
			customer = new Customer();
		}
		customer.print();
	}
	
}
