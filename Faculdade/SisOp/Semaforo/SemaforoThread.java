package semaforo;

public class SemaforoThread implements Runnable {

    private CorSemaforo cor;
    private boolean parar;
    private boolean mudarCor;

    public SemaforoThread() {
        this.cor = CorSemaforo.VERMELHO;

        this.parar = false;
        this.mudarCor = false;

        new Thread(this).start();
    }

    @Override
    public void run() {

        while (!parar) {
            try {
                Thread.sleep(this.cor.getTempoEspera());
                this.mudarCor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void mudarCor() {
        switch (this.cor) {
            case VERMELHO:
                this.cor = CorSemaforo.VERDE;
                break;
            case AMARELO:
                this.cor = CorSemaforo.VERMELHO;
                break;
            case VERDE:
                this.cor = CorSemaforo.AMARELO;
                break;
            default:
                break;
        }
        this.mudarCor = true;
        notify();
    }

    public synchronized void esperaCorMudar() {
        while (!this.mudarCor) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getCause();
            }
        }
        this.mudarCor = false;
    }

    public synchronized void desligarSemafaro() {
        this.parar = true;
    }

    public CorSemaforo getCor() {
        return cor;
    }
}
