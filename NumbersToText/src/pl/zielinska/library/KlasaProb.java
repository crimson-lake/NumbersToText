package pl.zielinska.library;

public class KlasaProb {

	public static void main(String[] args) {
		long p = System.currentTimeMillis();
		String wynik = NumbersUtil.textValue(Languages.PL, 2000000L);
		System.out.println(wynik);
		long k = System.currentTimeMillis();
		System.out.printf("t = %d\n", k - p);
	

	}

}
