import java.util.ArrayList;
import java.util.List;

public class Cajero {
    // Atributos
    private List<Billete> billetes;
    private double saldo;

    // Constructor
    public Cajero() {
        billetes = new ArrayList<>();
        billetes.add(new Billete(1000, 2));
        billetes.add(new Billete(500, 5));
        billetes.add(new Billete(200, 10));
        billetes.add(new Billete(100, 20));
        billetes.add(new Billete(50, 30));
        billetes.add(new Billete(20, 40));
        billetes.add(new Billete(10, 50));
        billetes.add(new Billete(5, 100));
        billetes.add(new Billete(2, 200));
        billetes.add(new Billete(1, 300));
        billetes.add(new Billete(0.5F, 100));

        this.saldo = 12550;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Billete> retirarDinero(double retiro) {
        List<Billete> billetesRetirados = new ArrayList<>();
        int auxIndex = 0;
        double saldo = this.saldo;
        for (Billete billete : billetes) {
            if (billete.getCantidad() == 0 || retiro/billete.getDenominacion() < 1) {
                continue;
            }
            billetesRetirados.add(new Billete(billete.getDenominacion(), 0));
            while (retiro/billete.getDenominacion() >=1 && billete.getCantidad() > 0 && saldo >= 0) {
                saldo -= billete.getDenominacion();
                retiro -= billete.getDenominacion();
                billetesRetirados.get(auxIndex).setCantidad(billetesRetirados.get(auxIndex).getCantidad() + 1);
                billete.setCantidad(billete.getCantidad() - 1);
            }
            auxIndex++;
        }
        if (retiro > 0 ) {
            return null;
        }

        setSaldo(saldo);
        return billetesRetirados;
    }

    public void infoSaldo() {
        System.out.println("---Billetes disponibles");
        for (Billete billete : billetes) {
            System.out.printf("\tDenominacion: %.2f, Cantidad: %d\n", billete.getDenominacion(), billete.getCantidad());
        }
        System.out.printf("\n---Saldo total: %.2f%n", this.saldo);
    }
}