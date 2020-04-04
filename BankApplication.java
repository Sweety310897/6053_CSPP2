import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

interface AccountOperations {
	public void deposit();
	public void withdrawal();
}

class Account {
	String[] acc_types = {"Savings", "Current", "Fixed", "DEMAT"};
	private final int account_number;
	private final String customer_name;
	private String account_type;
	private long account_balance;
	private final String socialSecurityNumber;

	Account(int account_number, String cust_name, int acc_type, String ssn) {
		this.account_number = account_number;
		this.customer_name = cust_name;
		this.account_type = acc_types[acc_type];
		this.account_balance = 0;
		this.socialSecurityNumber = ssn;
	}

	public int getAccountNumber() {
		return this.account_number;
	}

	public String getCustomerName() {
		return this.customer_name;
	}

	public String getAccountType() {
		return this.account_type;
	}

	public long getAccountBalance() {
		return this.account_balance;
	}

	public void setAccountType(int type) {
		this.account_type = acc_types[type];
	}

	public void updateAccountBalance(long amount) {
		this.account_balance = amount;
	}

	public String getSSN() {
		return this.socialSecurityNumber;
	}
}

class BankAccount extends Account implements AccountOperations {
	private String cust_phone_no;
	private String cust_email_id;
	Scanner scan2 = new Scanner(System.in);
	// BankAccount(){}
	BankAccount(int acc_number, String cust_name, int acc_type, String cust_phone_no, String cust_emailId, String ssn) {
		super(acc_number, cust_name, acc_type, ssn);
		this.cust_phone_no = cust_phone_no;
		this.cust_email_id = cust_emailId;
	}

	public String getCustEmail() {
		return this.cust_email_id;
	}

	public String getCustPhone() {
		return this.cust_phone_no;
	}

