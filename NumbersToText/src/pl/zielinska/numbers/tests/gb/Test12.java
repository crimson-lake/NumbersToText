package pl.zielinska.numbers.tests.gb;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test12 {

	@Test
	public final void testTextValue() {
		assertEquals("twelve pounds", NumbersUtil.textValue(Languages.GB, 12L));
	}

}
