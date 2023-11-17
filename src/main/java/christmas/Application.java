package christmas;

import java.util.HashMap;
import java.util.List;

import discount.Badges;
import domain.ApplyDiscounts;
import domain.Menu;
import input.InputView;
import output.OutputView;

public class Application {
	private static int date;
	private static HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();

	public static void main(String[] args) {
		InputView input = new InputView();
		date = input.getdate();
		inputMenu = input.getInputMenu();

		ApplyDiscounts discounts = new ApplyDiscounts(date, inputMenu);
		discounts.applyOrNot();
		int totalOrderAmount = discounts.totalOrderAmount;
		int totalDiscount = discounts.totalDiscount;
		List<String> discountDetails = discounts.discountDetails;
		boolean giveawayEvent = discounts.giveawayEvent;
		Badges myBadge = discounts.myBadge;

		OutputView output = new OutputView(date, inputMenu, totalOrderAmount, giveawayEvent, totalDiscount, discountDetails, myBadge);
		output.view();
	}
}