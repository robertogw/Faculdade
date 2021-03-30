package Comensais;

import java.util.Random;

public class filosofo implements Runnable {
	int id;
	Thread t;
	pauzinhos direito;
	pauzinhos esquerdo;
	int espera;
	Random z;
	pauzinhos mesa[];

	public filosofo(int id, pauzinhos direito, pauzinhos esquerdo,
			pauzinhos mesa[]) {
		this.id = id;
		this.direito = direito;
		this.esquerdo = esquerdo;
		System.out.println("O filosofo " + (id + 1)
				+ " pode usar os pauzinhos " + (direito.id + 1) + " e "
				+ (esquerdo.id + 1) + ". \n");
		this.mesa = mesa;
		z = new Random();
		t = new Thread(this);
		t.start();

	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			synchronized (this.direito) {
				synchronized (this.esquerdo) {
					comer();
				}
			}
			pensar();
		}
		System.out.println("Filosofo " + (id + 1) + " esta satisfeito.\n");
	}

	public void comer() {
		System.out.println("\tFilosofo " + (id + 1)
				+ " pegou os pauzinhos " + (this.esquerdo.id + 1)
				+ " e " + (this.direito.id + 1) + "\n");

		direito.pegar(id);
		esquerdo.pegar(id);
		espera = z.nextInt(5000);
		System.out.println("\tFilosofo " + (id + 1) + " est� comendo. \n");
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
		}
		direito.soltar();
		esquerdo.soltar();
		System.out
				.println("\tFilosofo " + (id + 1)
						+ " parou de comer e liberou os pauzinhos "
						+ (this.esquerdo.id + 1) + " e "
						+ (this.direito.id + 1) + "\n");

	}

	public void pensar() {
		espera = (z.nextInt(5000));
		try {
			System.out.println("\tFilosofo " + (id + 1) + " esta pensando. \n");
			Thread.sleep(espera);
		} catch (InterruptedException e) {
		}
	}

	public String checar_mesa() {
		String a = "";
		for (int i = 0; i < mesa.length; i++) {
			a = a + ("[" + mesa[i].x + "]");
		}
		return a;
	}
}