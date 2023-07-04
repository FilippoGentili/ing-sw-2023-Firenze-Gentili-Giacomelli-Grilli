# **Progetto ingegneria del software 2023**

![image](https://github.com/FilippoGentili/ing-sw-2023-Firenze-Gentili-Giacomelli-Grilli/assets/125986747/4e649d56-23f9-4c2b-9767-cb793ac55d93)

_Project folder_: ing-sw-2023-Firenze-Gentili-Giacomelli-Grilli

Our project implements the board game "My Shelfie", through one server and multiple clients, one for each player, and architectural pattern Model-View-Controller. Two to four players can participate only in one game at a time, upon startup they can choose whether to play using Command Line Interface (CLI) or Graphic User Interface (GUI). 

## **Documentation**

### UML

The following UML diagrams represent the initial model of the project, realized in the beginning of the project development, and the final ones.
- [First UML](MyShelfie/src/deliverables/uml/uml_initial.jpg)
- Final UML :
  - [Model](MyShelfie/src/deliverables/uml/uml_model.png)
  - [Network-View](MyShelfie/src/deliverables/uml/uml_network_view.png)
  - [Network-View](MyShelfie/src/deliverables/uml/uml_network_view_detailed.png) (detailed version)


### Sequence Diagram
- [Login Sequence Diagram](MyShelfie/src/deliverables/uml/Sequence_Diagram_Login.png)
- [Inserting Tiles Sequence Diagram](MyShelfie/src/deliverables/uml/Sequence_diagram_Inserting_tiles.png)
- [Common Goal Sequence Diagram](MyShelfie/src/deliverables/uml/Sequence_diagram_commonGoal.png)

## **JavaDoc**
Project's documentation can be found throughout the whole code, describing each method. 

## **Libraries and plugins**
Library/Plugin | Description
---------------|------------
Maven | Software project management and comprehension tool based on the concept of a project object model (POM)|
Junit | Framework dedicated to java testing unit |
JavaFx | Graphic library specific for graphic user interface

## **Features**
- Complete Rules
- CLI
- GUI
- RMI
- Socket
## **Advanced Features**
- Persistence
- Chat

## **Execution of jar files**
Jar files can be downloaded [here](MyShelfie/src/deliverables/jar).

#### **Client**

In order to run the client open a terminal window, navigate to the correct path where the jar file is and type in:

```
java -jar clientMain.jar
```

To be able to play with GUI, depedencies of JavaFX need to be imported. Correct SDK for the operative system, which can be downloaded from [here](https://gluonhq.com/products/javafx/), must be put in the same folder as clientMain.jar .
Then the following instruction has to be typed in:

```
java --module-path javafx-sdk-20.0.1/lib --add-modules javafx.controls --add-modules javafx.fxml -jar clientMain.jar
```

Both using CLI and GUI a client can choose socket or RMI connection, both servers are always started so that different players can choose different types of connection.

When playing with GUI, it may be necessary to download the project's font [here](http://legionfonts.com/fonts/blackadder-itc). 

#### **Server**

To start the server and create a new game it is only necessary to type in

```
java -jar serverMain.jar
```
otherwise, if you want to reload an existing game type in

```
java -jar serverMain.jar -r
```

Socket server will start on port 1098. RMI Server will start on port 1099.
Server address is displayed when servers start. Port is automatically set based on the type of connection.

## **Group Components**
- Silvia Firenze
- Filippo Gentili
- Martina Giacomelli
- Marco Giulio Grilli

