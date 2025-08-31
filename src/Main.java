import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializar Scanner
        Scanner scanner = new Scanner(System.in);

        // Crear objeto cajero
        Cajero cajero = new Cajero();

        String menu = """
                \n--- CAJERO AUTOMÁTICO ---
               
                Bienvenido a tu cajero automatizado.
               
                1. Retirar dinero.
                2. Consultar saldo del cajero.
               
                Ingresa una opción:\s""";

        while (true) {
            System.out.print(menu);
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("\n-- Retiro de dinero --\n");
                    System.out.print("Ingresa el monto a retirar: ");
                    double retiro = Double.parseDouble(scanner.nextLine());
                    if (retiro <= 0) {
                        System.out.println("El monto a retirar debe ser mayor a 0.");
                        break;
                    } else if (retiro > cajero.getSaldo()) {
                        System.out.println("El monto a retirar no puede ser mayor al saldo del cajero.");
                        break;
                    }
                    List<Billete> billetesRetirados = cajero.retirarDinero(retiro);
                    if (billetesRetirados == null) {
                        System.out.println("No hay dinero suficiente para realizar el retiro.");
                    } else {
                        System.out.println("Retirado exitosamente.");
                        for (Billete billete : billetesRetirados) {
                            System.out.printf("\tDenominacion: %.2f, Cantidad: %d\n", billete.getDenominacion(), billete.getCantidad());
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n-- Información del cajero --\n");
                    cajero.infoSaldo();

                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
            }
        }
    }
}
