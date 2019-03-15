package pl.zielinska.numbers.tests.gb;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test4783 {

	@Test
	public void testTextValue() {
		assertEquals("four thousand, seven hundred and eighty-three pounds", NumbersUtil.textValue(Languages.GB, 4_783L));
	}

}
