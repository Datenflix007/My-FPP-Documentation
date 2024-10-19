/**@file Client.java
 * 
 * @author Staacke, Felix
 * 
 * @brief This is the excecutable class Client. This class contains a thread to send data to the server, and one thead to receive data from server.
 * 
 * @todo reimplement class Framework. 
 */

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

public class Client{
    //connection
        private Socket              socket;
        private DataOutputStream    dos;
        private DataInputStream     dis;
        private ObjectOutputStream  oos;    //TODO: if not used, delete it later

    //copied data => will contain a copied datastructure by server
        private ArrayList<Room>     rooms;
        private ArrayList<User>     users;
        private ArrayList<DirectChat> directs;

    // main Frame
        private JFrame              mainFrame;
        private String              mainFrameTitle;
        private Border              mainFrameBorder;
        private JMenu               mainFrameMenu;
        private JMenuBar            mainFrameMenuBar;
        private JMenuItem           mainFrameMenuItem_QUIT;

    //application data
        private boolean             clientRun;
        /** <h1>Position blueprint for protocoll</h1>
         * 
         * <table>
         *      <tr>
         *          <th>Pos.</th>
         *          <th>Variable</th>
         *          <th>Datatype</th>
         *      </tr>
         *      <tr>
         *          <td>0</td>
         *          <td>out_message_type</td>
         *          <td>int</td>
         *      </tr>
         *      <tr>
         *          <td>1</td>
         *          <td>out_message_content</td>
         *          <td>String</td>
         *      </tr>
         *      <tr>
         *          <td>2</td>
         *          <td>out_message_time</td>
         *          <td>String</td>
         *      </tr>
         *      <tr>
         *          <td>3</td>
         *          <td>out_message_id</td>
         *          <td>int</td>
         *      </tr>
         *      <tr>
         *          <td>4</td>
         *          <td>out_room_selected</td>
         *          <td>int</td>
         *      </tr>
         *      <tr>
         *          <td>5</td>
         *          <td>out_room_newRoom</td>
         *          <td>boolean</td>
         *      </tr>
         *      <tr>
         *          <td>6</td>
         *          <td>out_room_delRoom<br/>=> if out_room_selected doesn't equal -1 and 
         *          out_room_delRoom equals true than delete
         *          the selected room</td>
         *          <td>boolean</td>
         *      </tr>
         * 
         * </table
         *  
         */
        private Object[] protocoll;
        private boolean update;
        private boolean send;
        private int selectedRoom;
        private int ownId;

    /**@author Staacke, Felix
     * 
     * @brief This method initialise the class vars.
     * 
     */
    public void initialize(){
        try{
            //TODO: parse data files later
            this.clientRun      = true;
            this.socket         = new Socket("localhost", 3141);
            this.dos            = new DataOutputStream(this.socket.getOutputStream());
            this.dis            = new DataInputStream(this.socket.getInputStream());
            //this.oos = new ObjectOutputStream(dos);   //this will interrupt the process
            this.protocoll      = new Object[7];
            rooms = new ArrayList<Room>();
            this.update = true;
            this.send = true;
            


                } catch(Exception e){
                    e.printStackTrace();
                }
    }

