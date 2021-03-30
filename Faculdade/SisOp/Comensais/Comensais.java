package Comensais;

public class Comensais {
	public static void main(String args[]) {
		filosofo comensais[];
		comensais = new filosofo[5];
		pauzinhos mesa[];
		mesa = new pauzinhos[5];
		int i, esq = 0, dir = 0;
		for (i = 0; i < 5; i++) {
			mesa[i] = new pauzinhos(i);
		}
		for (i = 0; i < 5; i++) {

			if (i == 0) {
				esq = 4;
				dir = 0;
			}
			if (i == 1) {
				esq = 0;
				dir = 1;
			}
			if (i == 2) {
				esq = 1;
				dir = 2;
			}
			if (i == 3) {
				esq = 2;
				dir = 3;
			}
			if (i == 4) {
				esq = 3;
				dir = 4;
			}
			comensais[i] = new filosofo(i, mesa[esq], mesa[dir], mesa);
		}
	}
}