package com.example;

public class App {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Set each other as opponents
        player1.setOpponent(player2);
        player2.setOpponent(player1);

        // Start both players in separate threads
        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();

        // Player 1 initiates communication
        player1.sendMessage("Hello from Player 1");

        // Wait for the communication to end
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Communication ended after 10 messages.");
    }
}
