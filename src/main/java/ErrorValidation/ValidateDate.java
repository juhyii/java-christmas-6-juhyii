package ErrorValidation;

public class ValidateDate {
	public static void validateDate(String input) {
		validateDateRange(validateDateInteger(input));
	}

	private static void validateDateRange(int date) {
		if (date < 1 || date > 31) {
			Notification.NOTICE_DATE_RANGE.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_DATE.getMessage());
		}
	}

	private static int validateDateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			Notification.NOTICE_DATE_INTEGER.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_DATE.getMessage());
		}
		return Integer.parseInt(input);
	}
}
