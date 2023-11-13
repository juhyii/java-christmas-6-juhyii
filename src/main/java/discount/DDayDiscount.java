package discount;

import java.util.HashMap;

import tool.ChangeCommaFormat;

public class DDayDiscount {
	private HashMap<Integer, Integer> discountCalendar = new HashMap<Integer, Integer>();
	private int discountAmount = 0;

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
			discountAmount = 0;
			return 0;
		}
		discountAmount = discountCalendar.get(date);
		return discountAmount;
	}
	
	public String discountDetail() {
		return "크리스마스 디데이 할인: -" + ChangeCommaFormat.change(discountAmount) + "원";
	}
}
