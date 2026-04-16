package umg.edu.gt.listasenlazadas.applications;

import umg.edu.gt.listasenlazadas.circular.CircularLinkedList;

/**
 * Caso real: reproduccion ciclica de canciones con lista circular.
 */
public final class RoundRobinPlaylistApp {

    private RoundRobinPlaylistApp() {
    }

    public static void run() {
        CircularLinkedList<String> playlist = new CircularLinkedList<>();
        playlist.addLast("Cancion A");
        playlist.addLast("Cancion B");
        playlist.addLast("Cancion C");

        System.out.println("2) RoundRobinPlaylistApp");
        System.out.println("Playlist: " + playlist);
        System.out.println("Reproduciendo en ciclo (5 turnos):");

        for (int i = 0; i < 5; i++) {
            String cancion = playlist.removeFirst();
            System.out.println("  Reproduciendo: " + cancion);
            playlist.addLast(cancion);
        }

        System.out.println("Estado final de playlist: " + playlist);
    }
}
