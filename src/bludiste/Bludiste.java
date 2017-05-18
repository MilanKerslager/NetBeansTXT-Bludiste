package bludiste;

public class Bludiste {

    final static int Z = Integer.MIN_VALUE;
    final static int C = Integer.MAX_VALUE;

    static int bludiste[][] = {
        {Z, Z, Z, Z, Z, Z, Z, Z, Z},
        {Z, C, 0, 0, 0, 0, Z, 0, Z},
        {Z, Z, Z, 0, Z, 0, Z, 0, Z},
        {Z, 0, 0, 0, Z, 0, Z, 0, Z},
        {Z, Z, Z, Z, Z, 0, Z, 0, Z},
        {Z, 0, Z, 0, Z, 0, 0, 0, Z},
        {Z, 0, Z, 0, Z, 0, Z, Z, Z},
        {Z, 0, 0, 0, 0, 0, 0, 0, Z},
        {Z, Z, Z, Z, Z, Z, Z, Z, Z},};

    public static void main(String[] args) {
        vykresliBludiste();
        vysaditPruzkumnika(7, 7, 1); // startovací políčko bludiste[7,7]
        System.out.println("Výsledek");
        vykresliBludiste();
    }

    private static void vysaditPruzkumnika(int r, int s, int k) {
        if (bludiste[r][s] == C) {
            System.out.println("Cíl nalezen na " + k + " kroků.");
            return;
        } else if (bludiste[r][s] != 0) {
            return; // nelze vstoupit do zdi nebo kde už byl
        }
        bludiste[r][s] = k;
        vysaditPruzkumnika(r + 1, s, k + 1); // dolů
        vysaditPruzkumnika(r, s + 1, k + 1); // doprava
        vysaditPruzkumnika(r, s - 1, k + 1); // doleva
        vysaditPruzkumnika(r - 1, s, k + 1); // nahoru
    }

    private static void vykresliBludiste() {
        for (int j = 0; j < bludiste.length; j++) {
            for (int i = 0; i < bludiste[j].length; i++) {
                switch (bludiste[j][i]) {
                    case Z:
                        System.out.print(" Z ");
                        break;
                    case C:
                        System.out.print(" C ");
                        break;
                    default:
                        System.out.printf("%2d ", bludiste[j][i]);
                }
            }
            System.out.println("");
        }
    }
}
