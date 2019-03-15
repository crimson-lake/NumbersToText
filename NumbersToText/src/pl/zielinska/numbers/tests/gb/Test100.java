package pl.zielinska.numbers.tests.gb;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test100 {

	@Test
	public void testTextValue() {
		assertEquals("one hundred pounds", NumbersUtil.textValue(Languages.GB, 100L));
	}

}
