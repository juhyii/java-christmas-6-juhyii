package input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import christmas.Menu;

public class ErrorValidation {

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

		for (String m : menus) {
			menuNow = Stream.of(m.split("-")).toList();
			validateNumberRange(validateInteger(menuNow.get(1)));

			if (duplication.contains(menuNow.get(0))) {
				throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
			}
			duplication.add(menuNow.get(0));
		}
		validateIsInMenu(duplication);
	}

	private static int validateInteger(String input) {
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
