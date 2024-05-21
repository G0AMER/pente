package tn.enis.pont;

public class Voiture extends Thread {
	private Monitor M;
	private int direction;

	Voiture(Monitor M, int direction, String name) {
		super(name);
		this.M = M;
		this.direction = direction;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			M.passer(direction);
			M.accesPont();
			M.quitter();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
