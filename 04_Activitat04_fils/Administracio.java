
public class Administracio {
    private static final int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    public Administracio() {
        this.poblacio_activa = new Treballador[num_poblacio_activa];
        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    public static void main(String[] args) {
        Administracio adm = new Administracio();

        for (Treballador t : adm.poblacio_activa) t.start();

        for (Treballador t : adm.poblacio_activa) {
            try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        for (Treballador t : adm.poblacio_activa) {
            System.out.printf("%s -> edat: %d / total: %.2f%n",
                              t.getName(), t.getEdat(), t.getCobrat());
        }
    }
}
