package discount;

public class EventBadge {
	private int totalDiscountAmount;

	public EventBadge(int totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

	public Badges result() {
		if (totalDiscountAmount >= Badges.산타.standard()) {
			return Badges.산타;
		}
		if (totalDiscountAmount >= Badges.트리.standard()) {
			return Badges.트리;
		}
		if (totalDiscountAmount >= Badges.별.standard()) {
			return Badges.별;
		}
		return Badges.없음;
	}
}
