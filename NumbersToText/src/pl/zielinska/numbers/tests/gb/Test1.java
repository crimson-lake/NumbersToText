package pl.zielinska.numbers.tests.gb;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test1 {

	@Test
	public void testTextValue() {
		assertEquals("one pound", NumbersUtil.textValue(Languages.GB, 1L));
	}

}
