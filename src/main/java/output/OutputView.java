package output;

import java.text.DecimalFormat;
import java.util.HashMap;
import christmas.Menu;

public class OutputView {
	private static int date;
	private static HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();
	private static int totalOrderAmount;
	private static boolean applyEvent;

	public OutputView(int date, HashMap<Menu, Integer> inputMenu, int totalOrderAmount, boolean applyEvent) {
		this.date = date;
		this.inputMenu = inputMenu;
		this.totalOrderAmount = totalOrderAmount;
		this.applyEvent = applyEvent;
	}

	public static void view() {
		printDate();
		printMenu();
		printTotalOrderAmount();
	}

	private static void printDate() {
		System.out.println("12월 " + Integer.toString(date) + OutputMessages.NOTICE.getMessage() + "\n");
	}

	private static void printMenu() {
		System.out.println(OutputMessages.MENU.getMessage());
		for (Menu menu : inputMenu.keySet()) {
			System.out.println(menu.name() + " " + inputMenu.get(menu).toString() + "개\n");
		}
	}

	private static String changeCommaFormat(int number) {
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(number);
	}

	private static void printTotalOrderAmount() {
		System.out.println(OutputMessages.TOTAL_ORDER_AMOUNT.getMessage());
		System.out.println(changeCommaFormat(totalOrderAmount) + "원");

	}

}
