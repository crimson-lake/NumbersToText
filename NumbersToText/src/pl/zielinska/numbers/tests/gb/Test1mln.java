package pl.zielinska.numbers.tests.gb;

import static org.junit.Assert.*;
import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test1mln {

	@Test
	public void testTextValue() {
		assertEquals("one million pounds", NumbersUtil.textValue(Languages.GB, 1_000_000L));
	}

}
