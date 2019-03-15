package pl.zielinska.numbers.tests.gb;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test9bld702 {

	@Test
	public void testTextValue() {
		assertEquals("nine billiard, seven hundred and two pounds", NumbersUtil.textValue(Languages.GB, 9_000_000_000_000_702L));
	}

}
