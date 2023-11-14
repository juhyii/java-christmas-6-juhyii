package discount;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBadgeTest {
	private int testAmount;

	@DisplayName("이벤트 배지 테스트 - 없음")
	@Test
	void testBadge1() {
		testAmount = 4900;
		EventBadge testBadge = new EventBadge(testAmount);

		assertThat(testBadge.result()).isEqualTo(Badges.없음);
	}

	@DisplayName("이벤트 배지 테스트 - 별")
	@Test
	void testBadge2() {
		testAmount = 5000;
		EventBadge testBadge = new EventBadge(testAmount);

		assertThat(testBadge.result()).isEqualTo(Badges.별);
	}

	@DisplayName("이벤트 배지 테스트 - 트리")
	@Test
	void testBadge3() {
		testAmount = 10000;
		EventBadge testBadge = new EventBadge(testAmount);

		assertThat(testBadge.result()).isEqualTo(Badges.트리);
	}

	@DisplayName("이벤트 배지 테스트 - 산타")
	@Test
	void testBadge4() {
		testAmount = 20000;
		EventBadge testBadge = new EventBadge(testAmount);

		assertThat(testBadge.result()).isEqualTo(Badges.산타);
	}
}