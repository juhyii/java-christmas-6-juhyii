package ErrorValidation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Menu;

public class ValidateMenuFormat {
	
	public static void validateMenus(List<String> menus) {
		List<String> menuNow = new ArrayList<>();
		List<String> duplication = new ArrayList<>();
		int count = 0;
		for (String m : menus) {
			menuNow = Stream.of(m.split("-")).toList();
			validateNumberRange(validateMenuInteger(menuNow.get(1)));
			count = count + Integer.parseInt(menuNow.get(1));
			if (duplication.contains(menuNow.get(0))) {
				Notification.NOTICE_MENU_DUPLICATION.print();
				throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
			}
			duplication.add(menuNow.get(0));
		}
		validateCount(count);
		validateIsInMenu(duplication);
		validateOnlyBeverage(duplication);
	}
	
	private static int validateMenuInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			Notification.NOTICE_MENU_INTEGER.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
		return Integer.parseInt(input);
	}
	
	private static void validateNumberRange(int number) {
		if (number < 1) {
			Notification.NOTICE_MENU_ONE.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}
	
	private static void validateCount(int count) {
		if (count > 20) {
			Notification.NOTICE_TOO_MANY_MENU.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}
	
	private static void validateIsInMenu(List<String> menus) {
		List<String> inMenu = Stream.of(Menu.values()).map(Enum::name).collect(Collectors.toList());
		for (String m : menus) {
			if (!inMenu.contains(m)) {
				Notification.NOTICE_MENU_IS.print();
				throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
			}
		}
	}

	private static void validateOnlyBeverage(List<String> menus) {
		Set<String> type = new HashSet<String>();
		for (String m : menus) {
			Menu M = Menu.valueOf(m);
			type.add(M.type());
		}
		if (type.size() == 1 && type.contains("음료")) {
			Notification.NOTICE_ONLY_BEVERAGE.print();
			throw new IllegalArgumentException(ErrorMessages.ERROR_ORDER.getMessage());
		}
	}
}
