package discount;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountTest {
	private int testDate;

	@DisplayName("특별 할인 테스트 - 별 있는 날")
	@Test
	void testCalculate1() {
		testDate = 3;
		SpecialDiscount testSpecial = new SpecialDiscount(testDate);

		assertThat(testSpecial.calculate()).isEqualTo(1000);
	}

	@DisplayName("특별 할인 테스트 - 별 없는 날")
	@Test
	void testCalculate2() {
		testDate = 4;
		SpecialDiscount testSpecial = new SpecialDiscount(testDate);

		assertThat(testSpecial.calculate()).isEqualTo(0);
	}
}