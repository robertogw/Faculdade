package semaforo;

public enum CorSemaforo {

    VERDE(5000), AMARELO(1500), VERMELHO(4000);

    private final int tempoEspera;

    CorSemaforo(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }
}
