package discount;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DDayDiscountTest {
	private DDayDiscount testDDay;
	private HashMap<Integer, Integer> dateAndResult = new HashMap<Integer, Integer>() {
		{
			put(1, 1000);
			put(2, 1100);
			put(25, 3400);
			put(26, 0);
		}
	};

	@BeforeEach
	void setUp() {
		testDDay = new DDayDiscount();
	}

	@DisplayName("디데이 할인 적용 금액 테스트 - 1일")
	@Test
	void testCalculate1() {
		int testDate = 1;

		assertThat(testDDay.calculate(testDate)).isEqualTo(dateAndResult.get(testDate));
	}

	@DisplayName("디데이 할인 적용 금액 테스트 - 2일")
	@Test
	void testCalculate2() {
		int testDate = 2;

		assertThat(testDDay.calculate(testDate)).isEqualTo(dateAndResult.get(testDate));
	}

	@DisplayName("디데이 할인 적용 금액 테스트 - 25일")
	@Test
	void testCalculate25() {
		int testDate = 25;

		assertThat(testDDay.calculate(testDate)).isEqualTo(dateAndResult.get(testDate));
	}

	@DisplayName("디데이 할인 적용 금액 테스트 - 26일")
	@Test
	void testCalculate26() {
		int testDate = 26;

		assertThat(testDDay.calculate(testDate)).isEqualTo(dateAndResult.get(testDate));
	}

}
