package pl.zielinska.numbers.tests.pl;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test1mln {

	@Test
	public void testTextValue() {
		assertEquals("jeden milion złotych", NumbersUtil.textValue(Languages.PL, 1_000_000L));
	}

}
