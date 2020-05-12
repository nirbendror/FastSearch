package com.hit.util;

import com.hit.server.Server;

public class Driver {
    public static void main(String[] args) {
        CLI cli = new CLI(System.in, System.out);
        Server server = new Server(12345);
        cli.addPropertyChangeListener(server);
        new Thread(cli).start();
    }
}
