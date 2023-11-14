package discount;

import java.util.Set;

import tool.ChangeCommaFormat;

public class SpecialDiscount {
	private final Set<Integer> datesStar = Set.of(3, 10, 17, 24, 25, 31);
	private final int AMOUNT = 1000;
	private final int date;
	private int discountAmount;

	public SpecialDiscount(int date) {
		this.date = date;
	}
	
	private boolean isSpecial() {
		return datesStar.contains(date);
	}

	public int calculate() {
		if(isSpecial()) {
			discountAmount = AMOUNT;
			return discountAmount;
		}
		discountAmount = 0;
		return discountAmount;
	}
	
	public String discountDetail() {
		return "특별 할인: -" + ChangeCommaFormat.change(discountAmount) + "원";
	}
}
