import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> allAccounts;

	public Bank() {
		allAccounts = new ArrayList<BankAccount>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med
	 * de givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		if (contains(idNr)) {
			BankAccount konto = new BankAccount(holderName, idNr);
			allAccounts.add(konto);
			return konto.getAccountNumber();
		} else {
			Customer kund = new Customer(holderName, idNr);
			BankAccount konto = new BankAccount(kund);
			allAccounts.add(konto);
			return konto.getAccountNumber();
		}
	}

	/** Metod för att se om det redan finns en kund i banken. */
	private boolean contains(long idNr) {
		/** Returnerar true om iD-nummrena matchar, annars false. */
		boolean bol = false;
		for (int i = 0; i < allAccounts.size(); i++) {
			long iDnummer = allAccounts.get(i).getHolder().getIdNr();
			if (iDnummer == idNr) {
				bol = true;
			}
		}
		return bol;
	}
	
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen sådan finns.
	*/
	public Customer findHolder(long idNr) {
		Customer kund = null;
		boolean test = true;
		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getHolder().getIdNr() == idNr) {
				kund = allAccounts.get(i).getHolder();
				test = false;
			}
		} if (test) {
			return null;
		} else {
			return kund;
		}
	}
	
	
	/**
	* Tar bort konto med nummer ’number’ från banken. Returnerar true om
	* kontot fanns (och kunde tas bort), annars false.
	*/
	public boolean removeAccount(int number) {
		boolean test = false;
		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getAccountNumber() == number) {
				allAccounts.remove(i);
				test = true;
			}
		}
		return test;
	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn. OBS: Den returnerade listan ska inte
	 * vara en referens direkt till något av Bank-klassens attribut (eftersom
	 * listan då skulle kunna manipuleras utifrån, men för denna uppgiften
	 * behöver inte objekten kopieras).
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		ArrayList<BankAccount> altlista = new ArrayList<BankAccount>();
		for (int i = 0; i < allAccounts.size(); i++) {
			int pos = 0;
			BankAccount altkonto = allAccounts.get(i);
			String namn = altkonto.getHolder().getName();
			while (pos < altlista.size() && altlista.get(pos).getHolder().getName().toLowerCase().compareTo(namn.toLowerCase()) < 0) {
				pos++;
			}
			altlista.add(pos, altkonto);
		}
		return altlista;

	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	 * Returnerar null om inget sådant konto finns.
	 */
	public BankAccount findByNumber(int accountNumber) {
		boolean test = true;
		BankAccount konto = null;
		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getAccountNumber() == accountNumber) {
				konto = allAccounts.get(i);
				test = false;
			}
		}
		if (test) {
			return null;
		} else {
			return konto; 
		}
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’.
	 * Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> altlista = new ArrayList<BankAccount>();
		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getHolder().getIdNr() == idNr) {
				altlista.add(allAccounts.get(i));
			}
		}
		return altlista;
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
	 * personer vars namn innehåller strängen ’namePart’ inkluderas i
	 * resultatet, som returneras som en lista. Samma person kan förekomma flera
	 * gånger i resultatet. Sökningen är "case insensitive", det vill säga gör
	 * ingen skillnad på stora och små bokstäver.
	 */
	public ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> altlista = new ArrayList<Customer>();
		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
				altlista.add(allAccounts.get(i).getHolder());
			}
		}
		return altlista;
	}

}
