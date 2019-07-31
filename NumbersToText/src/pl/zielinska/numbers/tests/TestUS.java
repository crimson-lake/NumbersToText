package pl.zielinska.numbers.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class TestUS {

	@Test
	public void test1() {
		assertEquals("one dollar", NumbersUtil.textValue(Languages.US, 1L));
	}
	
	@Test
	public void test100() {
		assertEquals("one hundred dollars", NumbersUtil.textValue(Languages.US, 100L));
	}
	
	@Test
	public final void test12() {
		assertEquals("twelve dollars", NumbersUtil.textValue(Languages.US, 12L));
	}
	
	@Test
	public void test1mln() {
		assertEquals("one million dollars", NumbersUtil.textValue(Languages.US, 1_000_000L));
	}
	
	@Test
	public void test4783() {
		assertEquals("four thousand, seven hundred and eighty-three dollars", NumbersUtil.textValue(Languages.US, 4_783L));
	}
	
	@Test
	public void test9bld702() {
		assertEquals("nine quadrillion, seven hundred and two dollars", NumbersUtil.textValue(Languages.US, 9_000_000_000_000_702L));
	}

	@Test
	public void test12B77() {
		assertEquals("twelve dollars and seventy-seven cents", NumbersUtil.textValue(Languages.US, BigDecimal.valueOf(12.77)));
	}
	
}
