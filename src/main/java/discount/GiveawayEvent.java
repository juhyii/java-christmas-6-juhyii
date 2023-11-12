package discount;

public class GiveawayEvent {
	private int totalAmount;
	private int STANDARD = 120000;
	private int AMOUNT = 25000;

	public GiveawayEvent(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	private boolean isGiveaway() {
		if(totalAmount < STANDARD) {
			return false;
		}
		return true;
	}

	public int calculate() {
		if(isGiveaway()) {
			return AMOUNT;
		}
		return 0;
	}
}
