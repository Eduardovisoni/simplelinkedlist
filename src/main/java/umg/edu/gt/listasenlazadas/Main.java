package umg.edu.gt.listasenlazadas;

import umg.edu.gt.listasenlazadas.applications.RoundRobinPlaylistApp;
import umg.edu.gt.listasenlazadas.applications.TaskBacklogApp;
import umg.edu.gt.listasenlazadas.applications.UndoRedoEditorApp;
import umg.edu.gt.listasenlazadas.circular.CircularListExample;
import umg.edu.gt.listasenlazadas.doubly.DoublyListExample;
import umg.edu.gt.listasenlazadas.retos.LinkedListChallenges;
import umg.edu.gt.listasenlazadas.simple.SimpleListExample;

/**
 * Punto de entrada del proyecto.
 * Ejecuta ejemplos base y aplicaciones practicas.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== DEMOS ESTRUCTURAS ENLAZADAS ===");
        System.out.println();

        SimpleListExample.run();
        DoublyListExample.run();
        CircularListExample.run();

        System.out.println();
        System.out.println("=== APLICACIONES REALES ===");
        TaskBacklogApp.run();
        System.out.println();
        RoundRobinPlaylistApp.run();
        System.out.println();
        UndoRedoEditorApp.run();

        System.out.println();
        LinkedListChallenges.run();
    }
}
