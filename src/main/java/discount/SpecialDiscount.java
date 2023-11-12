package discount;

import java.util.Set;

public class SpecialDiscount {
	private final Set<Integer> datesStar = Set.of(3, 10, 17, 24, 25, 31);
	private final int AMOUNT = 1000;
	private int date;

	public SpecialDiscount(int date) {
		this.date = date;
	}
	
	private boolean isSpecial() {
		return datesStar.contains(date);
	}

	public int calculate() {
		if(isSpecial()) {
			return AMOUNT;
		}
		return 0;
	}
}
