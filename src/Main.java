public class Main {

	public static void main(String[] args) {
		Monitor M = new Monitor();
		Voiture V1 = new Voiture(M, 1, "V1");
		Voiture V2 = new Voiture(M, 1, "V2");
		Voiture V3 = new Voiture(M, 0, "V3");
		Voiture V4 = new Voiture(M, 1, "V4");
		Voiture V5 = new Voiture(M, 0, "V5");
		Voiture V6 = new Voiture(M, 0, "V6");
		Voiture V7 = new Voiture(M, 1, "V7");
		V1.start();
		V2.start();
		V3.start();
		V4.start();
		V5.start();
		V6.start();
		V7.start();
	}

}
