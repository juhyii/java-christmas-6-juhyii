package discount;

import java.util.HashMap;
import java.util.Set;

import christmas.Menu;
import tool.ChangeCommaFormat;

public class WeekendDiscount {
	private final Set<Integer> datesWeekend = Set.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
	private final int AMOUNT = 2023;
	private final String TYPE = "메인";
	private final int date;
	private HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();
	private int discountAmount;

	public WeekendDiscount(int date, HashMap<Menu, Integer> inputMenu) {
		this.date = date;
		this.inputMenu = inputMenu;
	}

	private boolean isWeekend() {
		return datesWeekend.contains(date);
	}

	public int calculate() {
		if (!isWeekend()) {
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
		return "주말 할인: -" + ChangeCommaFormat.change(discountAmount) + "원";
	}
}
