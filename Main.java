import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int option;

        do {
            System.out.println("\n📞 AGENDA TELEFÓNICA");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar agenda");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) {  // Validación de entrada numérica
                System.out.println("Ingrese un número válido.");
                sc.next();
            }
            option = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Ingrese el número: ");
                    String number = sc.nextLine().trim();
                    System.out.println(agenda.addContact(name, number));

                    break;
                case 2:
                    System.out.print("Ingrese el nombre a buscar: ");
                    name = sc.nextLine().trim();
                    System.out.println(agenda.searchContactByName(name));
                    break;
                case 3:
                    System.out.print("Ingrese el nombre a eliminar: ");
                    name = sc.nextLine().trim();
                    System.out.println(agenda.removeContact(name));
                    break;
                case 4:
                    agenda.viewAgenda();
                    break;
                case 5:
                    System.out.println("👋 Saliendo del programa...");
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        } while (option != 5);

        sc.close();
    }
}
