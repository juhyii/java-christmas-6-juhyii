package output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import christmas.Menu;
import discount.Badges;
import tool.ChangeCommaFormat;

public class OutputView {
	private static int date;
	private static HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();
	private static int totalOrderAmount;
	private static boolean applyEvent;
	private static boolean giveawayEvent;
	private static int totalDiscount = 0;
	private static List<String> discountDetails = new ArrayList<String>();
	private static Badges myBadge;

	public OutputView(int date, HashMap<Menu, Integer> inputMenu, int totalOrderAmount, boolean applyEvent, boolean giveawayEvent, int totalDiscount, List<String> discountDetails ,Badges myBadge) {
		this.date = date;
		this.inputMenu = inputMenu;
		this.totalOrderAmount = totalOrderAmount;
		this.applyEvent = applyEvent;
		this.giveawayEvent = giveawayEvent;
		this.totalDiscount = totalDiscount;
		this.discountDetails = discountDetails;
		this.myBadge = myBadge;
	}

	public static void view() {
		printDate();
		printMenu();
		printTotalOrderAmount();
		printGiveawayEvent();
		printDiscountDetails();
		printTotalDiscountAmount();
		printAmountAfterDiscount();
		printEventBadge();
	}

	private static void printDate() {
		System.out.println("12월 " + Integer.toString(date) + OutputMessages.NOTICE.getMessage() + "");
	}

	private static void printMenu() {
		System.out.println(OutputMessages.MENU.getMessage());
		for (Menu menu : inputMenu.keySet()) {
			System.out.println(menu.name() + " " + inputMenu.get(menu).toString() + "개");
		}
	}

	private static void printTotalOrderAmount() {
		System.out.println(OutputMessages.TOTAL_ORDER_AMOUNT.getMessage());
		System.out.println(ChangeCommaFormat.change(totalOrderAmount) + "원");

	}

	private static void printGiveawayEvent() {
		System.out.println(OutputMessages.GIVEAWAY_MENU.getMessage());
		if (giveawayEvent) {
			System.out.println(Menu.샴페인.name()+" 1개");
			return;
		}
		System.out.println(OutputMessages.NOTHING.getMessage());
	}
	
	private static void printDiscountDetails() {
		System.out.println(OutputMessages.DISCOUNT_DETAILS.getMessage());
		if (discountDetails.size() == 0) {
			System.out.println(OutputMessages.NOTHING.getMessage());
			return;
		}
		for (String detail : discountDetails) {
			System.out.println(detail);
		}
	}
	
	private static void printTotalDiscountAmount() {
		System.out.println(OutputMessages.TOTAL_DISCOUNT_AMOUNT.getMessage());
		if (totalDiscount == 0) {
			System.out.println("0원");
			return;
		}
		System.out.println("-" + ChangeCommaFormat.change(totalDiscount) + "원");
	}
	
	private static void printAmountAfterDiscount() {
		System.out.println(OutputMessages.AMOUNT_AFTER_DISCOUNT.getMessage());
		if (giveawayEvent) {
			totalDiscount = totalDiscount - 25000;
		}
		System.out.println(ChangeCommaFormat.change(totalOrderAmount-totalDiscount) + "원");
	}
	
	private static void printEventBadge() {
		System.out.println(OutputMessages.EVENT_BADGE.getMessage());
		System.out.println(myBadge.name());
	}
		

}
