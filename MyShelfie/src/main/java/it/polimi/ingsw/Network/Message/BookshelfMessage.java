package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Bookshelf;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

public class BookshelfMessage extends Message{
    private static final long serialVersionUID = -5209515534243253353L;
    private Bookshelf bookshelf;

    /**
     * Message from server to client to show the bookshelf
     * @param player
     */
    public BookshelfMessage(Player player) {
        super(Game.getServerName(), MessageType.BOOKSHELF);
        this.bookshelf=player.getBookshelf();
    }

    public Bookshelf getBookshelf(){
        return bookshelf;
    }

}
