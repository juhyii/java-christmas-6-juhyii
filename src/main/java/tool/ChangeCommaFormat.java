package tool;

import java.text.DecimalFormat;

public class ChangeCommaFormat {
	public static String change(int number) {
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(number);
	}
}