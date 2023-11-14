package discount;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Menu;

class WeekendDiscountTest {
	private int testDate;
	private HashMap<Menu, Integer> testMenu = new HashMap<Menu, Integer>();

	@DisplayName("주말 할인 테스트 - 주말 디저트 1, 메인 1")
	@Test
	void testCalculate1() {
		testDate = 1;
		testMenu.put(Menu.초코케이크, 1);
		testMenu.put(Menu.바비큐립, 1);
		WeekendDiscount testWeekend = new WeekendDiscount(testDate, testMenu);

		assertThat(testWeekend.calculate()).isEqualTo(2023);
	}

	@DisplayName("주말 할인 테스트 - 주말 디저트 1, 메인 2")
	@Test
	void testCalculate2() {
		testDate = 1;
		testMenu.put(Menu.초코케이크, 1);
		testMenu.put(Menu.바비큐립, 2);
		WeekendDiscount testWeekend = new WeekendDiscount(testDate, testMenu);

		assertThat(testWeekend.calculate()).isEqualTo(2023 * 2);
	}

	@DisplayName("주말 할인 테스트 - 평일 디저트 1, 메인 1")
	@Test
	void testCalculate3() {
		testDate = 3;
		testMenu.put(Menu.초코케이크, 1);
		testMenu.put(Menu.바비큐립, 1);
		WeekendDiscount testWeekend = new WeekendDiscount(testDate, testMenu);

		assertThat(testWeekend.calculate()).isEqualTo(0);
	}
}