package christmas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import discount.Badges;
import discount.DDayDiscount;
import discount.EventBadge;
import discount.GiveawayEvent;
import discount.SpecialDiscount;
import discount.WeekdayDiscount;
import discount.WeekendDiscount;

public class ApplyDiscounts {
	private static int date;
	private static HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();
	private static int totalOrderAmount;

	public static boolean giveawayEvent = false;
	public static int totalDiscount = 0;
	public static List<String> discountDetails = new ArrayList<String>();
	public static Badges myBadge = Badges.없음;

	public ApplyDiscounts(int date, HashMap<Menu, Integer> inputMenu, int totalOrderAmount) {
		this.date = date;
		this.inputMenu = inputMenu;
		this.totalOrderAmount = totalOrderAmount;
	}

	public static void apply() {
		applyDDayDiscount();
		applyWeekdayDiscount();
		applyWeekendDiscount();
		applySpecialDiscount();
		applyGiveawayEvent();
		applyEventBadge();
	}

	private static void applyDDayDiscount() {
		DDayDiscount dDay = new DDayDiscount();
		int result = dDay.calculate(date);
		if (result != 0) {
			totalDiscount = totalDiscount + result;
			discountDetails.add(dDay.discountDetail());
		}
	}

	private static void applyWeekdayDiscount() {
		WeekdayDiscount weekDay = new WeekdayDiscount(date, inputMenu);
		int result = weekDay.calculate();
		if (result != 0) {
			totalDiscount = totalDiscount + result;
			discountDetails.add(weekDay.discountDetail());
		}
	}

	private static void applyWeekendDiscount() {
		WeekendDiscount weekEnd = new WeekendDiscount(date, inputMenu);
		int result = weekEnd.calculate();
		if (result != 0) {
			totalDiscount = totalDiscount + result;
			discountDetails.add(weekEnd.discountDetail());
		}
	}

	private static void applySpecialDiscount() {
		SpecialDiscount special = new SpecialDiscount(date);
		int result = special.calculate();
		if (result != 0) {
			totalDiscount = totalDiscount + result;
			discountDetails.add(special.discountDetail());
		}
	}

	private static void applyGiveawayEvent() {
		GiveawayEvent giveaway = new GiveawayEvent(totalOrderAmount);
		int result = giveaway.calculate();
		if (result != 0) {
			totalDiscount = totalDiscount + result;
			discountDetails.add(giveaway.discountDetail());
			giveawayEvent = true;
		}
	}

	private static void applyEventBadge() {
		EventBadge badge = new EventBadge(totalDiscount);
		myBadge = badge.result();
	}

}
