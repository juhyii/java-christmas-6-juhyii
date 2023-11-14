package discount;

import tool.ChangeCommaFormat;

public class GiveawayEvent {
	private final int totalAmount;
	private final int STANDARD = 120000;
	private final int AMOUNT = 25000;
	private int discountAmount;

	public GiveawayEvent(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	private boolean isGiveaway() {
		if (totalAmount < STANDARD) {
			return false;
		}
		return true;
	}

	public int calculate() {
		if (isGiveaway()) {
			discountAmount = AMOUNT;
			return discountAmount;
		}
		discountAmount = 0;
		return discountAmount;
	}

	public String discountDetail() {
		return "증정 이벤트: -" + ChangeCommaFormat.change(discountAmount) + "원";
	}
}
