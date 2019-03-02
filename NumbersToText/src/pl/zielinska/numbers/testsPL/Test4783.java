package pl.zielinska.numbers.testsPL;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class Test4783 {

	@Test
	public void testTextValue() {
		assertEquals("cztery tysiące siedemset osiemdziesiąt trzy złote", 
				NumbersUtil.textValue(Languages.PL, 4783L));
	}

}
