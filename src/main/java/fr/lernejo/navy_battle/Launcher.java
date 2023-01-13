package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.server.Server;

public class Launcher {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Port_number\n");
            return;
        }
        int port = 0;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("Port_number\n");
            return;
        }

        Server server = new Server();
        server.run(port);
    }
}
