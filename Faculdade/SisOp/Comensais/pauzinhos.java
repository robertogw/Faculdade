package Comensais;

public class pauzinhos {
	int id;
	boolean x;
	int quem;

	public pauzinhos(int id) {
		this.id = id;
		x = false;
		quem = 10;
	}

	public void pegar(int quem) {
		this.quem = quem;
		x = true;
		notifyAll();
	}

	public void soltar() {
		quem = 10;
		x = false;
		notifyAll();
	}
}