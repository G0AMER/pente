import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
	private int sensActif = 1;
	private int nbV = 0;
	private final Lock lock = new ReentrantLock();
	private final Condition C1 = lock.newCondition();

	void passer(int direction) throws InterruptedException {
		lock.lock();
		try {
			if (nbV == 0)
				sensActif = direction;
			while (direction != sensActif) {
				System.out.println(Thread.currentThread().getName() + " en attente avec le sens " + direction);
				C1.await();
				if (nbV == 0)
					sensActif = direction;
				System.out.println(Thread.currentThread().getName() + "  quitte l'attente avec le sens " + direction);
			}
			nbV++;
			System.out.println(Thread.currentThread().getName() + "  passe avec sens " + direction);
		} finally {
			lock.unlock();
		}
	}

	void accesPont() {
		System.out.println(Thread.currentThread().getName() + "  dans le pont");
	}

	void quitter() {
		lock.lock();
		nbV--;
		System.out.println(Thread.currentThread().getName() + "  quitte le pont");
		C1.signal();
		lock.unlock();
	}

}
