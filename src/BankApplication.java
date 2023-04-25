import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankApplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int numberOfCustomers=0;
		Bank bank=new Bank();
		Customer[] c=bank.getCustomers();
		
		while(true) {
			System.out.println("Please Enter Your Choice");
			System.out.println("1 : Add Customer");
			System.out.println("2: Deposit Amount");
			System.out.println("3: Withdraw Amount");
			System.out.println("4: Check Balance");
			System.out.println("5: Calculate Interest");
			System.out.println("6: Exit");
			
			
			int choice=Integer.parseInt(reader.readLine());
			
			switch (choice) {
			case 1: 
				System.out.println("Creating an new Account For Customer : ");
				
				System.out.println("Pl Enter Initial Amount in account to Create");				
				double bal=Double.parseDouble(reader.readLine());
				
				System.out.println("Pl Enter Account Number to Create Account");				
				String acc=reader.readLine();
				
				Account account=new Account(bal, acc);
				
				System.out.println("Enter Customer Name");
				String name=reader.readLine();
				
				Customer customer=new Customer(name, account);
				c[numberOfCustomers]=customer;
				numberOfCustomers++;
				
				//Code to Check Whether Customer Details getting added properly or not
				/*
				 * System.err.println("Number Of Customers "+numberOfCustomers);
				 * 
				 * for(int i=0;i<numberOfCustomers;i++) {
				 * System.err.println("NAME : "+c[i].getName()); }
				 */
				
				break;
			case 2: 
				System.out.println("Enter Account Number");
				acc=reader.readLine();
				if(numberOfCustomers==0) {
					System.err.println("Account Number Not Found Deposit 1");
					
				}
				else {
					boolean found=false;
					for(int i=0;i<numberOfCustomers;i++) {
						Account temp=c[i].getAccount();
						String accTemp=temp.getAccountNumber();
						//System.out.println(accTemp);
						
						if(accTemp.equals(acc)) {
							System.out.println("Enter Amount to Deposit");
							double money=Double.parseDouble(reader.readLine());
							temp.deposit(money);
							found=true;
						}
					}
						
						if(found==false) {
							System.err.println("Account Number not Found Deposit 2");
						}
						
					
				}
				break;
			case 3: 
				
				
				System.out.println("Enter Account Number");
				acc=reader.readLine();
				if(numberOfCustomers==0) {
					System.err.println("Account Number Not Found Withdraw 1");
				}
				else {
					boolean found=false;
					for(int i=0;i<numberOfCustomers;i++) {
						Account temp=c[i].getAccount();
						String accTemp=temp.getAccountNumber();
						//System.out.println(accTemp);
						
						if(accTemp.equals(acc)) {
							System.out.println("Enter Amount to Withdraw");
							double money=Double.parseDouble(reader.readLine());
							temp.withdraw(money);
							found=true;
						}
					}
						
						if(found==false) {
							System.err.println("Account Number not Found Withdraw 2");
						}
						
					
				}
				break;
			case 4: 
				System.out.println("Enter Account Number");
				acc=reader.readLine();
				if(numberOfCustomers==0) {
					System.err.println("Account Number Not Found Balance 1");
				}
				else {
					boolean found=false;
					for(int i=0;i<numberOfCustomers;i++) {
						Account temp=c[i].getAccount();
						String accTemp=temp.getAccountNumber();
						//System.out.println(accTemp);
						
						if(accTemp.equals(acc)) {
							System.out.println("Balance is : "+temp.getBalance()+ " for Account Number : "+accTemp);
							
							found=true;
						}
					}
						
						if(found==false) {
							System.err.println("Account Number not Found Balance 2");
						
						
					}
				}
				
				
				break;
			case 5: 
				
				
				System.out.println("Enter Account Number");
				acc=reader.readLine();
				if(numberOfCustomers==0) {
					System.err.println("Account Number Not Found Interest 1");
				}
				else {
					boolean found=false;
					for(int i=0;i<numberOfCustomers;i++) {
						Account temp=c[i].getAccount();
						String accTemp=temp.getAccountNumber();
						//System.out.println(accTemp);
						
						if(accTemp.equals(acc)) {
							bank.calculateInterest(c[i]);
							
							found=true;
						}
					}
						
						if(found==false) {
							System.err.println("Account Number not Found Interest 2");
						}
						
					
				}
				break;
			case 6:
				System.exit(0);
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	
			
	}

}
