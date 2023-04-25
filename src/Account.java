
public class Account {
	private double balance=10;
	private String accountNumber;
	private boolean firstTime=true;
	
	
	
	
	public Account(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
	

	public Account(double balance, String accountNumber) {
		if(balance>=100) {
			this.balance = balance;
		}
		else
		{
			this.balance=100;
		}
		
		this.accountNumber = accountNumber;
	}



	public void deposit(double howMuch) {
		
		if(howMuch>0) {
			balance=balance+howMuch;
			System.out.println(howMuch+" amount deposited in your account :"+accountNumber+ " \nCurent Balance : "+balance);
		}else
		{
			System.err.println("Negative Amount not Allowed");
		}
	}
	
	public void withdraw(double howMuch) {
		if(howMuch>=0) {
			if(firstTime==true) {
				double tempBalance=balance;
				tempBalance=tempBalance-howMuch;
				
				if(tempBalance>=100) {
					balance=balance-howMuch;
					System.out.println(howMuch+" amount withdrawed from your account :"+accountNumber+ " \nCurent Balance : "+balance);
				}
				else
				{
					System.err.println("Insufficient Balance : "+howMuch);
				}
				firstTime=false;
			}
			else
			{
				Bank bank=new Bank();
				double tempBalance=balance;
				tempBalance=tempBalance-howMuch-bank.getTransactionFees();
				
				if(tempBalance>=100) {
					balance=balance-howMuch-bank.getTransactionFees();
				}
				else
				{
					System.err.println("Insufficient Balance : "+howMuch);
				}
			}
			
		}
		else
		{
			System.out.println("Only Positive Amount are allowed to Withdraw");
		}
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

}
