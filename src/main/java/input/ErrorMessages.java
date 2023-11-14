package input;

public enum ErrorMessages {
	ERROR_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
	ERROR_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");
	
	private final String message;
	
	private ErrorMessages(String message){
		this.message = message;
	}
	
	public String getMessage() {
		final String PREFIX = "[ERROR] ";
		return PREFIX + this.message;
	}
}
