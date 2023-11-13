package output;

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
	}

	private static void printDate() {
		System.out.println("12월 " + Integer.toString(date) + OutputMessages.NOTICE.getMessage() + "\n");
	}

}
