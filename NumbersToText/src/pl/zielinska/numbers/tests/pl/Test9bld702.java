package pl.zielinska.numbers.tests.pl;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test9bld702 {

	@Test
	public void testTextValue() {
		assertEquals("dziewięć biliardów siedemset dwa złote", 
				NumbersUtil.textValue(Languages.PL, 9_000_000_000_000_702L));
	}

}
