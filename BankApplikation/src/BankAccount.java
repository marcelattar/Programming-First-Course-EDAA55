
public class BankAccount {
	//private String holderName;
	//private long holderId;
	private double holderMoney;
	private Customer holder;
	
	private static int count = 1001;
	private int accountNr;
	
	
		/**
		 * Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
		 * id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
		 * inledningsvis 0 kr.
		*/	
		public BankAccount(String holderName, long holderId) {
			holder = new Customer(holderName, holderId);
			//this.holderName = holderName;
			//this.holderId = holderId;
			holderMoney = 0;
			accountNr = count;
			count++;
		}
		/**
		* Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
		* ett unikt kontonummer och innehåller inledningsvis 0 kr.
		*/
		public BankAccount(Customer holder) {
			this.holder = holder;
			accountNr = count;
			count++;
			holderMoney = 0;
		}
		
		/** Tar reda på kontots innehavare. */
		public Customer getHolder() {
			return holder;
		}
		
		/** Tar reda på det kontonummer som identifierar detta konto. */
		public int getAccountNumber() {
			return accountNr;
		}	
		
		/** Tar reda på hur mycket pengar som finns på kontot. */
		public double getAmount() {
			return holderMoney;
		}
		
		/** Sätter in beloppet ’amount’ på kontot. */
		public void deposit(double amount) {
			holderMoney = holderMoney + amount;
		}
		
		/**
		* Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning
		* blir saldot negativt.
		*/
		public void withdraw(double amount) {
			holderMoney = holderMoney - amount;
		}
		
		/** Returnerar en strängrepresentation av bankkontot. */
		public String toString() {
			return "Konto " + accountNr;
		}	
	}


