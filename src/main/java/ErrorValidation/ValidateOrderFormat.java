package ErrorValidation;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidateOrderFormat {
	
	public static void validateOrderFormat(String input) {
		validateCommaFormat(input);
		String[] splitInput = input.split(",");
		Arrays.stream(splitInput).forEach(ValidateOrderFormat::validateHyphenFormat);
	}

	private static void validateCommaFormat(String input) {
		if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
			Notification.NOTICE_MENU_COMMA.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}

	private static void validateHyphenFormat(String splitedInput) {
		if (splitedInput.contains("--") || splitedInput.startsWith("-") || splitedInput.endsWith("-")) {
			Notification.NOTICE_MENU_HYPHEN.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
		validateHyphen(splitedInput);
	}

	private static void validateHyphen(String splitedInput) {
		if (!Pattern.matches("[가-힣]+-\\d+", splitedInput)) {
			Notification.NOTICE_MENU_FORMAT.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}
}
