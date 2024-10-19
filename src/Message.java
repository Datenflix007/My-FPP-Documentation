/** @author Staacke, Felix
 * 
 * @file Message.java
 * @brief this class discribes the datastructure of a message
 * <br /> 
 * This class contains the type of a message<br /> 
 *  ATTENTION: this type is not runnable!!!!<br /> 
 *  -> contains the Constructor<br /> 
 *     get Data from farams in Relation message := {type:int, Date:String, Time:String, Content:String, userId:int, isDelted:boolean}<br /> 
 *  -> also contains getter methods for all attributes<br /> 
 *     - public int getMessageType()<br /> 
 *     - public int getMessageUserId()<br /> 
 *     - public String getMessageTime()<br /> 
 *     - public String getMessageContent()<br /> 
 *     - public boolean getMessageIsDeleted()<br /> 
 *     - public String getMessageDate()<br /> 
 *  -> also contains the setter mothod for messageIsDeleted<br /> 
 *     - public void setIsDeleted()<br /> <br /> 
 * 
 * <b>Hint:</b> this class only contains getter and setter methods.
 *  
 */
public class Message{
    private int         messageType;
    private int         messageUserId;
    private String      messageDate;
    private String      messageTime;
    private String      messageContent;
    private boolean     messageIsDeleted;

    /** Construct a new Message
     *  message := {type:int, Date:String, Time:String, Content:String, userId:int, isDelted:boolean}
     */
    Message(int messageType, String messageDate, String messageTime, String messageContent, int messageUserId, boolean messageIsDeleted){
        this.messageType        = messageType;
        this.messageUserId      = messageUserId;
        this.messageDate        = messageDate;
        this.messageTime        = messageTime;
        this.messageContent     = messageContent;
        this.messageIsDeleted   = messageIsDeleted;
    }

    public int getMessageType(){            return this.messageType; }
    public int getMessageUserId(){          return this.messageUserId; }
    public String getMessageTime(){         return this.messageTime; }
    public String getMessageContent(){      return this.messageContent; }
    public boolean getMessageIsDeleted(){   return this.messageIsDeleted; }
    public String getMessageDate(){         return this.messageDate; }

    public void setIsDeleted(){ this.messageIsDeleted = true; }
    
}