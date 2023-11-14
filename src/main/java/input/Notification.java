package input;

public enum Notification {
	NOTICE_TOTAL_ORDER_AMOUNT("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다."),
	NOTICE_ONLY_BEVERAGE("음료만 주문 시, 주문할 수 없습니다."),
	NOTICE_TOO_MANY_MENU("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
	NOTICE_DATE_RANGE("날짜는 1-31의 숫자여야 합니다."),
	NOTICE_DATE_INTEGER("날짜는 숫자여야 합니다."),
	NOTICE_MENU_COMMA("잘못된 위치에 ,가 존재합니다."),
	NOTICE_MENU_HYPHEN("잘못된 위치에 -가 존재합니다."),
	NOTICE_MENU_FORMAT("메뉴이름-개수 형태로 입력해 주세요."),
	NOTICE_MENU_DUPLICATION("중복된 입력값이 존재합니다."),
	NOTICE_MENU_INTEGER("메뉴의 개수는 숫자여야 합니다."),
	NOTICE_MENU_ONE("메뉴의 개수는 1 이상이어야 합니다."),
	NOTICE_MENU_IS("입력하신 메뉴가 존재하지 않습니다."),
	NOTICE_NEW_YEAR_EVENT("그런데, 이벤트 배지는 어디에 쓰는 건가요? 궁금하다면, 1월에 진행할 새해 이벤트에서 만나요!♡");
	
	private final String message;
	
	private Notification(String message){
		this.message = message;
	}
	
	public void print() {
		final String PREFIX = "\n[NOTICE] ";
		System.out.println(PREFIX + message);
	}
}