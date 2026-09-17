public class Main {
    public static void main(String[] args) {
        System.out.println("=== LISTA ENLAZADA CON NODO<T> ===");

        // 1. Construcción de la lista: Al -> B -> C -> De -> Mc -> Zi
        Nodo<String> head = new Nodo<>("Al");
        head.setSiguiente(new Nodo<>("B"));
        head.getSiguiente().setSiguiente(new Nodo<>("C"));
        head.getSiguiente().getSiguiente().setSiguiente(new Nodo<>("De"));
        head.getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo<>("Mc"));
        head.getSiguiente().getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo<>("Zi"));

        // 2. Estado inicial completo
        System.out.println("\n[1] Estado inicial completo:");
        imprimirLista(head);

        // 3. Dato del primer nodo
        System.out.println("\n[2] Dato del primer nodo:");
        System.out.println(head.getDato());

        // 4. Estado completo del último nodo
        Nodo<String> ultimo = head;
        while (ultimo.getSiguiente() != null) {
            ultimo = ultimo.getSiguiente();
        }
        System.out.println("\n[3] Estado completo del último nodo:");
        System.out.println(ultimo.getDato());

        // 5. Insertamos "Fe" entre "De" y "Mc"
        Nodo<String> actual = head;
        while (actual != null && !actual.getDato().equals("De")) {
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            Nodo<String> nuevoFe = new Nodo<>("Fe", actual.getSiguiente());
            actual.setSiguiente(nuevoFe);
        }

        // 6. Imprimo estado tras insertar "Fe"
        System.out.println("\n[4] Estado tras insertar 'Fe' entre 'De' y 'Mc':");
        imprimirLista(head);

        // 7. Inserto "Zz" al final
        Nodo<String> ultimoParaZz = head;
        while (ultimoParaZz.getSiguiente() != null) {
            ultimoParaZz = ultimoParaZz.getSiguiente();
        }
        ultimoParaZz.setSiguiente(new Nodo<>("Zz"));

        // 8. Imprimimos estado tras insertar "Zz"
        System.out.println("\n[5] Estado tras insertar 'Zz' al final:");
        imprimirLista(head);

        //9.- insertar al "Aa" al inicio de todo
        Nodo<String> nuevoAa = new Nodo<>("Aa", head);
        head = nuevoAa;

        //10.- Estado dinal
        System.out.println("\n[6] Estado final del nodo");
        imprimirLista(head);
        }

    // Método auxiliar para imprimir solo los datos conectados
    public static void imprimirLista(Nodo<String> inicio) {
        Nodo<String> actual = inicio;
        while (actual != null) {
            System.out.print(actual.getDato() + (actual.getSiguiente() != null ? " -> " : ""));
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}
