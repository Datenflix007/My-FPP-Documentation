/**@author Staacke, Felix
 * 
 * @file Room.java
 * @brief This class discribes a datastructure for a chat-room.
 * 
 * <h1>Method Overview<h1><br/>
 * 
 */

import java.util.ArrayList;

/**
 * <b>Hint:</b> this class only contains getter and setter methods. 
 */

public class Room{
    private int                 idx;
    private String              title;
    private String              discribtion;
    private ArrayList<Message>  messages;

    Room(int idx, String title, String discribtion){
        this.idx = idx;
        this.title = title;
        this.discribtion = discribtion;
        this.messages = new ArrayList<Message>();
    }
    Room(int idx, String title, String discribtion, ArrayList<Message> messages){
        this.idx = idx;
        this.title = title;
        this.discribtion = discribtion;
        this.messages = messages;   
    }

    //Message methods
    public Message getMessage(int idx){
        return this.messages.get(idx);
    }
    public void setMessageIsDeleted(int idx){
        this.messages.get(idx).setIsDeleted();
    }


    //getter methods 
    public String getTitle() {
        return title;
    }
    public String getDiscribtion() {
        return discribtion;
    }
    public int getIdx() {
        return idx;
    }
    public int getNumOfMessages(){
        return this.messages.size();
    }
    public ArrayList<Message> getMessages(){
        return this.messages;
    }


    //Setter methods
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDiscribtion(String discribtion) {
        this.discribtion = discribtion;
    }
    public void setMessages(ArrayList<Message> msg){
        this.messages = msg;
    }
    public void addMessage(Message message){
        this.messages.add(message);
    }
    

}