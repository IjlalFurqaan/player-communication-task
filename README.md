# Player Communication Task

This project implements a simple message-passing system between two players using Java. The goal of the project is to simulate a communication scenario where two players send and receive messages until each player has sent and received 10 messages. The project is implemented with pure Java, utilizing multi-threading with `BlockingQueue` for inter-thread communication.

## Features

- Two players alternate between sending and receiving messages.
- Each player appends a message counter to the message before sending it back.
- The communication stops after both players have exchanged 10 messages.
- The program runs in a single Java process using separate threads for each player.
- Simple and clean design with a focus on functionality and clarity.

## Project Structure

- **App.java**: The main entry point for the application. It initializes the players and starts the communication between them.
- **Player.java**: The class that defines the behavior of each player. Each player can send, receive, and process messages.
- **pom.xml**: The Maven configuration file that manages the project's dependencies and build settings.
- **start.sh**: A shell script to compile and run the project using Maven.

## Prerequisites

To run this project, ensure you have the following installed:

- **Java** (version 8 or higher)
- **Maven** (for building and running the project)

You can install Maven from [here](https://maven.apache.org/install.html).

