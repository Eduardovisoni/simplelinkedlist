package umg.edu.gt.listasenlazadas.simple;

/**
 * Ejemplo didactico de operaciones con lista simplemente enlazada.
 */
public final class SimpleListExample {

    private SimpleListExample() {
    }

    public static void run() {
        SinglyLinkedList<String> pendientes = new SinglyLinkedList<>();
        pendientes.addLast("Investigar tema de grafos");
        pendientes.addLast("Resolver hoja de ejercicios");
        pendientes.addFirst("Repasar listas enlazadas");

        System.out.println("--- Lista Simple ---");
        System.out.println("Pendientes: " + pendientes);
        System.out.println("Contiene 'grafos': " + pendientes.contains("Investigar tema de grafos"));

        String completada = pendientes.removeFirst();
        System.out.println("Tarea completada: " + completada);
        System.out.println("Pendientes actualizados: " + pendientes);
        System.out.println();
        
        SinglyLinkedList<String> duplicados = new SinglyLinkedList<>();
        duplicados.addLast("A");
        duplicados.addLast("B");
        duplicados.addLast("A");
        duplicados.addLast("C");
        duplicados.addLast("B");
        duplicados.addLast("D");

        System.out.println("Lista con duplicados: " + duplicados);
        int removidos = duplicados.removeDuplicates();
        System.out.println("Duplicados eliminados: " + removidos);
        System.out.println("Lista sin duplicados: " + duplicados);

        duplicados.reverseInPlace();
        System.out.println("Lista invertida: " + duplicados);

        int eliminados = duplicados.clean();
        System.out.println("Nodos eliminados con clean(): " + eliminados);
        System.out.println("Lista después de clean(): " + duplicados);

        System.out.println();
        
    }
}
