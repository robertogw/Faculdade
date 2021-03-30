package semaforo;

public class Semafaro {

    public static void main(String[] args) {

        SemaforoThread semafaro = new SemaforoThread();

        for (int i = 0; i < 10; i++) {
            System.out.println(semafaro.getCor());
            semafaro.esperaCorMudar();
        }

        semafaro.desligarSemafaro();
    }

}
