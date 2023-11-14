package discount;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayEventTest {
	private int totalAmount;

	@DisplayName("증정 이벤트 테스트 - 증정")
	@Test
	void testCalculate1() {
		totalAmount = 120000;
		GiveawayEvent testGiveaway = new GiveawayEvent(totalAmount);

		assertThat(testGiveaway.calculate()).isEqualTo(25000);
	}

	@DisplayName("증정 이벤트 테스트 - 미증정")
	@Test
	void testCalculate2() {
		totalAmount = 110000;
		GiveawayEvent testGiveaway = new GiveawayEvent(totalAmount);

		assertThat(testGiveaway.calculate()).isEqualTo(0);
	}
}