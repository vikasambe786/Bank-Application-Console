
public class Customer {
	String name;
	Account account;
	
	
	
	public Customer(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}
	public void display() {
		System.out.println("Name : "+name+ " Account Number : "+account.getAccountNumber()+ " Balance : "+account.getBalance());
		
	}
	public String getName() {
		return name;
		
	}
	public Account getAccount() {
		return account;
		
	}

}