	public void deposit() {
	try {
		long amount;
		System.out.println("Enter the amount you want to Deposit : ");
		amount = scan2.nextLong();
		if(amount > 0 ) {
			updateAccountBalance(getAccountBalance() + amount);
			System.out.println("Amount deposited successfully");
		} else {
			throw new MyException("You cannot deposit as the number entered by you is less than 0");
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void withdrawal() {
		try {
		long amount;
		System.out.println("Enter the amount you want to withdraw : ");
		amount = scan2.nextLong();
		if(amount < getAccountBalance() ) {
			updateAccountBalance(getAccountBalance() - amount);
			System.out.println("Remaining Balance is " + getAccountBalance());
		}else {
			throw new MyException("Balance is less. U caanot withdraw");
		}
		}
		catch(Exception e) {
			// System.out.println("im exception");
			System.out.println(e.getMessage());
		}
	}


	public String toString() {
		String details = "Name: " + getCustomerName() + "\n" + "Account Number: " + getAccountNumber() + "\n" + "Account Type: " + getAccountType() + "\n" + "Available Balance: " + getAccountBalance() + "\n" + "Mobile Number: " + getCustPhone() + "\n" + "Email id: " + getCustEmail() + "\n";
		return details;
	}

	boolean search(int acn)
	{ 
		if(getAccountNumber() == acn)
		{ 
			System.out.println(this);
			return(true);
		}
		return(false);
	}
}

class MyException extends Exception {
	public MyException(String s) {
		super(s);
	}
}
class Bank
{
	private HashMap<Integer,BankAccount> accountsList = new HashMap<>();
	private HashMap<String, Integer> ssnAccmap = new HashMap<>();
	Bank() {}

	public void createNewAccount(BankAccount account) {
		accountsList.put(account.getAccountNumber(), account);
		ssnAccmap.put(account.getSSN(), account.getAccountNumber());
	}

	public BankAccount getAccount(int accNumber) {
		return accountsList.get(accNumber);
	}

	public int getAccWithSSN(String ssn) {
		return this.ssnAccmap.get(ssn);
	}

	public HashMap<Integer,BankAccount> getAccountList() {
		return this.accountsList;
	}

	public HashMap<String, Integer> getSSNACC() {
		return this.ssnAccmap;
	}
}

class Solution3 implements BankApplication
{  
	static int global_account_number = 1000;
	public static boolean check_name(String name) {
		// System.out.println("Hello");
		try {
			if (name == null) {
				throw new MyException("Name is not entered");
			}
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		 

		try {
			if(name.matches("[a-zA-Z]+")) {
				return true;
			} else {
				throw new MyException("Check your entered name"); 
			}
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
	}

	public static boolean check_phnum(String phnum) {
		try {
			if (phnum == null) {
				throw new MyException("Phone number is not entered");
			}
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		 
		String[] num = phnum.split("");
		try {
			if(phnum.matches("[0-9]+")) {
				if(num[0].matches("[7-9]")) {
					if(num.length == 10) {
						return true;
					} else {
						throw new MyException("Phone number should contain 10 digits");
					}
					
				} else {
					throw new MyException("Phone number should start with either 9, 8 or 7");
				}
				
			} else {
				throw new MyException("Check your entered Phone number"); 
			}
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public static boolean check_email(String email) {
		try {
			if (email == null) {
				throw new MyException("Email is not entered");
			}
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		 
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
		try {
			if(pat.matcher(email).matches()) {
				return true;
			} else {
				throw new MyException("Check your entered email"); 
			}
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public void readinput()
	{
		Scanner scan=new Scanner(System.in);
		Bank shivaniBank = new Bank();
		int choice;
		do
		{
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Main Menu\n 1.Add Account\n 2.Display All\n 3.Search By Account\n 4.Deposit\n 5.Withdrawal\n 6.Exit");
			choice = scan.nextInt();
			System.out.println("-----------------------------------------------------------------------------------");
			switch(choice)
			{ 
				case 1:
					System.out.print("Enter Name: ");
					String customer_name = scan.next();
					while(true) {
						if(check_name(customer_name)) {
							break;
						} else {
							System.out.print("Enter Name: ");
							customer_name = scan.next();
						}
					}

					System.out.println("Select Account Type: \n 1 for Savings \n 2 for Current \n 3 for FD \n 4 for DEMAT");
					int acc_type = Integer.parseInt(scan.next());

					System.out.println("Enter your Social Security Number");
					String ssn = scan.next();

					System.out.print("Enter Phone Number: ");
					String customer_phoneno = scan.next();
					
					while(true) {
						if(check_phnum(customer_phoneno)) {
							break;
						} else {
							System.out.print("Enter Phone Number: ");
							customer_phoneno = scan.next();
						}
					}

					System.out.print("Customer Email Id: ");
					String customer_email_id = scan.next();

					while(true) {
						if(check_email(customer_email_id)) {
							break;
						} else {
							System.out.print("Customer Email Id: ");
							customer_email_id = scan.next();
						}
					}
					
					
					if(shivaniBank.getSSNACC().containsKey(ssn)) {
						System.out.println("Account already exists with account number: " + shivaniBank.getAccWithSSN(ssn));
					} else {

						shivaniBank.createNewAccount(new BankAccount(Solution3.global_account_number++, customer_name, acc_type, customer_phoneno, customer_email_id, ssn));
						System.out.println(" -> Account created with account number: " + (global_account_number-1));
					}
					// }
				case 2:

					shivaniBank.getAccountList().forEach((k, v) -> System.out.println(v));
					break;

				case 3:
					System.out.print("Enter the account number you want to search: ");
					int acn = scan.nextInt();
					boolean found = false;
					if(shivaniBank.getAccountList().containsKey(acn)) {
						System.out.println(shivaniBank.getAccount(acn));
					} else {
						System.out.println("Search failed Account dooesn't exist..");
					}
					break;

				case 4:
					System.out.print("Enter Account No : ");
					acn = scan.nextInt();
					found = false;
					if(shivaniBank.getAccountList().containsKey(acn)) {
						shivaniBank.getAccount(acn).deposit();
					} else {
						System.out.println("Search Failed..Account Not Exist..");
					}
					break;

				case 5:
					System.out.print("Enter Account No : ");
					acn = scan.nextInt();
					found = false;
					if(shivaniBank.getAccountList().containsKey(acn)) {
						shivaniBank.getAccount(acn).withdrawal();
					} else {
						System.out.println("Search Failed..Account Not Exist..");
					}
					break;

				case 6:
					System.out.println("Good Bye... Application has ended");
					break;
			}
		}
		while(choice != 6);
	}
}
interface BankApplication {
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		s.readinput();
	}
}

