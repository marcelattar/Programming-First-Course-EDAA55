import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	Scanner scan = new Scanner(System.in);

	public void runApplication() {
		boolean check = true;
		Bank bank = new Bank();

		while (check) {
			Menu();
			System.out.println("val: ");
			int val = scan.nextInt();
			if (val == 6) {
				System.out.println("namn: ");
				scan.nextLine();
				String namn = scan.nextLine();
				System.out.println("id: ");
				long id = scan.nextLong();
				System.out
						.println("konto skapat: " + bank.addAccount(namn, id));
				System.out
						.println("---------------------------------------------------------------------");
			}
			if (val == 8) {
				ArrayList<BankAccount> altbank; // = new ArrayList<BankAccount>();
				altbank = bank.getAllAccounts();
				for (int i = 0; i < altbank.size(); i++) {
					BankAccount hej = altbank.get(i);
					System.out.println(hej.toString() + " ("
							+ hej.getHolder().toString() + ") : "
							+ hej.getAmount() + "kr");
				}
				System.out
						.println("---------------------------------------------------------------------");
			}
			if (val == 2) {
				System.out.println("namn: ");
				scan.nextLine();
				String namn = scan.nextLine();
				ArrayList<Customer> delnamn = bank.findByPartofName(namn);
				for (int i = 0; i < delnamn.size(); i++) {
					System.out.println(delnamn.get(i).toString());
				}
				System.out
						.println("---------------------------------------------------------------------");
			}
			if (val == 1) {
				System.out.println("id: ");
				long id = scan.nextLong();
				ArrayList<BankAccount> lista = bank.findAccountsForHolder(id);
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString() + " ("
							+ lista.get(i).getHolder().toString() + ") : "
							+ lista.get(i).getAmount() + " kr");
				}
				System.out
						.println("---------------------------------------------------------------------");
			}
			if (val == 9) {
				check = false;
			}
			if (val == 7) {
				System.out.println("konto: ");
				int konto = scan.nextInt();
				if (bank.removeAccount(konto)) {
					System.out
							.println("---------------------------------------------------------------------");
				} else {
					System.out.println("felaktigt kontonummer!");
					System.out
							.println("---------------------------------------------------------------------");
				}
			}
			if (val == 3) {
				System.out.println("konto: ");
				int konto = scan.nextInt();
				System.out.println("belopp: ");
				double belopp = scan.nextDouble();
				BankAccount bankkonto = bank.findByNumber(konto);
				if (bankkonto == null) {
					System.out.println("felaktigt kontonummer!");
				} else {
					bankkonto.deposit(belopp);
					System.out.println(bankkonto.toString() + " ("
							+ bankkonto.getHolder().toString() + "): "
							+ bankkonto.getAmount() + "kr");
				}
				System.out
						.println("---------------------------------------------------------------------");
			}
			if (val == 4) {
				System.out.println("från konto: ");
				int konto = scan.nextInt();
				System.out.println("belopp: ");
				double belopp = scan.nextDouble();
				BankAccount bankkonto = bank.findByNumber(konto);
				if (bankkonto == null) {
					System.out.println("felaktigt kontonummer!");
				} else if (bankkonto.getAmount() >= belopp) {
					bankkonto.withdraw(belopp);
					System.out.println(bankkonto.toString() + " ("
							+ bankkonto.getHolder().toString() + "): "
							+ bankkonto.getAmount() + "kr");
				} else {
					System.out.println("uttaget misslyckades, endast "
							+ bankkonto.getAmount() + "kr på kontot!");
				}
				System.out
						.println("---------------------------------------------------------------------");

			}
			if (val == 5) {
				System.out.println("från konto: ");
				int expkonto = scan.nextInt();
				System.out.println("till konto: ");
				int impkonto = scan.nextInt();
				System.out.println("belopp: ");
				double belopp = scan.nextDouble();
				BankAccount bankkonto1 = bank.findByNumber(expkonto);
				BankAccount bankkonto2 = bank.findByNumber(impkonto);
				if (bankkonto1 == null || bankkonto2 == null) {
					System.out.println("felaktigt kontonummer!");
				} else if (bankkonto1.getAmount() >= belopp) {
					bankkonto1.withdraw(belopp);
					bankkonto2.deposit(belopp);
					System.out.println(bankkonto1.toString() + " ("
							+ bankkonto1.getHolder().toString() + "): "
							+ bankkonto1.getAmount() + "kr");
					System.out.println(bankkonto2.toString() + " ("
							+ bankkonto2.getHolder().toString() + "): "
							+ bankkonto2.getAmount() + "kr");
				} else {
					System.out.println("uttaget misslyckades, endast "
							+ bankkonto1.getAmount() + "kr på kontot!");
				}
				System.out
						.println("---------------------------------------------------------------------");
			}
		}
		System.out.println("Tack för besöket och välkommen åter.");
	}

	public void Menu() {
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätta in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");

	}

	public static void main(String[] args) {
		BankApplication bank = new BankApplication();
		bank.runApplication();
	}

}
