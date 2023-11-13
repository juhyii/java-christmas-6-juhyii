package input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import christmas.Menu;

public class ErrorValidation {
	
	public static void validateDate(String input) {
		validateDateRange(validateDateInteger(input));
	}
	
	private static void validateDateRange(int date) {
		if (date < 1 || date > 31) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_DATE.getMessage());
		}
	}
	
	private static int validateDateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_DATE.getMessage());
		}
		return Integer.parseInt(input);
	}

	public static void validateOrderFormat(String input) {
		validateCommaFormat(input);
		String[] splitInput = input.split(",");
		Arrays.stream(splitInput).forEach(ErrorValidation::validateHyphenFormat);
	}

	private static void validateCommaFormat(String input) {
		if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}

	private static void validateHyphenFormat(String splitedInput) {
		if (splitedInput.contains("--") || splitedInput.startsWith("-") || splitedInput.endsWith("-")) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}

	public static void validateMenus(List<String> menus) {
		List<String> menuNow = new ArrayList<>();
		List<String> duplication = new ArrayList<>();
		int count = 0;
		for (String m : menus) {
			menuNow = Stream.of(m.split("-")).toList();
			validateNumberRange(validateMenuInteger(menuNow.get(1)));
			count = count + Integer.parseInt(menuNow.get(1));
			if (duplication.contains(menuNow.get(0))) {
				throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
			}
			duplication.add(menuNow.get(0));
		}
		validateIsInMenu(duplication);
		validateOnlyBeverage(duplication);
		validateCount(count);
	}
	
	private static void validateOnlyBeverage(List<String> menus) {
		Set<String> type = new HashSet<String>();
		for (String m : menus) {
			Menu M = Menu.valueOf(m);
			type.add(M.type());
		}
		if (type.size()==1 && type.contains("음료")) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}
	
	private static void validateCount(int count) {
		if (count > 20) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}

	private static int validateMenuInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
		return Integer.parseInt(input);
	}

	private static void validateNumberRange(int number) {
		if (number < 1) {
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}

	private static void validateIsInMenu(List<String> menus) {
		List<String> inMenu = Stream.of(Menu.values()).map(Enum::name).collect(Collectors.toList());
		for (String m : menus) {
			if (!inMenu.contains(m)) {
				throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
			}
		}
	}
}
