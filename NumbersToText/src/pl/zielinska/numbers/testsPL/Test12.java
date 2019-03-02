package pl.zielinska.numbers.testsPL;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test12 {

	@Test
	public void testTextValue() {
		assertEquals("dwanaście złotych", NumbersUtil.textValue(Languages.PL, 12L));
	}

}
