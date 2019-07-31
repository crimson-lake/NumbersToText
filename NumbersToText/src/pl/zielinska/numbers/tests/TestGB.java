package pl.zielinska.numbers.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class TestGB {

	@Test
	public void test1() {
		assertEquals("one pound", NumbersUtil.textValue(Languages.GB, 1L));
	}
	
	@Test
	public void test100() {
		assertEquals("one hundred pounds", NumbersUtil.textValue(Languages.GB, 100L));
	}
	
	@Test
	public final void test12() {
		assertEquals("twelve pounds", NumbersUtil.textValue(Languages.GB, 12L));
	}
	
	@Test
	public void test1mln() {
		assertEquals("one million pounds", NumbersUtil.textValue(Languages.GB, 1_000_000L));
	}
	
	@Test
	public void test4783() {
		assertEquals("four thousand, seven hundred and eighty-three pounds", NumbersUtil.textValue(Languages.GB, 4_783L));
	}
	
	@Test
	public void test9bld702() {
		assertEquals("nine billiard, seven hundred and two pounds", NumbersUtil.textValue(Languages.GB, 9_000_000_000_000_702L));
	}
	
	@Test
	public final void test12B() {
		assertEquals("twelve pounds", NumbersUtil.textValue(Languages.GB, BigDecimal.valueOf(12)));
	}
	
	@Test
	public void test12B77() {
		assertEquals("twelve pounds and seventy-seven pences", NumbersUtil.textValue(Languages.GB, BigDecimal.valueOf(12.77)));
	}
}
