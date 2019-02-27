package pl.zielinska.library;

public class KlasaProb {

	public static void main(String[] args) {
		long p = System.currentTimeMillis();
		String wynik = NumbersUtil.textValue(Languages.PL, 385767364736L);
		System.out.println(wynik);
		long k = System.currentTimeMillis();
		System.out.printf("t = %d\n", k - p);
	

	}

}
