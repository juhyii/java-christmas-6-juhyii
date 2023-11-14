package discount;

public enum Badges {
	없음(0),
	별(5000),
	트리(10000),
	산타(20000);
	
	private final int standard;

	Badges(int standard) {
		this.standard = standard;
	}

	public int standard() {
		return this.standard;
	}
}