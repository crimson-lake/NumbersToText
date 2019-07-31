package pl.zielinska.numbers.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class TestWeirdInput {

	@Test
	public void testZero() {
		assertEquals("zero złotych", NumbersUtil.textValue(Languages.PL, 0L));
	}
	
	@Test
	public void testMinus() {
		assertEquals("minus dziesięć złotych", NumbersUtil.textValue(Languages.PL, -10L));
	}
	
	@Test
	public void testMinusB() {
		assertEquals("minus one hundred dollars and seven cents", NumbersUtil.textValue(Languages.US, BigDecimal.valueOf(-100.07)));
	}

}
