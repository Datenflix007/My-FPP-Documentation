/**@file DirectChat.java
 * 
 * @author Staacke, Felix
 * 
 * @brief This class defines the datastructure DirectChat. A direct-chat is a kind of ChatRoom, but only available between two users
 * 
 * <br />
 * <b>Attention:</b> This class isn't excecutable<br/><br/>
 * <b>Hint:</b> This class only contains getter and setter methods.
 **/
import java.util.ArrayList;
class DirectChat{   //equals direct Chat room
    private int idx;    //direct room idx
    private int idx1;   //user idx 1
    private int idx2;   //user idx 2
    private String title;
    private ArrayList<DirectMessage> messages;

    DirectChat(int idx, int idx1, int idx2, String title){
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.title = title;
        this.messages = new ArrayList<DirectMessage>();
    }

    public void setDirectMessages(ArrayList<DirectMessage> msg){
        //this.messages = new ArrayList<DirectMessage>();
        for(DirectMessage message : msg){
            this.messages.add(message);
        }
    }

    public boolean getIsCorrectChat(int idx1, int idx2){
        boolean result = false;
        
        if((idx1==this.idx1 && idx2 == this.idx2) || (idx1==this.idx2 && idx2==this.idx1)){
            result = true;
        }

        return result;
    }
    public int getIdx() {
        return idx;
    }
    public int getIdx1() {
        return idx1;
    }
    public int getIdx2() {
        return idx2;
    }
    public String getTitle() {
        return title;
    }
    public int getNumOfMessages() {       
        int result = 0;
        if(this.messages != null) {
            result = this.messages.size();
        }
        return result;
    }
    public DirectMessage getMessage(int idx){
        return idx < this.messages.size() ? this.messages.get(idx) : new DirectMessage(-1,0,"none","none", "none");
    }

    public ArrayList<DirectMessage> getMessages(){
        return this.messages;
    }

    public void setMessage(DirectMessage msg){
        this.messages.add(msg);
        System.out.println("Message added successfully!");
    }
}