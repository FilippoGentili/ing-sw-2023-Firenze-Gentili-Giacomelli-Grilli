package it.polimi.ingsw.Network.Server.Persistence;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Network.Server.Server;

import java.io.*;
import java.util.logging.Level;

public class GameSaved {
    public static void saveGame(GameController gameController) {
        Persistence persistence = new Persistence(gameController);

        try (FileOutputStream savedGame = new FileOutputStream(new File("MyShelfie.savedGame"))) {
            ObjectOutputStream out = new ObjectOutputStream(savedGame);

            out.writeObject(persistence);
            Server.LOGGER.log(Level.INFO, "Game state saved");

            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            Server.LOGGER.severe(e.getMessage());
        }
    }

    public static GameController loadGame(Server server){
        Persistence persistence;

        try(FileInputStream savedGame=new FileInputStream("MyShelfie.savedGame")){
            ObjectInputStream in = new ObjectInputStream(savedGame);
            persistence = (Persistence) in.readObject();
            GameController newGameController= new GameController(server, persistence.getGameController());
            newGameController.getGame().loadGame(persistence.getGameController().getGame());

            return newGameController;
        } catch(FileNotFoundException e){
            Server.LOGGER.severe("There is no existent file to be loaded!");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            Server.LOGGER.severe(e.getMessage());
            return null;
        }
    }
}