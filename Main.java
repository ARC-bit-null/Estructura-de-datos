import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Crear el conjunto de materias para Ana
        ConjuntoADT<String> materiasAna = new ConjuntoADT<>();
        materiasAna.agregarElemento("ED");
        materiasAna.agregarElemento("BD");
        materiasAna.agregarElemento("Redes");
        materiasAna.agregarElemento("IA");

        // 2. Crear el conjunto de materias para Luis
        ConjuntoADT<String> materiasLuis = new ConjuntoADT<>();
        materiasLuis.agregarElemento("ED");
        materiasLuis.agregarElemento("Redes");
        materiasLuis.agregarElemento("SO");

        int opcion = 0;
        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEMA DE MATERIAS - CONJUNTO ADT     ");
            System.out.println("==========================================");
            System.out.println("1. Ver materias y total de Ana");
            System.out.println("2. Ver materias y total de Luis");
            System.out.println("3. Consultar si un alumno cursa una materia");
            System.out.println("4. Agregar una nueva materia a un alumno");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.println("\n-> Materias de Ana: " + materiasAna);
                        System.out.println("-> Total de materias: " + materiasAna.longitud());
                        break;
                    case 2:
                        System.out.println("\n-> Materias de Luis: " + materiasLuis);
                        System.out.println("-> Total de materias: " + materiasLuis.longitud());
                        break;
                    case 3:
                        System.out.print("\n¿Qué materia deseas buscar? (ej. ED, IA, SO): ");
                        String materiaBuscar = scanner.nextLine().trim().toUpperCase();
                        System.out.println("¿Ana está inscrita? " + materiasAna.contieneElemento(materiaBuscar));
                        System.out.println("¿Luis está inscrito? " + materiasLuis.contieneElemento(materiaBuscar));
                        break;
                    case 4:
                        System.out.print("\n¿A qué alumno deseas agregar la materia? (1. Ana / 2. Luis): ");
                        int alumno = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.print("Escribe el nombre de la materia: ");
                        String nuevaMateria = scanner.nextLine().trim().toUpperCase();

                        if (alumno == 1) {
                            materiasAna.agregarElemento(nuevaMateria);
                            System.out.println("¡Materia agregada a Ana con éxito!");
                            System.out.println("Actualizado: " + materiasAna);
                        } else if (alumno == 2) {
                            materiasLuis.agregarElemento(nuevaMateria);
                            System.out.println("¡Materia agregada a Luis con éxito!");
                            System.out.println("Actualizado: " + materiasLuis);
                        } else {
                            System.out.println("Opción de alumno no válida.");
                        }
                        break;
                    case 5:
                        System.out.println("\nSaliendo del programa... ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("\nOpción inválida. Intenta de nuevo.");
                }
            } else {
                System.out.println("\nPor favor, ingresa un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
            }
        } while (opcion != 5);

        scanner.close();
    }
}
