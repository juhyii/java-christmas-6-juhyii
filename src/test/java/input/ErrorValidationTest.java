package input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;

import ErrorValidation.ValidateDate;
import ErrorValidation.ValidateMenuFormat;
import ErrorValidation.ValidateOrderFormat;

class ErrorValidationTest {

	@ValueSource(strings = {"0", "32"})
	@DisplayName("1-31 범위 내의 숫자를 입력하지 않으면 예외가 발생한다.")
	void testValidateDateRange(String input) {
		assertThatThrownBy(() -> ValidateDate.validateDate("32"))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@ValueSource(strings = {" ", "first", "2일"})
	@DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
	void testValidateDateInteger(String input) {
		assertThatThrownBy(() -> ValidateDate.validateDate(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@ValueSource(strings = {",시저샐러드-1,제로콜라-1", "시저샐러드-1,,제로콜라-1", "시저샐러드-1,제로콜라-1,"})
	@DisplayName("잘못된 ,입력시 예외가 발생한다.")
	void testValidateOrderFormatComma(String input) {
		assertThatThrownBy(() -> ValidateOrderFormat.validateOrderFormat(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@ValueSource(strings = {"-시저샐러드-1,제로콜라-1", "시저샐러드--1", "시저샐러드-1,제로콜라-1-"})
	@DisplayName("잘못된 -입력시 예외가 발생한다.")
	void testValidateOrderFormatHyphen(String input) {
		
		assertThatThrownBy(() -> ValidateOrderFormat.validateOrderFormat(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@ValueSource(strings = {"시저샐러드1", "시저샐러드,1"})
	@DisplayName("메뉴이름-개수 형태가 아닐시 예외가 발생한다.")
	void testValidateOrderFormat(String input) {
		assertThatThrownBy(() -> ValidateOrderFormat.validateOrderFormat(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("메뉴 개수가 1 미만일시 예외가 발생한다.")
	void testValidateMenusZero(String input) {
		List<String> testmenu = new ArrayList<>(Arrays.asList("시저샐러드-0"));
		assertThatThrownBy(() -> ValidateMenuFormat.validateMenus(testmenu))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("메뉴 개수가 숫자가 아닐시 예외가 발생한다.")
	void testValidateMenusInteger(String input) {
		List<String> testmenu = new ArrayList<>(Arrays.asList("시저샐러드-하나"));
		assertThatThrownBy(() -> ValidateMenuFormat.validateMenus(testmenu))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("중복된 메뉴 입력시 예외가 발생한다.")
	void testValidateMenusDuplication(String input) {
		List<String> testmenu = new ArrayList<>(Arrays.asList("시저샐러드-1,시저샐러드-1"));
		assertThatThrownBy(() -> ValidateMenuFormat.validateMenus(testmenu))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("메뉴 개수 총합이 20 초과일시 예외가 발생한다.")
	void testValidateMenusCount(String input) {
		List<String> testmenu = new ArrayList<>(Arrays.asList("시저샐러드-2,제로콜라-19"));
		assertThatThrownBy(() -> ValidateMenuFormat.validateMenus(testmenu))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("메뉴판에 없는 메뉴 입력시 예외가 발생한다.")
	void testValidateMenuIs(String input) {
		List<String> testmenu = new ArrayList<>(Arrays.asList("시저샐러드-1,탄산수-1"));
		assertThatThrownBy(() -> ValidateMenuFormat.validateMenus(testmenu))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("음료 카테고리에 해당하는 메뉴만 입력시 예외가 발생한다.")
	void testValidateMenusOnlyBeverage(String input) {
		List<String> testmenu = new ArrayList<>(Arrays.asList("제로콜라-1,레드와인-1"));
		assertThatThrownBy(() -> ValidateMenuFormat.validateMenus(testmenu))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
