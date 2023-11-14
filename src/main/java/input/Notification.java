package input;

public enum Notification {
	NOTICE_TOTAL_ORDER_AMOUNT("\n[NOTICE] 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다."),
	NOTICE_ONLY_BEVERAGE("\n[NOTICE] 음료만 주문 시, 주문할 수 없습니다."),
	NOTICE_TOO_MANY_MENU("\n[NOTICE] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
	NOTICE_NEW_YEAR_EVENT("\n[NOTICE] 그런데, 이벤트 배지는 어디에 쓰는 건가요? 궁금하다면, 1월에 진행할 새해 이벤트에서 만나요!♡");
	
	private final String message;
	
	private Notification(String message){
		this.message = message;
	}
	
	public void print() {
		System.out.println(message);
	}
}