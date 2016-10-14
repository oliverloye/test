
package dungeon;

import java.util.Scanner;


public class Dungeon {
    
    private Player player1;
    private Room current;
    
    
    public void welcome() {
        System.out.println("Hi and welcome to TextAdventure");
    }
    
    public void gameLoop() {
        //TEST----------------------------------------------
        System.out.println("----------LOADING...-----------");
        
        //TEST----------------------------------------------
        
        boolean play = true;
        String answer = "";
        System.out.println(current.getDiscription());
        
        
        Scanner scan = new Scanner(System.in);
        
        while(play) {
            
            answer = scan.nextLine();
                if(answer.equalsIgnoreCase("help")) {
                    getHelp();
                }
                else if(answer.equalsIgnoreCase("hint")) {
                    System.out.println(current.getHint());
                }
                else if(answer.equalsIgnoreCase("wear")) {
                    if(current.getRoomNumber() == 1) {
                        player1.setWearSuit(true);
                        System.out.println("The suit is now equiped!");
                    } else System.out.println("There is nothing to wear");
                }
                else if(answer.equalsIgnoreCase("north")) {
                    goNorth();
                    checkChangingRoom();
                }
                else if(answer.equalsIgnoreCase("east")) {
                    goEast();
                    checkChangingRoom();
                }
                else if(answer.equalsIgnoreCase("south")) {
                    goSouth();
                    checkChangingRoom();
                }
                else if(answer.equalsIgnoreCase("west")) {
                    goWest();
                    checkChangingRoom();
                }
                else if(answer.equalsIgnoreCase("quit")) {
                    play = false;
                }
        }
    }
    
    public void createDungeon() {
        //Opretter objekter:
        Room loadingBay = new Room(1, 0, "LoadingBay", "Hint: r0");
        Room changingRoom = new Room(4, 1, "ChangingRoom", "Hint: r1");
        Room dumbLoud1 = new Room(2, 2, "dumbLoud1", "Hint: r2");
        Room dumbLoud2 = new Room(2, 3, "dumbLoud2", "Hint: r0");
        Room dumbLoud3 = new Room(2, 4, "dumbLoud3", "Hint: r0");
        Room dumbLoud4 = new Room(2, 5, "dumbLoud4", "Hint: r0");
        Room dumbLoud5 = new Room(1, 6, "dumbLoud5", "Hint: r0");
        Room ingenuitySmart1 = new Room(3, 7, "ingenuitySmart1", "Hint: r0");
        Room ingenuitySmart2 = new Room(2, 8, "ingenuitySmart2", "Hint: r0");
        Room ingenuitySmart3 = new Room(2, 9, "ingenuitySmart3", "Hint: r0");
        Room ingenuitySmart4 = new Room(3, 10, "ingenuitySmart4", "Hint: r0");
        Room ingenuitySmart5 = new Room(2, 11, "ingenuitySmart5", "Hint: r0");
        Room ingenuitySmart6 = new Room(1, 12, "ingenuitySmart6", "Hint: r0");
        Room straightBland1 = new Room(2, 13, "straightBland1", "Hint: r0");
        Room straightBland2 = new Room(3, 14, "straightBland2", "Hint: r0");
        Room straightBland3 = new Room(2, 15, "straightBland3", "Hint: r0");
        Room straightBland4 = new Room(2, 16, "straightBland4", "Hint: r0");
        Room straightBland5 = new Room(3, 17, "straightBland5", "Hint: r0");
        Room straightBland6 = new Room(2, 18, "straightBland6", "Hint: r0");
        Room straightBland7 = new Room(2, 19, "straightBland7", "Hint: r0");
        Room straightBland8 = new Room(1, 20, "straightBland8", "Hint: r0");
        
        //Sætter alle referencer
        loadingBay.north = changingRoom;
        
        changingRoom.south = loadingBay;
        changingRoom.north = straightBland1;
        changingRoom.east = ingenuitySmart1;
        changingRoom.west = dumbLoud1;
        
        dumbLoud1.east = changingRoom;
        dumbLoud1.north = dumbLoud2;
        
        dumbLoud2.south = dumbLoud1;
        dumbLoud2.west = dumbLoud3;
        
        dumbLoud3.east = dumbLoud2;
        dumbLoud3.west = dumbLoud4;
        
        dumbLoud4.east = dumbLoud3;
        dumbLoud4.south = dumbLoud5;
        
        dumbLoud5.north = dumbLoud4;
        
        ingenuitySmart1.west = changingRoom;
        ingenuitySmart1.north = ingenuitySmart3;
        ingenuitySmart1.east = ingenuitySmart2;
        
        ingenuitySmart2.west = ingenuitySmart1;
        ingenuitySmart2.north = ingenuitySmart4;
        
        ingenuitySmart3.south = ingenuitySmart1;
        ingenuitySmart3.east = ingenuitySmart4;
        
        ingenuitySmart4.east = ingenuitySmart3;
        ingenuitySmart4.south = ingenuitySmart2;
        ingenuitySmart4.north = ingenuitySmart5;
        
        ingenuitySmart5.south = ingenuitySmart4;
        ingenuitySmart5.east = ingenuitySmart6;
        
        ingenuitySmart6.west = ingenuitySmart5;
        
        straightBland1.south = changingRoom;
        straightBland1.north = straightBland2;
        
        straightBland2.south = straightBland1;
        straightBland2.west = straightBland4;
        straightBland2.north = straightBland3;
        
        straightBland3.south = straightBland2;
        straightBland3.west = straightBland5;
        
        straightBland4.east = straightBland2;
        straightBland4.north = straightBland5;
        
        straightBland5.east = straightBland3;
        straightBland5.south = straightBland4;
        straightBland5.west = straightBland6;
        
        straightBland6.east = straightBland5;
        straightBland6.north = straightBland7;
        
        straightBland7.south = straightBland6;
        straightBland7.north = straightBland8;
        
        straightBland8.south = straightBland7;
        
        //Afslutter med at sætte current til at pege på "starting room":
        current = loadingBay;
    }
    
