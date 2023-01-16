import java.util.Scanner;
class BankApplication{
	String name;
	int id;
	int balance;
	int previoustransaction;
	static int option;
	
	BankApplication(String NAME, int ID){
		name=NAME;
		id=ID;
		System.out.println("Welcome "+name+"!"+"\n");
	}
	
	public static void clearconsole(){
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}
		catch (final Exception e) {
			e.printStackTrace();// Handle any exceptions.
		}
	}
					
	
	void CheckBalance(){
		System.out.println("Balance = "+balance);
	}
	
	void Deposit(int Amount){
		Scanner input=new Scanner(System.in);
		if(Amount!=0){
			balance=balance+Amount;
			previoustransaction=Amount;
			System.out.print("Deposit has been Successfull." );
			char op;
			do{
			System.out.print("Do you want to Deposit another amount? (Y/N): ");
			op=input.next().charAt(0);
			switch(op){
				case 'Y':{
					clearconsole();
					depositloop();
					break;
				}
				case 'y':{
					clearconsole();
					depositloop();
					break;
				}
				case 'N':{
					break;
				}
				case 'n':{
					break;
				}
				default:{
					System.out.println("Invalid input. Please try again");
				}
			}
		}while(op!='Y'& op!='y'& op!='N'& op!='n');
		}
	}
	
	void Withdraw(int Amount){
		Scanner input=new Scanner(System.in);
		if(Amount!=0){
			balance=balance-Amount;
			previoustransaction=-Amount;
			System.out.print("Withdraw has been Successfull." );
			char op;
			do{
			System.out.print("Do you want to Withdraw another amount? (Y/N): ");
			op=input.next().charAt(0);
			switch(op){
				case 'Y':{
					clearconsole();
					withdrawloop();
					break;
				}
				case 'y':{
					clearconsole();
					withdrawloop();
					break;
				}
				case 'N':{
					break;
				}
				case 'n':{
					break;
				}
				default:{
					System.out.println("Invalid input. Please try again");
				}
			}
		}while(op!='Y'& op!='y'& op!='N'& op!='n');
		}
	}
	
	void PreviousTransaction(){
		if(previoustransaction>0){
			System.out.println("Previous Transaction = Deposit "+previoustransaction);
			Loop();
		}
		else if(previoustransaction<0){
			System.out.println("Previous Transaction = Withdraw "+Math.abs(previoustransaction));
			Loop();
		}
		else{
			System.out.println("No Previous Transactions");
			Loop();
		}
	}
	
	void depositloop(){
		Scanner input=new Scanner(System.in);
		System.out.println("=======================");
		System.out.println("       Deposit");
		System.out.println("=======================");
		System.out.print("Enter the Amount: ");
		int amount=input.nextInt();
		Deposit(amount);
	}
	
	void withdrawloop(){
		Scanner Input=new Scanner(System.in);
		System.out.println("=======================");
		System.out.println("       Withdraw");
		System.out.println("=======================");
		System.out.print("Enter the Amount: ");
		int amount=Input.nextInt();
		if(amount<balance){
			Withdraw(amount);
		}
		else{
			System.out.println("You have no sufficient balance to withdraw");
			Loop();
		}
	}
	
	void Loop(){
		Scanner input=new Scanner(System.in);
		System.out.print("do you want to exit?(Y/N): ");
		char op=input.next().charAt(0);
		switch(op){
			case 'Y':{
				option=5;
				clearconsole();
				break;
			}
			case 'y':{
				option=5;
			    clearconsole();
			    break;
			}
			case 'N':{
				clearconsole();
				break;
			}
			case 'n':{
				clearconsole();
				break;
			}
			default:{
				System.out.println("Invalid input. Please try again");
				Loop();
			}
		}
	}
	
	void Exit(){
		System.out.println("*************************************************");
		System.out.println("Thank you for using our service. Have a nice Day!");
	}

	void Menu(){
		do{
			System.out.println("1. Check Balance");
		    System.out.println("2. Deposit");
		    System.out.println("3. Withdraw");
		    System.out.println("4. Previous Transaction");
		    System.out.println("5. Exit\n");
			Scanner Input=new Scanner(System.in);
			System.out.print("Enter the option: ");
			option=Input.nextInt();
			clearconsole();
			
			switch(option){
				case 1:{
					System.out.println("=======================");
					System.out.println("    Check Balance");
					System.out.println("=======================");
					CheckBalance();
					Loop();
					break;	
				}
				case 2:{
					depositloop();
					clearconsole();
					break;
				}
				case 3:{
					withdrawloop();
					clearconsole();
					break;
				}
				case 4:{
					System.out.println("=======================");
					System.out.println(" Previous Transaction");
					System.out.println("=======================");
					PreviousTransaction();
					clearconsole();
					break;
				}
				case 5:{
					clearconsole();
					break;
				}
				default:{
					System.out.println("Invalid Input. Please try again");
				}
			}
		}while(option!=5);
		Exit();
	}
}				


class BankApp{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name=input.next();
		System.out.print("Enter your id: ");
		int id=input.nextInt();
		BankApplication.clearconsole();
		BankApplication object=new BankApplication(name,id);
		object.Menu();
	}
}