    /**@author Staacke, Felix   
     * 
     * @brief This method returns the current date and time as string format.
     * 
     * @return
     */
    public String getDateTime(){
         // Aktuelle Zeit abrufen
        LocalDateTime jetzt = LocalDateTime.now();

        // Gewünschtes Format definieren
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");

        // Zeit in das gewünschte Format konvertieren und ausgeben
        String formatierteZeit = jetzt.format(formatter);


        return formatierteZeit;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method spawns the Window and starts the Threads in lambda expression.
     * 
     */
    public void run(){
        try{
            //login JFrame
                JFrame loginFrame = new JFrame("LOGIN");
                loginFrame.setSize(100, 300);
                JPanel panel = new JPanel();

                panel.add(new JLabel("<html><table><tr><td>Benutzername:</td><td></html>"));
                JTextField tf1 = new JTextField();
                tf1.setText("Benutzername");
                panel.add(tf1);

                panel.add(new JLabel("<html></td></tr><tr><td>Passwort:</td><td></html>"));
                JPasswordField tf2 = new JPasswordField();
                tf2.setText("Password");
                panel.add(tf2);
                panel.add(new JLabel("<html></td></tr><table></html>"));

                JButton submit = new JButton("VERBINDEN");
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        try{
                            dos.writeUTF(tf1.getText());   //username
                            dos.flush();

                            char[] passwordChars = tf2.getPassword();
                            String password = new String(passwordChars);

                            dos.writeUTF(password);           //password
                            dos.flush();

                            //mainFrame
                                
                            
            //loginFrame.setVisible(false);
                            update = true;

                            //if username and password are regisered => login => otherwise will become registered

                            Thread t1 = new Thread(()->serverListener());
                            Thread t2 = new Thread(()->serverWriter());
                            t1.start();
                            t2.start();
                             update = true;
                            Thread t3 = new Thread(()->Framework());
                            t3.start();

                            loginFrame.setVisible(false);
                            

                        } catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });
               
                panel.add(submit);
                loginFrame.add(panel);
                loginFrame.setVisible(true);
            

            
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**@author Staacke, Felix
     * 
     * @brief This method returns the current date in String format. 
     * 
     * @return
     */
    public String getDate(){
        // Aktuelle Zeit abrufen
       LocalDateTime jetzt = LocalDateTime.now();

       // Gewünschtes Format definieren
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

       // Zeit in das gewünschte Format konvertieren und ausgeben
       String formatierteZeit = jetzt.format(formatter);


       return formatierteZeit;
   }

   /**@author the other student
    * 
    * @brief This method returns the current time in String format.
    * 
    * @return
    */
    public String getTime(){
        // Aktuelle Zeit abrufen
       LocalDateTime jetzt = LocalDateTime.now();

       // Gewünschtes Format definieren
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

       // Zeit in das gewünschte Format konvertieren und ausgeben
       String formatierteZeit = jetzt.format(formatter);


       return formatierteZeit;
   }

    /**@author Staacke, Felix
     * 
     * @brief This method should send a file to server. Actually it doesn't work.
     * 
     * @todo finish this implementation. Than implement a file receiving result at the server side.
     * 
     * @param file
     */
    private void sendFileToServer(File file) {
    try {
        

        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = socket.getOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        fileInputStream.close();
        outputStream.close();


        System.out.println("Datei erfolgreich an Server gesendet.");

    } catch (Exception e) { e.printStackTrace();       
    }

}
   
    /**@author Staacke, Felix 
     * 
     * @brief This method gets the file extension of a file with the relative path.
     * 
     * @param fileName : String
     * @return : String
     */
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1);
        } else {
            return "";
        }
    }

    /**@author Staacke, Felix
     * 
     * @brief This method handels the GUI.
     * 
     * @todo: Definitly reimplement this method. 
     * 
     */
    public void Framework() {
        try {
            String mainFrameTitle = "Chat-Client";
            mainFrame = new JFrame(mainFrameTitle);
            mainFrame.setBounds(500, 0, 900, 700);
            //mainFrame.setLayout(null);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainFrameMenuBar = new JMenuBar();
            mainFrameMenu = new JMenu("Anwendung");
            mainFrameMenuItem_QUIT = new JMenuItem("BEENDEN");

            mainFrameMenuItem_QUIT.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Beenden!");
                    System.exit(0);
                }
            });

            mainFrameMenu.add(mainFrameMenuItem_QUIT);
            mainFrameMenuBar.add(mainFrameMenu);
            mainFrame.setJMenuBar(mainFrameMenuBar);

            JPanel content = new JPanel(new GridLayout(0,3));

            JPanel panel_rooms = new JPanel(new GridLayout(0, 1)); // Verwende GridLayout mit einer Spalte (mehrere Zeilen)

            JPanel panel_messages = new JPanel();
            panel_messages.setLayout(new BoxLayout(panel_messages, BoxLayout.Y_AXIS));

            JPanel panel_users = new JPanel();
            panel_users.setLayout(new BoxLayout(panel_users, BoxLayout.Y_AXIS));

            JFrame sendContent = new JFrame("Nachricht senden");
            sendContent.setBounds(500, 700, 900, 100);
            sendContent.setVisible(true);
            JPanel sendContentPanel = new JPanel();
            sendContentPanel.setLayout(new GridLayout(3,0));


            mainFrame.setVisible(true);

            while (clientRun) {
                if (update) {


                        if(selectedRoom != -1){
                            sendContentPanel.removeAll();




                            JButton chooseFileButton = new JButton("Datei auswählen");

                            chooseFileButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFileChooser fileChooser = new JFileChooser();

                                    // Setze einen Dateifilter, falls gewünscht (optional)
                                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Dateien", "png");
                                    fileChooser.setFileFilter(filter);

                                    // Zeige den Dialog zum Öffnen einer Datei an
                                    int result = fileChooser.showOpenDialog(null);

                                    // Überprüfe, ob der Benutzer eine Datei ausgewählt hat
                                    if (result == JFileChooser.APPROVE_OPTION) {
                                        // Erhalte die ausgewählte Datei als File-Objekt
                                        File selectedFile = fileChooser.getSelectedFile();

                                        // Schließe das JFrame nach der Auswahl
                                        

                                        // Sende die ausgewählte Datei an den Server
                                        sendFileToServer(selectedFile);
                                    } else {
                                        System.out.println("Keine Datei ausgewählt.");
                                    }
                                }
                            });
                            JTextField messageText = new JTextField();
                            messageText.addKeyListener(new KeyListener() {
                                @Override
                                        public void keyTyped(KeyEvent e){}
                                        @Override
                                        public void keyReleased(KeyEvent e){} 
                                        @Override
                                        public void keyPressed(KeyEvent e){
                                            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                                                Object[] prot = new Object[10];
                                                prot[0] = false;
                                                prot[1] = false;
                                                prot[2] = false;
                                                prot[3] = -1;
                                                prot[4] = selectedRoom;
                                                prot[5] = messageText.getText();
                                                prot[6] = "";
                                                prot[7] = getDate();
                                                prot[8] = getTime();
                                                prot[9] = ownId;
                                                setProcoll(prot);

                                                rooms.get(selectedRoom).addMessage(new Message(0, getDate(), getTime(), messageText.getText(), ownId, false));
                                                send=true;                                                
                                                update=true;
                                            }
                                        }
                            });

                            JButton sendIt = new JButton("ABSENDEN");
                            sendIt.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae){
                                    Object[] prot = new Object[10];
                                                prot[0] = false;
                                                prot[1] = false;
                                                prot[2] = false;
                                                prot[3] = -1;
                                                prot[4] = selectedRoom;
                                                prot[5] = messageText.getText();
                                                prot[6] = "";
                                                prot[7] = getDate();
                                                prot[8] = getTime();
                                                prot[9] = ownId;
                                                setProcoll(prot);

                                                rooms.get(selectedRoom).addMessage(new Message(0, getDate(), getTime(), messageText.getText(), ownId, false));
                                                send=true;                                                
                                                update=true;
                                                
                                }
                            });

                            sendContentPanel.add(chooseFileButton);
                            sendContentPanel.add(messageText);
                            sendContentPanel.add(sendIt);
                            sendContent.add(sendContentPanel);
                          
                            sendContent.setVisible(true);
                        } else{ sendContent.setVisible(false);}






                        JPanel panel = new JPanel();
                    
                    
                        
                    if (rooms != null) {
                        content.removeAll();
                        panel_rooms.removeAll();
                        panel_messages.removeAll();
                        panel_users.removeAll();

                        
                        JButton newButton = new JButton("Neuer Raum");
                        newButton.setPreferredSize(new Dimension(200, 50));

                        newButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae){
                                JFrame newRoom = new JFrame("Neuer Raum");
                                JPanel panel = new JPanel();
                                panel.setLayout(new GridLayout(3,0));

                                panel.add(new JLabel("Raumname"));

                                JTextField text = new JTextField();
                                text.addKeyListener(new KeyListener() {
                                    @Override
                                    public void keyTyped(KeyEvent e){}
                                    @Override
                                    public void keyReleased(KeyEvent e){} 
                                    @Override
                                    public void keyPressed(KeyEvent e){
                                        if(e.getKeyCode() == KeyEvent.VK_ENTER){
                                            Object[] prot = new Object[10];
                                            prot[0] = true;
                                            prot[1] = false;
                                            prot[2] = false;
                                            prot[3] = -1;
                                            prot[4] = -1;
                                            prot[5] = text.getText();
                                            prot[6] = "";
                                            prot[7] = "";
                                            prot[8] = "";
                                            prot[9] = ownId;
                                            setProcoll(prot);
                                            update = true;
                                            send = true;
                                            System.out.println(text.getText());
                                            newRoom.setVisible(false);
                                        }
                                    }
                                });

                                JButton button = new JButton();
                                button.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae){
                                        Object[] prot = new Object[10];
                                            prot[0] = true;
                                            prot[1] = false;
                                            prot[2] = false;
                                            prot[3] = -1;
                                            prot[4] = -1;
                                            prot[5] = text.getText();
                                            prot[6] = "";
                                            prot[7] = "";
                                            prot[8] = "";
                                            prot[9] = ownId;
                                            setProcoll(prot);
                                        update = true;
                                        send = true;
                                        System.out.println(text.getText());
                                        newRoom.setVisible(false);
                                    }
                                });
                               
                                panel.add(text);
                                panel.add(button);
                                newRoom.add(panel);

                                newRoom.setSize(200, 100);
                                newRoom.setVisible(true);

                                //protocoll[1] = 
                                //protocoll[5]
                            }
                        });

                        panel.add(newButton);
                        
                        for (int i = 0; i < this.rooms.size(); i++) {
                            final int k = i;
                            JButton roomButton = new JButton(this.rooms.get(i).getTitle());
                            roomButton.setPreferredSize(new Dimension(200, 50));
                            roomButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    if (selectedRoom == k) {
                                        selectedRoom = -1;
                                        protocoll[4] = selectedRoom;
                                        
                                    } else {
                                        selectedRoom = k;
                                        protocoll[4] = selectedRoom;

                                        JFrame roomFrame = new JFrame();
                                        roomFrame.setSize(new Dimension(300,300));

                                        JPanel content = new JPanel();

                                        JTextField newRoomTitle = new JTextField("Neuer Raumname");
                                        newRoomTitle.addKeyListener(new KeyListener() {
                                            @Override
                                            public void keyPressed(KeyEvent e) {
                                                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                                                    Object[] prot = new Object[10];
                                                    prot[0] = true;
                                                    prot[1] = true;
                                                    prot[2] = false;
                                                    prot[3] = -1;
                                                    prot[4] = selectedRoom;
                                                    prot[5] = newRoomTitle.getText();
                                                    prot[6] = "";
                                                    prot[7] = "";
                                                    prot[8] = "";
                                                    prot[9] = ownId;
                                                    setProcoll(prot);

                                                    send=true;
                                                    rooms.get(selectedRoom).setTitle(newRoomTitle.getText());
                                                    update=true;
                                                    roomFrame.setVisible(false);
                                                }
                                            }
                                            @Override
                                            public void keyReleased(KeyEvent e) {
                                                // TODO Auto-generated method stub
                                                
                                            }
                                            @Override
                                            public void keyTyped(KeyEvent e) {
                                                // TODO Auto-generated method stub
                                                
                                            }
                                        });
                                        JButton submit = new JButton("UMBENENNEN");
                                        submit.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                Object[] prot = new Object[10];
                                                prot[0] = true;
                                                prot[1] = true;
                                                prot[2] = false;
                                                prot[3] = -1;
                                                prot[4] = selectedRoom;
                                                prot[5] = newRoomTitle.getText();
                                                prot[6] = "";
                                                prot[7] = "";
                                                prot[8] = "";
                                                prot[9] = ownId;
                                                setProcoll(prot);

                                                send=true;
                                                rooms.get(selectedRoom).setTitle(newRoomTitle.getText());
                                                update=true;
                                                roomFrame.setVisible(false);
                                            }
                                        });


                                        JButton delete = new JButton("LÖSCHEN");
                                        delete.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                Object[] prot = new Object[10];
                                                prot[0] = false;
                                                prot[1] = true;
                                                prot[2] = false;
                                                prot[3] = -1;
                                                prot[4] = selectedRoom;
                                                prot[5] = "";
                                                prot[6] = "";
                                                prot[7] = "";
                                                prot[8] = "";
                                                prot[9] = ownId;
                                                setProcoll(prot);

                                                send=true;
                                                update=true;
                                                roomFrame.setVisible(false);
                                            }
                                        });

                                        content.add(newRoomTitle);
                                        content.add(submit);
                                        content.add(delete);
                                        roomFrame.add(content);
                                        roomFrame.setVisible(true);



                                    }
                                    
                                    update = true;
                                    send = true;
                                }
                            });
                            panel.add(roomButton);
                        }
                       
                        if (selectedRoom != -1 && selectedRoom < rooms.size()) {
                            panel_messages.add(new JLabel("<html><h3>Nachrichten</h3></html>"));    
                            Room selectedRoomObj = rooms.get(selectedRoom);

                            panel_messages.add(new JLabel("<html><table></html>"));
                            if (selectedRoomObj.getNumOfMessages() > 0) {
                                for (int i = 0; i < selectedRoomObj.getNumOfMessages(); i++) {
                                    panel_messages.add(new JLabel("<html><tr><td></html>"
                                            + selectedRoomObj.getMessage(i).getMessageDate()
                                            + "<html></td><td></html>"
                                            + (selectedRoomObj.getNumOfMessages()>i ? users.get(selectedRoomObj.getMessage(i).getMessageUserId()).getUsername() : "non")
                                            + "<html></td><td></html>"
                                            + selectedRoomObj.getMessage(i).getMessageContent()
                                            + "<html></td></tr></html>"));
                                }
                                panel_messages.add(new JLabel("<html></table></html>"));
                            }
                        }
                    }

                    if(users!=null){
                        

                        if(selectedRoom == -1){
                            panel_users.add(new JLabel("<html><h3>Online Benutzer</h3></html>"));

                            for(int i=0; i<users.size(); i++){
                                final int k =i;
                                if(users.get(i).getIsOnline()==true && users.get(i).getIsBanned()==false){
                                    JLabel userLabel = new JLabel(users.get(i).getUsername());
                                    userLabel.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            showDirectMessages(k, users.get(ownId).getUsername()+"-"+users.get(k).getUsername());
                                        }
                                        @Override
                                        public void mouseEntered(MouseEvent e) { }
                                        @Override
                                        public void mouseExited(MouseEvent e) { }
                                        @Override
                                        public void mousePressed(MouseEvent e) { }
                                        @Override
                                        public void mouseReleased(MouseEvent e) {}
                                    });
                                    
                                    panel_users.add(userLabel);
                                }
                            }

                            panel_users.add(new JLabel("<html><h3>Offline Benutzer</h3></html>"));

                            for(int i=0; i<users.size(); i++){
                                final int k = i;
                                //System.out.println("K:="+k);
                                if(users.get(i).getIsOnline()==false && users.get(i).getIsBanned()==false){
                                    JLabel userLabel = new JLabel(users.get(i).getUsername());
                                    userLabel.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            System.out.println("K:="+k);
                                            showDirectMessages(k, users.get(ownId).getUsername()+"-"+users.get(k).getUsername());
                                        }
                                        @Override
                                        public void mouseEntered(MouseEvent e) { }
                                        @Override
                                        public void mouseExited(MouseEvent e) { }
                                        @Override
                                        public void mousePressed(MouseEvent e) {}
                                        @Override
                                        public void mouseReleased(MouseEvent e) {}
                                    });
                                    
                                    panel_users.add(userLabel);
                                }
                            }
                        } else{
                            panel_users.add(new JLabel("<html><h3>In diesem Raum</h3></html>"));

                            for(int i=0; i<users.size(); i++){
                                final int k= i;
                                if(users.get(i).getIsOnline()==true && users.get(i).getIsBanned()==false && selectedRoom!=users.get(i).getUserSeletedRoom()){
                                    JLabel userLabel = new JLabel(users.get(i).getUsername());
                                    userLabel.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            showDirectMessages(k, users.get(ownId).getUsername()+"-"+users.get(k).getUsername());
                                        }
                                        @Override
                                        public void mouseEntered(MouseEvent e) { }
                                        @Override
                                        public void mouseExited(MouseEvent e) { }
                                        @Override
                                        public void mousePressed(MouseEvent e) {}
                                        @Override
                                        public void mouseReleased(MouseEvent e) {}
                                    });
                                    
                                    panel_users.add(userLabel);
                                }
                            }

                            panel_users.add(new JLabel("<html><h3>Im anderen Raum</h3></html>"));

                            for (int i = 0; i < users.size(); i++) {
                                final int currentUserIndex = i; // Store the current user's index
                            
                                if (users.get(i).getIsOnline() && !users.get(i).getIsBanned() && selectedRoom == users.get(i).getUserSeletedRoom()) {
                                    JLabel userLabel = new JLabel(users.get(i).getUsername());
                                    userLabel.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                        
                                            showDirectMessages(currentUserIndex, users.get(ownId).getUsername() + "-" + users.get(currentUserIndex).getUsername());
                                        }
                            
                                        @Override
                                        public void mouseEntered(MouseEvent e) { }
                            
                                        @Override
                                        public void mouseExited(MouseEvent e) { }
                            
                                        @Override
                                        public void mousePressed(MouseEvent e) {}
                            
                                        @Override
                                        public void mouseReleased(MouseEvent e) {}
                                    });
                            
                                    panel_users.add(userLabel);
                                }
                            }

                            panel_users.add(new JLabel("<html><h3>Offline</h3></html>"));

                            for(int i=0; i<users.size(); i++){
                                final int k = i;
                                if(users.get(i).getIsOnline()==false && users.get(i).getIsBanned()==false){
                                    JLabel userLabel = new JLabel(users.get(i).getUsername());
                                    userLabel.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            showDirectMessages(k, users.get(ownId).getUsername()+"-"+users.get(k).getUsername());
                                        }
                                        @Override
                                        public void mouseEntered(MouseEvent e) { }
                                        @Override
                                        public void mouseExited(MouseEvent e) { }
                                        @Override
                                        public void mousePressed(MouseEvent e) {}
                                        @Override
                                        public void mouseReleased(MouseEvent e) {}
                                    });
                                    
                                    panel_users.add(userLabel);
                                }
                            }
                        }
                        

                    }
              

                    mainFrame.getContentPane().removeAll();
                    panel_rooms.add(panel);
                    content.add(panel_rooms);
                    JScrollPane scrollPane = new JScrollPane(panel_messages);
                    scrollPane.setPreferredSize(new Dimension(400, 400));
                    
                    content.add(scrollPane);
                    content.add(panel_users);
                    mainFrame.getContentPane().add(content);
                    mainFrame.revalidate();
                    mainFrame.repaint();

                    update = false;
                }

                Thread.sleep(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**@author Staacke, Felix
     * 
     * @brief This method spawns a window to show the directChatMessages.
     * 
     * @param userId
     * @param content
     */
    public void showDirectMessages(int userId, String content){
        System.out.println("\n\nuebergebene ID : "+userId);
        for(int i=0; i<users.size(); i++){
            System.out.println("["+i+"]->"+users.get(i).getUsername());
        }
        int dirId = -1;
        
        for(int k=0; k<this.directs.size(); k++){
            if(this.directs.get(k).getIsCorrectChat(ownId, userId)==true){
                //System.out.println("MEINE ID ="+ownId+" andere ID="+userId + this.directs.get(k).getTitle());
                dirId = k;
                
                System.out.println(dirId+","+this.directs.get(dirId).getMessage(0).getContent());
                
            }
          
        }

        if(dirId == -1){
            this.directs.add(new DirectChat(directs.size()+1, ownId, userId, users.get(ownId).getUsername()+"-"+users.get(userId).getUsername()));
            Object[] prot = new Object[10];
            prot[0] = false;
            prot[1] = false;
            prot[2] = true;
            prot[3] = userId;
            prot[4] = "";
            prot[5] = content;
            prot[6] = "";
            prot[7] = getDate();
            prot[8] = getTime();
            prot[9] = ownId;
            setProcoll(prot);
        } else{
        JFrame dirMsg = new JFrame();
        JPanel panel = new JPanel();

        System.out.println("==========STARTING ADDING DIRECT MESSAGES OF "+userId+"============");
        System.out.print("Messages := {");
        for(int i=0; i<directs.get(userId).getNumOfMessages();i++){
            panel.add(new JLabel(directs.get(userId).getMessage(i).getContent()));
            System.out.print(directs.get(userId).getMessage(i).getContent()+(i<directs.get(userId).getNumOfMessages()-1?",":"}\n"));
                
                
            

        }

        System.out.println("}\n=========ENDING ADDING DIRECT MESSAGES of "+userId+"============");

        //JScrollPane scroll = new JScrollPane(panel);
        
        dirMsg.setSize(new Dimension(300,300));
        dirMsg.add(panel);
        dirMsg.setVisible(true);
        
    }
    }

    /**@author Staacke, Felix 
     * 
     * @brief This methods sets the value initialising of the protocoll data.
     * 
     * @param args : Object[ ]
     */
    public void setProcoll(Object[] args){
        
        if(this.protocoll.length==args.length){
            System.out.print("Setze Protocoll := {");
            for(int i=0; i<this.protocoll.length;i++){
                this.protocoll[i] = args[i];
                System.out.print(args[i]);
            }
            System.out.print("}.\n");
        } else{
            System.out.println("ERROR: Protocoll kann nicht auf Werte gesetzt werden.");
        }
    }

    /**@author Staacke, Felix
     * 
     * @brief This methods handels the sending to the server.     * 
     */
    public  void serverWriter() {
        int k = 0;
        try{
            System.out.println(socket.getInetAddress()+":"+socket.getPort());
            
            //protocoll values => TODO: analysis 
             this.protocoll = new Object[10];
            
            //this.update = true; //testcase
          
            while(clientRun){
              
                //TODO: implement a message input GUI
                if(send == true){
                    System.out.println(this.protocoll[3]);
                   for(int i=0; i<this.protocoll.length; i++){
                        if(this.protocoll[i] instanceof Integer){
                            dos.writeInt((int) this.protocoll[i]);
                        } else if(this.protocoll[i] instanceof String){
                            dos.writeUTF((String) this.protocoll[i]);
                        } else if(this.protocoll[i] instanceof Boolean){
                            dos.writeBoolean((boolean) this.protocoll[i]);
                        }
                   }

                    this.protocoll[0] = Boolean.TRUE; 
                    this.protocoll[1] = Boolean.TRUE; 
                    this.protocoll[2] = Boolean.TRUE; 
                    this.protocoll[3] = -1; 
                    this.protocoll[4] = -1; 
                    this.protocoll[5] = ""; 
                    this.protocoll[6] = "";
                    this.protocoll[7] = "";
                    this.protocoll[8] = "";
                    this.protocoll[9] = -1; 


                   this.send = false;

                }

                

                //System.out.println(k);
                k++;
                Thread.sleep(500);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /** @author Staacke, Felix
     * 
     *  @brief This method handels the data receiving.
     * 
     * <h1>protocoll</h1> 
     * 
     *  <table>
     *      <tr>
     *          <th>Pos.</th>
     *          <th>Operation</th>
     *      </tr>
     *      <tr>
     *          <td>(1)</td>
     *          <td>Thread blueprint for lambda: ()->serverListener()</td>
     *      </tr>
     *      <tr>
     *          <td>(2)</td>
     *          <td>if client recieve data from server
     *              <ul>
     *                  <li>if yes, than do following:
     *                      <ul>
     *                          <li>recieve number of new rooms : int</li>
     *                          <li>do in loop per room:
     *                              <ul>
     *                                  <li>recieve the room title : String</li>
     *                                  <li>recieve the number of messages : int</li>
     *                                  <li>
     *                                      do in loop per message:
     *                                      <ul>
     *                                          <li>recieve in_message_type : int</li>
     *                                          <li>recieve in_message_content : String</li>
     *                                          <li>recieve in_message_time : String</li>
     *                                          <li>recieve in_message_userId : int</li>
     *                                      </ul>
     *                                  </li>
     *                              </ul>
     *                          </li>
     *                          <li>recieve the number of users : int</li>
     *                          <li>
     *                              do in loop per every user:
     *                              <ul>
     *                                  <li>recieve username                   : String</li>
     *                                  <li>recieve isOnline                   : boolean</li>
     *                                  <li>recieve selectedRoom               : int</li>
     *                                  <li>recieve password                   : String</li>
     *                              </ul>
     *                          </li>
     *                      </ul>
     *                  </li>
     *              </ul>
     * 
     * 
     * 
     *  </table>
     **/
    public void serverListener(){
        try{
            this.ownId = this.dis.readInt();
            System.out.println("Meine ID"+ownId);
            while(clientRun){
                //recieve number of new rooms


                String verwarnungText = dis.readUTF();

                
                this.rooms = new ArrayList<Room>();
                this.users = new ArrayList<User>();

                if(!verwarnungText.equals("")){
                    JFrame verwarnung = new JFrame();
                    verwarnung.add(new JLabel(verwarnungText));
                    verwarnung.pack();
                    verwarnung.setVisible(true);
                }




                int rooms_num   = dis.readInt();
                
                
                

                /** <!--
                 *  do in loop per room
                 *  recieve the room title               : String
                 *  recieve the number of messages       : int
                 *  do in loop per message
                 *        recieve in_message_type        : int
                 *        recieve in_message_content     : String
                 *        recieve in_message_time        : String
                 *        recieve in_message_userId      : int
                 * -->
                 */
                for(int i=0; i<rooms_num; i++){
                    String rooms_title = dis.readUTF();
                    this.rooms.add(new Room(i, rooms_title, ""));
                    System.out.println(rooms_title);

                    int rooms_msg_num = dis.readInt();

                    /* <!-- 
                    *  do in loop per message
                    *        recieve in_message_type        : int
                    *        recieve in_message_content     : String
                    *        recieve in_message_time        : String
                    *        recieve in_message_userId      : int
                    * -->
                    */
                    for(int j=0; j<rooms_msg_num; j++){
                        int         in_message_type = this.dis.readInt();
                        String   in_message_content = this.dis.readUTF();
                        String      in_message_time = this.dis.readUTF();
                        int       in_message_userId = this.dis.readInt();

                        this.rooms.get(i).addMessage(new Message(in_message_type, getDate(), getTime(), in_message_content, in_message_userId, false));
                    }
                }

                //recieve the number of users            : int
                int users_num   = dis.readInt();
                

                /** <!--
                 *  recieve the number of users            : int
                 *  do in loop per every user           
                 *      recieve username                   : String
                 *      recieve isOnline                   : boolean
                 *      recieve selectedRoom               : int
                 *      recieve passowrd                   : String
                 *              --------------------------------------------
                 * -->*/
                for(int i=0; i<users_num; i++){
                    String  in_username = dis.readUTF();
                    boolean in_isOnline = dis.readBoolean();
                    int in_selectedRoom = dis.readInt();
                    String  in_password = dis.readUTF();

                    System.out.println(in_selectedRoom);
                    this.users.add(new User(i, in_username, in_password));
                    this.users.get(this.users.size()-1).setUserSelectedRoom(in_selectedRoom);
                }

                this.users.get(ownId).setIsOnline();
                this.users.get(ownId).setUserSelectedRoom(selectedRoom);

                int countOfDIrects = dis.readInt();
                this.directs = new ArrayList<DirectChat>();

                for(int i=0;i<countOfDIrects; i++){
                    int idx = dis.readInt();
                    int idx1 = dis.readInt();
                    int idx2 = dis.readInt();
                    String title = dis.readUTF();
                    this.directs.add(new DirectChat(idx, idx1, idx2, title));
                    System.out.println(title);
                    int countOfMessages = dis.readInt();
                    for(int j=0; j<countOfMessages; j++){
                        String content = dis.readUTF();
                        String date = dis.readUTF();
                        String time = dis.readUTF();
                        int roomIdx = dis.readInt();
                        int roomType = dis.readInt();
                        this.directs.get(i).setMessage(new DirectMessage(roomIdx, roomType, content, date, time));
                    }
                }

                System.out.println("DIREKTNACHRICHTEN");

                for(int i=0; i<directs.size();i++){
                    System.out.println(this.directs.get(i).getTitle()+": "+this.directs.get(i).getNumOfMessages()+"("+this.directs.get(i).getIdx()+this.directs.get(i).getIdx1()+this.directs.get(i).getIdx2()+")");
                }


                //Hier beginnt das Abspeichern




                //this.update = true;
                //System.out.println("Neue Daten wurden empfangen!");



                for(int i=0; i<this.rooms.size(); i++){
                    //if(i==this.rooms.size()-1) System.out.print("Raum '"+this.rooms.get(i).getTitle()+"' := {");
                   
                    for(int j=0; j<this.rooms.get(i).getNumOfMessages(); j++){
                        
                        this.rooms.get(i).getMessage(j).getMessageContent();
                    }


                    //if(i==this.rooms.size()-1) System.out.println("}");
                }
                
                System.out.println("abrakadabra"+dis.readInt());

                update = true;
            
            }
        } catch(Exception e){
            System.out.println("Verbindung zum Server verloren!");
            System.exit(0);
        }
    }
    public static void main(String[] arg){
        Client client = new Client();
        client.initialize();
        client.run();
    }
}