package discount;

import java.util.HashMap;
import java.util.Set;

import christmas.Menu;
import tool.ChangeCommaFormat;

public class WeekdayDiscount {
	private final Set<Integer> datesWeekday = Set.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26,
			27, 28, 31);
	private final int AMOUNT = 2023;
	private final String TYPE = "디저트";
	private int date;
	private HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();
	private int discountAmount;

	public WeekdayDiscount(int date, HashMap<Menu, Integer> inputMenu) {
		this.date = date;
		this.inputMenu = inputMenu;
	}

	private boolean isWeekday() {
		return datesWeekday.contains(date);
	}

	public int calculate() {
		if (!isWeekday()) {
			discountAmount = 0;
			return discountAmount;
		}

		int count = 0;
		for (Menu key : inputMenu.keySet()) {
			if (key.type().equals(TYPE)) {
				count = count + inputMenu.get(key);
			}
		}
		discountAmount = AMOUNT * count;
		return discountAmount;
	}
	
	public String discountDetail() {
		return "평일 할인: -" + ChangeCommaFormat.change(discountAmount) + "원";
	}
}
