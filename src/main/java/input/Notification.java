package input;

public enum Notification {
	NOTICE_TOTAL_ORDER_AMOUNT("[NOTICE] 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다."),
	NOTICE_ONLY_BEVERAGE("[NOTICE] 음료만 주문 시, 주문할 수 없습니다."),
	NOTICE_TOO_MANY_MENU("[NOTICE] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
	
	private final String message;
	
	Notification(String message){
		this.message = message;
	}
	
	public void print() {
		System.out.println(message);
	}
}
