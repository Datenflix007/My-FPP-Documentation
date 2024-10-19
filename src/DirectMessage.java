/**@author Staacke, Felix
 * 
 * @file DirectMessage.java
 * @brief This class represents a direct message between two users, or the server and a single user.
 * 
 * <b>Hint:</b> This class only contains getter and setter methods.
 * 
 */

public class DirectMessage{
    private String content;
    private String date;
    private String time;
    private int directRoomIdx;
    private int directRoomType;

    DirectMessage(int room, int type, String content, String date, String time){
        this.content = content;
        this.directRoomIdx = room;
        this.date = date;
        this.time = time;
        this.directRoomType = type;
    }

    public String getContent() {
        return content;
    }
    public String getDate() {
        return date;
    }
    public int getDirectRoomIdx() {
        return directRoomIdx;
    }
    public int getDirectRoomType() {
        return directRoomType;
    }
    public String getTime() {
        return time;
    }
    
}