public class SocketClient {
    private String hostname;
    private int port;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public SocketClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException {
        String localHostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Connecting to server on " + localHostAddress + ":" + port);

        socket = new Socket(hostname, port);
        System.out.println("Connected to server on " + localHostAddress + ":" + port);

        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public void disconnect() throws IOException {
        ois.close();
        oos.close();
        socket.close();
    }

    public void sendMessage(Object message) throws IOException {
        oos.writeObject(message);
        oos.flush();
    }

    public Object receiveMessage() throws ClassNotFoundException, IOException {
        Object message = ois.readObject();
        return message;
    }
}