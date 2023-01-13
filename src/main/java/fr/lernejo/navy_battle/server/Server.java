package fr.lernejo.navy_battle.server;

import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.server.context.ApiGameStart;
import fr.lernejo.navy_battle.server.context.Custom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    public boolean run (int port) {
        try {
            System.out.println("Run");
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            server.setExecutor(Executors.newFixedThreadPool(1));
            server.createContext("/ping", new Custom());
            server.createContext("/api/game/start", new ApiGameStart());

            server.start();
        } catch (IOException e) {
            System.out.println("Error: Server could not be created" + e);
            return false;
        }
        return true;
    }
}
