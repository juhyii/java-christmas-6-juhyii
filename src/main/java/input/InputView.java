package input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import christmas.Menu;

public class InputView {
	private final int date;
	private final HashMap<Menu, Integer> inputMenu = new HashMap<Menu, Integer>();

	public InputView() {
		InputMessages.HELLO.print();
		date = readDate();
		List<String> menu = readMenu();
		toMenu(menu);
	}

	public static int readDate() {
		InputMessages.QUESTION_DATE.print();
		String input = Console.readLine();
		try {
			ErrorValidation.validateDate(input);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readDate();
		}
	}

	public static List<String> readMenu() {
		InputMessages.QUESTION_MENU.print();
		String input = Console.readLine();
		try {
			ErrorValidation.validateOrderFormat(input);
			List<String> menus = new ArrayList<>();
			menus = Stream.of(input.split(",")).toList();
			ErrorValidation.validateMenus(menus);
			return menus;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readMenu();
		}
	}

	private void toMenu(List<String> menu) {
		for (String m : menu) {
			List<String> temp = new ArrayList<>();
			temp = Stream.of(m.split("-")).toList();
			inputMenu.put(Menu.valueOf(temp.get(0)), Integer.parseInt(temp.get(1)));
		}
	}

	public int getdate() {
		return date;
	}

	public HashMap<Menu, Integer> getInputMenu() {
		return inputMenu;
	}

}