    public void getHelp() {
        System.out.println("Commands:");
        System.out.println("\"North\"");
        System.out.println("\"East\"");
        System.out.println("\"South\"");
        System.out.println("\"West\"");
        System.out.println("\"Quit\"");
        //System.out.println("\"Gold\"");
        //System.out.println("\"Move\"");
        //System.out.println("\"Use\"");
        //System.out.println("\"Loot\"");
        //System.out.println("\"Equip\"");
        System.out.println("\"Wear\"");
        //System.out.println("\"Run\"");
    }
    
    public void goNorth() {
        if(!(current.north == null)) {
        current = current.north;
        System.out.println(current.getDiscription());
        } else System.out.println("There is no door in that direction!");
    }
    
    public void goSouth() {
        if(!(current.south == null)) {
        current = current.south;
        System.out.println(current.getDiscription());
        } else System.out.println("There is no door in that direction!");
    }
    
    public void goEast() {
        if(!(current.east == null)) {
        current = current.east;
        System.out.println(current.getDiscription());
        } else System.out.println("There is no door in that direction!");
    }
    
    public void goWest() {
        if(!(current.west == null)) {
        current = current.west;
        System.out.println(current.getDiscription());
        } else System.out.println("There is no door in that direction!");
    }
    
    
//    public String printCurrent() {
//         //ændre til sout
//         
//         return current.toString();
//    }
    
    public void createPlayer() {
        
        System.out.println("What is your name?");
        
        player1 = new Player();
        System.out.println("Hi " + player1.getName() + "!");
        
        
    }

    private void checkChangingRoom() {
        if(current.getRoomNumber() > 1) {
            if(!player1.isWearSuit()) {
                System.out.println("GAME OVER!");
                System.exit(0);
            }   
        }
    }
}
