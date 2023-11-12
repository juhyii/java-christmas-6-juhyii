package discount;

import java.util.HashMap;

public class DDayDiscount {
	private HashMap<Integer, Integer> discountCalendar = new HashMap<Integer, Integer>();

	public DDayDiscount() {
		generateCalendar();
	}

	private void generateCalendar() {
		int amount = 1000;
		for (int i = 1; i <= 25; i++) {
			discountCalendar.put(i, amount);
			amount = amount + 100;
		}
	}

	public int calculate(int date) {
		if (date > 25) {
			return 0;
		}
		return discountCalendar.get(date);
	}
}
