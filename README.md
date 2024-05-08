# TCP Socket Client-Server Communication

This project implements a client-server application using TCP Sockets. The client application sends a message, and the server application responds with a modified version of the message (e.g., the message in uppercase). The server application is capable of serving multiple clients simultaneously.

## What is a Socket?

A Socket is an Interface (API) used for direct communication between two different programs, whether on the same machine or on different machines in a computer network.

## Job Description:

In this project, we realize socket communication in Java using a server and a client. The server accepts connections from clients and serves them, while the client sends a message to the server and receives a response converted to uppercase.

### Server

1. Creating ServerSocket:
   - Create an object of the ServerSocket class that listens on the specified port.
   - The server waits for connections from clients.

2. Accepting Clients:
   - After a client connects, a Socket class object is required for communication with the client.

3. Reading the Message from the Client:
   - Use a BufferedReader to read the message from the client.
   - Convert the client's message to uppercase.

4. Responding to the Client:
   - Use a PrintWriter to send the response to the client.

5. Closing the Connection with the Client:
   - After the communication is complete, the client closes the connection.

### Client

1. Creating the Client's Socket:
   - Create an object of the Socket class that connects to the server on the specified host and port.

2. Sending the Message to the Server:
   - Use PrintWriter to send the message to the server.

3. Receiving the Response:
   - Use a BufferedReader to read the response from the server.