package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Player implements Runnable {
    private String name;
    private BlockingQueue<String> inbox;
    private Player opponent;
    private int messageCounter = 0;

    public Player(String name) {
        this.name = name;
        this.inbox = new LinkedBlockingQueue<>();
    }

    // Set opponent player for communication
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    // Send message to opponent
    public void sendMessage(String message) {
        System.out.println(name + " sends: " + message);
        opponent.receiveMessage(message);
    }

    // Receive message and process it
    public void receiveMessage(String message) {
        inbox.offer(message);
    }

    // Main logic for player communication
    @Override
    public void run() {
        while (messageCounter < 10) {
            try {
                String message = inbox.take();  // Receive message
                messageCounter++;
                String newMessage = message + " (message #" + messageCounter + " from " + name + ")";
                System.out.println(name + " received: " + message);
                sendMessage(newMessage);  // Respond with new message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public int getMessageCounter() {
        return messageCounter;
    }
}
