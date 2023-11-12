package discount;

import java.util.HashMap;
import java.util.Set;

import christmas.Menu;

public class WeekendDiscount {
	private final Set<Integer> datesWeekend = Set.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
	private final int AMOUNT = 2023;
	private final String TYPE = "메인";
	private int date;
	private HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();

	public WeekendDiscount(int date, HashMap<Menu, Integer> inputMenu) {
		this.date = date;
		this.inputMenu = inputMenu;
	}

	private boolean isWeekday() {
		return datesWeekend.contains(date);
	}

	public int calculate() {
		if (!isWeekday()) {
			return 0;
		}

		int count = 0;
		for (Menu key : inputMenu.keySet()) {
			if (key.type().equals(TYPE)) {
				count = count + inputMenu.get(key);
			}
		}
		return AMOUNT * count;
	}
}
