package pl.zielinska.numbers.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.zielinska.numbers.languages.Languages;
import pl.zielinska.numbers.util.NumbersUtil;

public class TestPL {
	
	@Test
	public void test12() {
		assertEquals("dwanaście złotych", NumbersUtil.textValue(Languages.PL, 12L));
	}
	
	@Test
	public void test1mln() {
		assertEquals("jeden milion złotych", NumbersUtil.textValue(Languages.PL, 1_000_000L));
	}
	
	@Test
	public void test1() {
		assertEquals("jeden złoty", NumbersUtil.textValue(Languages.PL, 1L));
	}
	
	@Test
	public void test4783() {
		assertEquals("cztery tysiące siedemset osiemdziesiąt trzy złote", 
				NumbersUtil.textValue(Languages.PL, 4783L));
	}
	
	@Test
	public void test9bld702() {
		assertEquals("dziewięć biliardów siedemset dwa złote", 
				NumbersUtil.textValue(Languages.PL, 9_000_000_000_000_702L));
	}
}
