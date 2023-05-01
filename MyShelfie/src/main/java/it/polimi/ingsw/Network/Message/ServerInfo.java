package it.polimi.ingsw.Network.Message;

public class ServerInfo extends Message{
    private static final long serialVersionUID = -5932772855094497108L;
    private String IPAddress;
    private String Port;

    /**
     * Message used to update on the server info
     * @param nickname
     * @param IPAddress
     * @param Port
     */
    public ServerInfo(String nickname, String IPAddress, String Port) {
        super(nickname, MessageType.SERVER_INFO);
        this.IPAddress = IPAddress;
        this.Port = Port;
    }

    public String getIPAddress(){
        return IPAddress;
    }

    public String getPort(){
        return Port;
    }

    @Override
    public String toString(){
        return "" + getNickname() + " has chosen IPAddress = " + getIPAddress() + " and port: " + getPort();
    }
}

