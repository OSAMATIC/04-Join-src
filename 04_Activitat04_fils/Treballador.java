
import java.util.Random;

public class Treballador extends Thread {
    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(String nom, float salariAnual, int edatIni, int edatFi) {
        super(nom);
        this.sou_anual_brut = salariAnual;
        this.edat_inici_treball = edatIni;
        this.edat_fi_treball = edatFi;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public int getEdat() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }

    public void cobrar() {
        this.cobrat += sou_anual_brut/12.0f;
    }

    public void pagaImpostos(){
        cobrat -= (sou_anual_brut / 12.0f) * 0.24f;
    }
    @Override
    public void run() {
        for (edat_actual = edat_inici_treball; edat_actual < edat_fi_treball; edat_actual++) {
            for (int mes = 0; mes < 12; mes++) {
                cobrar();
                pagaImpostos();
                try {
                    Thread.sleep(rnd.nextInt(10));
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
