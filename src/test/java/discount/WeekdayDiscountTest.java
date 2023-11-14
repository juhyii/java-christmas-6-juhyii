package discount;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.Menu;

class WeekdayDiscountTest {
	private int testDate;
	private HashMap<Menu, Integer> testMenu = new HashMap<Menu, Integer>();

	@DisplayName("평일 할인 테스트 - 평일 디저트 1, 메인 1")
	@Test
	void testCalculate1() {
		testDate = 3;
		testMenu.put(Menu.초코케이크, 1);
		testMenu.put(Menu.바비큐립, 1);
		WeekdayDiscount testWeekday = new WeekdayDiscount(testDate, testMenu);

		assertThat(testWeekday.calculate()).isEqualTo(2023);
	}

	@DisplayName("평일 할인 테스트 - 평일 디저트 2, 메인 1")
	@Test
	void testCalculate2() {
		testDate = 3;
		testMenu.put(Menu.초코케이크, 2);
		testMenu.put(Menu.바비큐립, 1);
		WeekdayDiscount testWeekday = new WeekdayDiscount(testDate, testMenu);

		assertThat(testWeekday.calculate()).isEqualTo(2023 * 2);
	}

	@DisplayName("평일 할인 테스트 - 주말 디저트 1, 메인 1")
	@Test
	void testCalculate3() {
		testDate = 1;
		testMenu.put(Menu.초코케이크, 1);
		testMenu.put(Menu.바비큐립, 1);
		WeekdayDiscount testWeekday = new WeekdayDiscount(testDate, testMenu);

		assertThat(testWeekday.calculate()).isEqualTo(0);
	}
}