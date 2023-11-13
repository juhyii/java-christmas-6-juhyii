package output;

public enum OutputMessages {
	NOTICE("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
	MENU("<주문 메뉴>"),
	TOTAL_ORDER_AMOUNT("<할인 전 총주문 금액>"),
	GIVEAWAY_MENU("<증정 메뉴>"),
	DISCOUNT_DETAILS("<혜택 내역>"),
	TOTAL_DISCOUNT_AMOUNT("<총혜택 금액>"),
	AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
	EVENT_BADGE("<12월 이벤트 배지>");
	
	private String message;
	
	OutputMessages(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
