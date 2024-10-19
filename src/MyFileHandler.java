/** @file MyFileHandler.java
 *  @brief This class contains methods, to parse and returns safed data from device.
 * 
 *  @author Staacke, Felix
 * 
 *  this class discribes the type FileHandler<br/>
 *  ATTENTION: this type is not runnable!!!!<br/>
 *  <br/><br/>
 *  <div id="methodOverview" >
 *  <h1>Method Overview</h1><br/>
 *  <table style="border: 2px solid black; background-color: #ebebeb; " width="100%">
 *   <tr >
 *      <th style="border: 1px solid black; background-color: #6ec8f5;">Identity</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">visibility</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">return type</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">method name</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">note</th>
 *   </tr>
 *   <tr>
 *      <td></td>
 *      <td></td>
 *      <td></td>
 *      <td></td>
 *      <td></td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.MyFileHandler()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">none</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.MyFileHandler()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">Constructor of the class<br />Message data relation  :=   (messageType:int, messageDate:String, messageTime:String, messageContent:String, messageUserId:int, messageIsDeleted:boolean )</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseDirectChatCSV()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">ArrayList<DirectChat></td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseDirectChatCSV(path : String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of DirectChat. This DirectChat become added into the DirectChat typed Array-List. This Array List become returned.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseDirectChatMessageCSV()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">ArrayList<DirectMessage></td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseDirectChatMessageCSV(path : String, idx : int)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of DirectMessage. This DirectMessage become added into the DirectMessage typed Array-List. This Array List become returned.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseMessageCSV()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">ArrayList<Message></td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseMessageCSV(path : String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of Message. This Message become added into the Message typed Array-List. This Array List become returned.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseUserCSV()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">ArrayList<User></td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseUserCSV(path : String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of User. This User become added into the User typed Array-List. This Array List become returned.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseRoomsCSV()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">ArrayList<Room></td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseRooms(path : String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of Room. This Room become added into the Room typed Array-List. This Array List become returned.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseLogs()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">ArrayList<Log></td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseLogs(path : String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of Log. This Log become added into the Log typed Array-List. This Array List become returned.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseServerCFG()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">String[]</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseServerCFG(path : String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parses the file on divice with value of parameter path. This method copy data line per line into a string-typed-array. The string become returned.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseSitzung()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">int</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.parseSitzung(path : Path)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method parse the file on divice with value of parameter path. Than it returns the value of sitzung casted into int.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.appendToFile()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">none</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.appendToFile(path:String, content:String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method appends the value of the parameter content to the file on device with the relative path.</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.overwriteFile()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">void</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.overwriteFile(path:String, idx:int, content:String)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This is first kind of MyFileHandler.overwriteFile().</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.overwriteFile()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">void</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.overwriteFile(path:String, idx:int)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This is an overloaded alternative to MyFileHandler.overwriteFile().</td>
 *   </tr>
 *   <tr>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.overwriteSitzung()</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">public</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">none</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">MyFileHandler.overwriteSitzung(path:String, sitzung:int)</td>
 *      <td border-bottom: 2px solid black; text-postition: justify;">This method overwrite the content of the file on device with relative Path path. The old value should be replaced with value of the parameter sitzung.</td>
 *   </tr>
 * </table>
 * </div>
 **/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileHandler{
    MyFileHandler(){

    }
    
    /**@author Staacke, Felix
     * 
     * @brief This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of DirectChat. This DirectChat become added into the DirectChat typed Array-List. This Array List become returned.
     * 
     * @param path
     * @return
     */
    public ArrayList<DirectChat> parseDirectChatCSV(String path){
        ArrayList<DirectChat> dirch = new ArrayList<>();
        Path path2 = (Paths.get(path)).toAbsolutePath();
        System.out.println(path2.toString());

        try (BufferedReader br = new BufferedReader(new FileReader(path2.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
            
                String[] content = line.trim().split(";");
                
                if (content.length == 4) { // Beispiel: Wenn drei Werte in einer Zeile erwartet werden
                    String value1 = content[0].trim();  //idx
                    String value2 = content[1].trim();  //idx1
                    String value3 = content[2].trim();  //idx2
                    String value4 = content[3].trim();  //content                 
                 
                    DirectChat dir = new DirectChat(Integer.parseInt(value1), Integer.parseInt(value2), Integer.parseInt(value3), value4);
                    //System.out.println(dir.getTitle());
                    dirch.add(dir);
                } else {
                    // Fehlerbehandlung für unerwartete Anzahl von Werten in einer Zeile
                    System.err.println("Unerwartete Anzahl von Werten in der Datei 'docs/dirChat.csv': " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("====================");
        System.out.print("DirectChats := {");
        for(DirectChat chat : dirch){ 
            System.out.print("["+chat.getIdx()+"]"+ chat.getTitle()+",");
        }System.out.println("}"); 

        for(DirectChat chat : dirch){ 
            System.out.print("Messages of" + chat.getTitle()+" := {");

            for(int i=0; i<chat.getNumOfMessages(); i++){
                System.out.println("'"+chat.getMessage(i)+"'', ");
            }

            System.out.print("}\n");
        }
        
        System.out.println("}\n====================");  


        return dirch;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of DirectMessage. This DirectMessage become added into the DirectMessage typed Array-List. This Array List become returned.
     * 
     * @param path : String
     * @param idx : int
     * @return : ArrayList<DirectMessage>
     */
    public ArrayList<DirectMessage> parseDirectChatMessageCSV(String path, int idx){
        ArrayList<DirectMessage> dirch = new ArrayList<DirectMessage>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
            
                String[] content = line.trim().split(";");
                
                if (content.length == 5) { // Beispiel: Wenn drei Werte in einer Zeile erwartet werden
                    String value1 = content[0].trim();  //room
                    String value2 = content[1].trim();  //type
                    String value3 = content[2].trim();  //content
                    String value4 = content[3].trim();  //date
                    String value5 = content[4].trim();  //time                 
                 
                    //DirectMessage dir = new DirectMessage(Integer.parseInt(value1), Integer.parseInt(value2), value3, value4, value5);
                   // System.out.println(value1+ idx);
                    if(value1.equals(Integer.toString(idx))){
                        //System.out.println("hey"); 
                        dirch.add(new DirectMessage(Integer.parseInt(value1), Integer.parseInt(value2), value3, value4, value5)); 
                    }
                } else {
                    // Fehlerbehandlung für unerwartete Anzahl von Werten in einer Zeile
                    System.err.println("Unerwartete Anzahl von Werten in der Datei 'docs/dirChatMsg.csv': " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("====================");
        System.out.print("Messages := {\n");

        for(DirectMessage chat : dirch){ 
            System.out.println("["+chat.getDirectRoomIdx()+"]"+chat.getContent());
        }System.out.println("}"); 
      
        
        System.out.println("}\n====================");  

        return dirch;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of Message. This Message become added into the Message typed Array-List. This Array List become returned.
     * 
     * @param path : String
     * @param room : int
     * @return : ArrayList<Message>
     */
    public ArrayList<Message> parseMessageCSV(String path, int room){
        ArrayList<Message> messages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
            
                String[] content = line.trim().split(";");
                
                if (content.length == 7) { // Beispiel: Wenn drei Werte in einer Zeile erwartet werden
                    String value1 = content[0].trim();  //type
                    String value2 = content[1].trim();  //Date
                    String value3 = content[2].trim();  //time
                    String value4 = content[3].trim();  //content
                    String value5 = content[4].trim();  //id
                    String value6 = content[5].trim();  //isDeleted
                    String value7 = content[6].trim();  //room
                   
                    if(Integer.parseInt(value7)==room){
                        Message message = new Message(Integer.parseInt(value1), value2, value3, value4, Integer.parseInt(value5), Boolean.parseBoolean(value6));
                        messages.add(message);
                    }
                    
                } else {
                    // Fehlerbehandlung für unerwartete Anzahl von Werten in einer Zeile
                    System.err.println("Unerwartete Anzahl von Werten in Datei 'docs/messages.csv': " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return messages;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of User. This User become added into the User typed Array-List. This Array List become returned.
     * 
     * @param path : String
     * @return : ArrayList<User>
     */
    public ArrayList<User> parseUserCSV(String path){
        ArrayList<User> users = new ArrayList<>();
        //user := {userId: int, userUsername:String, userPasswordHash:String, userIsOnline:boolean, userSelectedRoom:int, userIsVerwarned:boolean,
        //          userIsKicked:boolean, userIsKickedCounter:int, userIsBanned:boolean, userRegistrationDate:String, userRegistrationTime:String,
        //          userLastLoginDate:String, userLastLoginTime:String}
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
            
                String[] content = line.trim().split(";");
                if (content.length == 13) {
                    String value1 = content[0].trim();  //userId
                    String value2 = content[1].trim();  //userUsername
                    String value3 = content[2].trim();  //userPasswordHash
                    String value4 = content[3].trim();  //userIsOnline
                    String value5 = content[4].trim();  //userSelectedRoom
                    String value6 = content[5].trim();  //userIsVerwarned
                    String value7 = content[6].trim();  //userIsKicked
                    String value8 = content[7].trim();  //userIsKickedCounter
                    String value9 = content[8].trim();  //userIsBanned
                    String value10 = content[9].trim();  //userRegistrationDate
                    String value11 = content[10].trim();  //userRegistrationTime
                    String value12 = content[11].trim();  //userLastLoginDate
                    String value13 = content[12].trim();  //userLastLoginTime
                 
                    String pw;
                    System.out.println("====================" + value3);
                    try {
                        // Versuche, value3 als Klartext-Passwort zu interpretieren und den Hash-Code zu erstellen
                        pw = Integer.toString(value3.hashCode());
                    } catch (NumberFormatException e) {
                        // Wenn eine NumberFormatException auftritt, gehe davon aus, dass value3 bereits ein gehashter Wert ist
                        pw = value3;
                        e.printStackTrace();
                    }


                    System.out.println("FIleHandler");
                    User user = new User(Integer.parseInt(value1),                          //id
                                            value2,                                         //username 
                                            Integer.parseInt(pw),                                        //password
                                            Integer.parseInt(value6)==1?true:false,     //isVerwarned
                                            Integer.parseInt(value7)==1?true:false,     //isKicked
                                            Integer.parseInt(value8),                       //isKickedCounter
                                            Integer.parseInt(value9)==1?true:false,         //isBanned
                                            value10,                                        //regDate
                                            value11);                                       //regTime
                    users.add(user);
                    System.out.println("FileHandler:"+user.getUsername()+Integer.parseInt(pw)+user.getHashedPassword());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of Room. This Room become added into the Room typed Array-List. This Array List become returned.
     * 
     * @param path : String
     * @return : ArrayList<Room>
     */
    public ArrayList<Room> parseRoomsCSV(String path){
        ArrayList<Room> rooms = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
            
                String[] content = line.trim().split(";");
                
                if (content.length == 3) { // Beispiel: Wenn drei Werte in einer Zeile erwartet werden
                    String value1 = content[0].trim();  //id
                    String value2 = content[1].trim();  //title
                    String value3 = content[2].trim();  //discribtion                 
                 
                    Room room = new Room(Integer.parseInt(value1), value2, value3);
                    rooms.add(room);
                } else {
                    // Fehlerbehandlung für unerwartete Anzahl von Werten in einer Zeile
                    System.err.println("Unerwartete Anzahl von Werten in der Datei 'rooms/rooms.csv': " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method parses the file on divice with value parameter path. This method copy data line per line. Than the data of a single line are used to generate a new instance of Log. This Log become added into the Log typed Array-List. This Array List become returned.
     * 
     * @param path : String
     * @return : ArrayList<Log>
     */
    public ArrayList<Log> parseLogs(String path){
        ArrayList<Log> logs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
            
                String[] content = line.trim().split(";");
                
                if (content.length == 5) { // Beispiel: Wenn drei Werte in einer Zeile erwartet werden
                    String value1 = content[0].trim();  //sitzung
                    String value2 = content[1].trim();  //date
                    String value3 = content[2].trim();  //time
                    String value4 = content[3].trim();  //roll
                    String value5 = content[4].trim();  //content                 
                 
                    Log log = new Log(Integer.parseInt(value1), value2, value3, Integer.parseInt(value4), value5);
                    logs.add(log);
                } else {
                    // Fehlerbehandlung für unerwartete Anzahl von Werten in einer Zeile
                    System.err.println("Unerwartete Anzahl von Werten in der Datei 'rooms/rooms.csv': " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logs;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method parses the file on divice with value of parameter path. This method copy data line per line into a string-typed-array. The string become returned.
     * 
     * @param path : String
     * @return : String[ ]
     */
    public String[] parseServerCFG(String path) {
        List<String> attributeNames = new ArrayList<>();
        List<String> attributeValues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Splitten der Zeile anhand des Gleichheitszeichens
                String[] parts = line.split("=");

                // Überprüfen, ob die Zeile das erwartete Format hat
                if (parts.length == 2) {
                    attributeNames.add(parts[0].trim());
                    attributeValues.add(parts[1].trim());
                } else {
                    // Hier kannst du Code für die Behandlung von ungültigen Zeilen einfügen
                    System.out.println("Ungültiges Format in der Zeile: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Hier kann Code für die Behandlung von IO-Fehlern eingefügt werden
        }

        // Überprüfe, ob die Listen die gleiche Länge haben
        if (attributeNames.size() != attributeValues.size()) {
            throw new IllegalStateException("Anzahl der Attribute und Werte stimmt nicht überein.");
        }

        // Erstelle das finale Ergebnis-Array
        String[] result = new String[attributeNames.size() * 2];
        for (int i = 0; i < attributeNames.size(); i++) {
            result[i * 2] = attributeNames.get(i);
            result[i * 2 + 1] = attributeValues.get(i);
        }

        return result;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method parse the file on divice with value of parameter path. Than it returns the value of sitzung casted into int.
     * 
     * @param path : String
     * @return : int
     */
    public int parseSitzung(Path path) {
        int result = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
            String line;

            while ((line = reader.readLine()) != null) {
                result = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Hier kann Code für die Behandlung von IO-Fehlern eingefügt werden
        }        

        return result;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method appends the value of the parameter content to the file on device with the relative path.
     * 
     * @param path : String
     * @param content : String
     */
    public void appendToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(((Paths.get(path)).toAbsolutePath()).toString(), true))) {
            writer.write(content);
            writer.newLine(); // Füge eine neue Zeile hinzu
            //System.out.println("Inhalt erfolgreich zur Datei hinzugefügt.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: "+path + e.getMessage());
        }
    }
   
    /**@author the other student
     * 
     * @param path : String
     * @param idx : int
     * @param content : String
     */
    public void overwriteFile(String path, int idx, String content) {
        List<String> lines = new ArrayList<>();

        // Schritt 1: Datei auslesen und in ArrayList speichern
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: "+path + e.getMessage());
            return;
        }

        // Schritt 2: Dateiinhalt löschen
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            // Schreibe bis zur Zeile idx in die Datei
            for (int i = 0; i < idx && i < lines.size(); i++) {
                writer.println(lines.get(i));
            }

            // Schreibe den neuen Inhalt in die Datei
            writer.println(content);

            // Schreibe die verbleibenden Zeilen nach der Zeile idx in die Datei
            for (int i = idx + 1; i < lines.size(); i++) {
                writer.println(lines.get(i));
            }

            //System.out.println("Datei erfolgreich überschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }

    /**@author the other student
     * 
     * @brief This is an overloaded alternative to MyFileHandler.overwriteFile(). 
     * 
     * @param path : String
     * @param idx : int
     */
    public void overwriteFile(String path, int idx) {
        List<String> lines = new ArrayList<>();
    
        // Schritt 1: Datei auslesen und in ArrayList speichern
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: "+path + e.getMessage());
            return;
        }
    
        // Schritt 2: Dateiinhalt löschen und bis zur Zeile idx in die Datei schreiben
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < idx; i++) {
                writer.println(lines.get(i));
            }
    
            // Schreibe die verbleibenden Zeilen nach der Zeile idx in die Datei
            for (int i = idx + 1; i < lines.size(); i++) {
                writer.println(lines.get(i));
            }
    
            //System.out.println("Datei erfolgreich überschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: "+path + e.getMessage());
        }
    }

    /**@author Staacke, Felix
     * 
     * @brief This method overwrite the content of the file on device with relative Path path. The old value should be replaced with value of the parameter sitzung.
     * 
     * @param path : String
     * @param sitzung : int 
     */
    public void overwriteSitzung(String path, int sitzung) {       
    
        // Schritt 2: Dateiinhalt löschen und bis zur Zeile idx in die Datei schreiben
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            
                writer.println(sitzung);
            
    
    
            //System.out.println("Datei erfolgreich überschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }
    
    
}