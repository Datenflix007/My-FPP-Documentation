/** @file User.java
 * 
 * @brief This class discribes the User data and contains the USer Socket and and executable protocolls.
 * 
 * @author Staacke, Felix
 * @author the other student
 * 
 * <div id="methodOverview" >
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
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.User()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">none</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User(int id, String username, String password)</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *    <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.hashPassword()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">int</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.hashPassword(password : String)</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *  <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getDate()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getDate()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">This method returns the current date in a String format.</td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getTime()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getTime()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">This method returns the current time in a string format.</td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setIsOnline()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">none</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setIsOnline(socket:Socket, server:Server)</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">This method declares and initialises the both Threads User.userSender and User.userReceiver. Than the method trys to copy the parameter-socket into the class-variable User.userSocket. At last the method starts the two threads in User.userSender and User.userReceiver. User.userSender will run the method User.sendToUser(). User.userReceiver will run the method User.receiveFromClient(). Al last, this method calls the method User.setIsUpdate().</td>
 *   </tr>
 *  <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setIsOnline()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">void</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setIsOnline()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">set the var User.userIsOnline true</td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setIsOffline()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">void</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setIsOffline()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">This method interrupt the Thread userSender and userReceiver. Then the sockt connection to the client become closed.</td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.receiveFromClient()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">none</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.receiveFromClient()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">
 *          This method is saved as a lambda in User.userSender. This method become called in User.setIsOnline. Data become received structured by following protocoll.
     * 
     * <div id="protocoll">
     *      <table>
     *          <tr>
     *              <th>Pos.</th>
     *              <th>math.-name</th>
     *              <th>local var-name</th>
     *              <th>datatype</th>
     *              <th>discribtion</th>
     *          </tr><tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr><tr>
     *              <td>(1)</td>
     *              <td>i_0</td>
     *              <td>inNewRoom</td>
     *              <td>boolean</td>
     *              <td>should a existing room become delted</td>
     *          </tr><tr>
     *              <td>(2)</td>
     *              <td>i_1</td>
     *              <td>inDelRoom</td>
     *              <td>boolean</td>
     *              <td></td>
     *          </tr><tr>
     *              <td>(3)</td>
     *              <td>i_2</td>
     *              <td>inDirChat</td>
     *              <td>boolean</td>
     *              <td>should a direct chat become created</td>
     *          </tr><tr>
     *              <td>(4)</td>
     *              <td>i_3</td>
     *              <td>inDirAdrr</td>
     *              <td>int</td>
     *              <td>who should be adressed in direct chat</td>
     *          </tr><tr>
     *              <td>(5)</td>
     *              <td>i_4</td>
     *              <td>inSelRoom</td>
     *              <td>int</td>
     *              <td>content of message => text</td>
     *          </tr><tr>
     *              <td>(6)</td>
     *              <td>i_5</td>
     *              <td>inMsgCont</td>
     *              <td>String</td>
     *              <td>content of message</td>
     *          </tr><tr>
     *              <td>(7)</td>
     *              <td>i_6</td>
     *              <td>inMsgDisc</td>
     *              <td>String</td>
     *              <td>discribtion for a new Room</td>
     *          </tr><tr>
     *              <td>(8)</td>
     *              <td>i_7</td>
     *              <td>inMsgDate</td>
     *              <td>String</td>
     *              <td>date of message</td>
     *          </tr><tr>
     *              <td>(9)</td>
     *              <td>i_8</td>
     *              <td>inMsgTime</td>
     *              <td>String</td>
     *              <td></td>
     *          </tr><tr>
     *              <td>(10)</td>
     *              <td>i_9</td>
     *              <td>inMsgUser</td>
     *              <td>int</td>
     *              <td>ownId of User</td>
     *          </tr>
     *      </table>
     * 
     *      <br/><br/>
     * 
     *      <table>
     *          <tr>
     *              <th>operation mode</th>
     *              <th></th>
     *              <th>i_0</th>
     *              <th>i_1</th>
     *              <th>i_2</th>
     *              <th></th>
     *              <th>i_3</th>
     *              <th>i_4</th>
     *              <th>i_5</th>
     *              <th>i_6</th>
     *              <th>i_7</th>
     *              <th>i_8</th>
     *              <th>i_9</th>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td>direct Chat</td>
     *              <td></td>
     *              <td>0</td>
     *              <td>0</td>
     *              <td>1</td>
     *              <td></td>
     *              <td>1</td>
     *              <td>0</td>
     *              <td>1</td>
     *              <td>0</td>
     *              <td>1</td>
     *              <td>1</td>
     *              <td>1</td>
     *          </tr>
     *      </table>
     * </div>
     * 
     * <h1>Legend:</h1>
     * <ul>
     *  <li>for i_0 AND i_1 AND i_2:</li>
     *     <ul>
     *          <li>0 <-> must be false.</li>
     *          <li>1 <-> must be true.</li>
     *     </ul>
     *  <li>for i_3 AND ... AND i_9:</li>
     *      <ul>
     *          <li>0 <-> value doesn't matter <-> value will not be safed.</li>
     *          <li>1 <-> value do matter <-> value will be safed.</li>
     *      </ul>
     * </ul>
     * </td>
     *</tr>
  *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.sendToClient()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">private</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">none</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.sendToClient</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">
 *          This method is saved as a lambda in User.userReceiver. This method become called in User.setIsOnline. Data become received structured by following protocoll. 
            <table>
                *      <tr>
                *          <th>Pos.</th>
                *          <th>Operation</th>
                *      </tr>
                *      <tr>
                *          <td>(1)</td>
                *          <td>check, if updated data are available</td>
                *      </tr>
                *      <tr>
                *          <td>(2)</td>
                *          <td>if yes, than do following
                *              <ul>
                *                  <li>send number of new rooms:int</li>
                *                  <li>do in loop per room:
                *                      <ul>
                *                          <li>send the room title:String</li>
                *                          <li>send the number of messages:int</li>
                *                          
                *                              <ul>
                *                                     <li>send out_message_type:int</li>
                *                                     <li>send out_message_content:String</li>
                *                                     <li>send out_message_time:String</li>
                *                                     <li>send out_message_userId:int</li>
                *                              </ul>
                *                              
                *                      </ul>
                    *                   </li>
                    *              <li>send the number of users:int</li>
                    *              <li>do in loop per every user:</li>
                                        <ul>
                                            <li>send username:String</li>
                                            <li>send isOnline:boolean</li>
                                            <li>send selectedRoom:int</li>
                                            <li>send password:String</li>
                                        </ul>
                    *              </ul>
                
                * </table> 
 * 
 *      </td>
 *      </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.checkIdentity()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">boolean</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.checkIdentity(username : String, password String)</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">This method checks, if the entered login data equals the safed data.</td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUsername()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUsername()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsOnline()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">boolean</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsOnline()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserIsKicked()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">none</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserIsKicked()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserIsBanned()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">void</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserIsBanned</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsBanned()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">boolean</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsBanned()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserSelectedRoom()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">int</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserSelectedRoom()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserKickCounter()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">int</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserKickCounter()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserIdentity()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">int</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserIdentity()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getHashedPassword()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">int</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getHashedPassword()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsVerwarnt()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">boolean</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsVerwarnt()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsKicked()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">boolean</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getIsKicked()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserRegistrationDate()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserRegistrationDate()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserRegistrationTime()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserRegistrationDate()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserLastLoginDate()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserLastLoginDate()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserLastLoginTime()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserLastLoginTime()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserIsBanned()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">String</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.getUserIsBanned()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserIsVerwarned()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">pubic</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">void</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserIsVerwarned(str : String)</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 *   <tr>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserSelectedRoom()</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">public</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">none</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;">User.setUserSelectedRoom(ridx : int)</td>
 *      <td style="border-bottom: 2px solid black; postition: justify;"></td>
 *   </tr>
 * 
 * </table>
*/
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket; 
import java.util.ArrayList;

/** this class discribs the type User
 *  ATTENTION: this type is not runnable!!!!
 * 
 */

public class User{
    //Account data
    private int     userID;
    private String  userUsername;
    private int     userPasswordHash;       //TODO: implement an Constructor with hashing
    private boolean userIsOnline;
    private int     userSelectedRoom;

    //Verwarnung
    private boolean userIsVerwarned;
    private boolean userIsKicked;
    private int     userIsKickedCounter;
    private boolean userIsBanned;
    private String  userVerwarnung;

    //statistics
    private String userRegistrationDate;
    private String userRegistrationTime;
    private String userLastLoginDate;
    private String userLastLoginTime;

    //Threads
    private Thread userSender;
    private Thread userReceiver;
    private Socket userSocket;
    private Server userServer;

    //registration constructor
    /**@author Staacke, Felix
     * 
     * @brief This is the constructor of the Class User. The Vars become declared, and initilised with the parameters.
     * 
     * @param id
     * @param username
     * @param password
     */
    User(int id, String username, String password){
        try{
            this.userID                 = id;
            this.userUsername           = username;
            this.userPasswordHash       = this.hashPassword(password);
            this.userRegistrationDate   = getDate();
            this.userLastLoginDate      = getDate();
            this.userRegistrationTime   = getTime();
            this.userLastLoginTime      = getTime();
            this.userIsOnline           = false;
            this.userIsBanned           = false;
            this.userIsKicked           = false;
            this.userIsVerwarned        = false;
            this.userSelectedRoom       = -1;
            this.userIsKickedCounter    = 0;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /** @author Staacke, Felix
     * 
     * @brief This is an alternative, overloaded constructor of the class User.
     * 
     * @param id
     * @param username
     * @param hashedPassword
     * @param userIsVerwarned
     * @param userIsKicked
     * @param userIsKickedCounter
     * @param userIsBanned
     * @param regDate
     * @param regTime
     */
    User(int id, String username, int hashedPassword, boolean userIsVerwarned, boolean userIsKicked, int userIsKickedCounter, boolean userIsBanned, String regDate, String regTime){
        this.userID                     = id;
        this.userUsername               = username;
        this.userPasswordHash           = hashedPassword;
        this.userIsVerwarned            = userIsVerwarned;
        this.userIsKicked               = userIsKicked;
        this.userIsKickedCounter        = userIsKickedCounter;
        this.userIsBanned               = userIsBanned;
        this.userRegistrationDate       = regDate;
        this.userRegistrationTime       = regTime;
        this.userLastLoginDate          = getDate();
        this.userLastLoginTime          = getTime();
    }

    /**@author the other student
     * 
     * @brief This method returns the hasvalue of the password. The User structure only safe the hashvalue, not the passwords.
     * 
     * @param password
     * @return
     */
    public int hashPassword(String password) {       

        return password.hashCode();
    }

    /**@author the other student
     * 
     * @brief This method returns the current date in a String format.
     * 
     * @return
     */
    public static String getDate() {
        // Aktuelles Datum erhalten
        Date currentDate = new Date();

        // Formatierung des Datums
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        // Datum in das gewünschte Format umwandeln
        String formattedDate = dateFormat.format(currentDate);

        return formattedDate;
    }

    /**@author Staacke, Felix
     * 
     * @brief This method returns the current time in a string format.
     * 
     * @return
     */
    public static String getTime() {
        // Aktuelle Zeit erhalten
        Date currentTime = new Date();

        // Formatierung der Uhrzeit
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // Uhrzeit in das gewünschte Format umwandeln
        String formattedTime = timeFormat.format(currentTime);

        return formattedTime;
    }

    /**@author the other student
     * 
     * @brief This method declares and initialises the both Threads User.userSender and User.userReceiver. Than the method trys to copy the parameter-socket into the class-variable User.userSocket. At last the method starts the two threads in User.userSender and User.userReceiver. User.userSender will run the method User.sendToUser(). User.userReceiver will run the method User.receiveFromClient(). Al last, this method calls the method User.setIsUpdate().
     * 
     * 
     * @param socket
     * @param server
     * 
     * @throws java.net.SocketException
     */
    public void setIsOnline(Socket socket, Server server){
        this.userServer = server;
        this.userIsOnline= true;
        this.userSender = new Thread(this::sendToClient);
        this.userReceiver = new Thread(this::receiveFromClient);
        this.userSocket = null;

        try{
            this.userSocket = socket;
            System.out.println("Socke kopiert");
        } catch(Exception e){
            //e.printStackTrace();
        }

        this.userSender.start();
        this.userReceiver.start();
        this.userServer.setIsUpdate();
    }

    /**@author the other student
     * 
     * @brief set the var User.userIsOnline true
     * 
     */
    public void setIsOnline(){
        this.userIsOnline = true;
    }

    /** @author the other student
     * 
     *  @brief This method interrupt the Thread userSender and userReceiver. Then the sockt connection to the client become closed.
     * 
     * 
     */
    public void setIsOffline(){
        try{
            this.userIsOnline = false;
            this.userSender.interrupt();
            this.userReceiver.interrupt();
            this.userSocket.close();
        } catch(Exception e){
            System.out.println("Verbindung gekappt!");
        }
    }


    /** @author Staacke, Felix
     * 
     * @brief This method is saved as a lambda in User.userSender. This method become called in User.setIsOnline. Data become received structured by following protocoll.
     * 
     * <div id="protocoll">
     *      <table>
     *          <tr>
     *              <th>Pos.</th>
     *              <th>math.-name</th>
     *              <th>local var-name</th>
     *              <th>datatype</th>
     *              <th>discribtion</th>
     *          </tr><tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr><tr>
     *              <td>(1)</td>
     *              <td>i_0</td>
     *              <td>inNewRoom</td>
     *              <td>boolean</td>
     *              <td>should a existing room become delted</td>
     *          </tr><tr>
     *              <td>(2)</td>
     *              <td>i_1</td>
     *              <td>inDelRoom</td>
     *              <td>boolean</td>
     *              <td></td>
     *          </tr><tr>
     *              <td>(3)</td>
     *              <td>i_2</td>
     *              <td>inDirChat</td>
     *              <td>boolean</td>
     *              <td>should a direct chat become created</td>
     *          </tr><tr>
     *              <td>(4)</td>
     *              <td>i_3</td>
     *              <td>inDirAdrr</td>
     *              <td>int</td>
     *              <td>who should be adressed in direct chat</td>
     *          </tr><tr>
     *              <td>(5)</td>
     *              <td>i_4</td>
     *              <td>inSelRoom</td>
     *              <td>int</td>
     *              <td>content of message => text</td>
     *          </tr><tr>
     *              <td>(6)</td>
     *              <td>i_5</td>
     *              <td>inMsgCont</td>
     *              <td>String</td>
     *              <td>content of message</td>
     *          </tr><tr>
     *              <td>(7)</td>
     *              <td>i_6</td>
     *              <td>inMsgDisc</td>
     *              <td>String</td>
     *              <td>discribtion for a new Room</td>
     *          </tr><tr>
     *              <td>(8)</td>
     *              <td>i_7</td>
     *              <td>inMsgDate</td>
     *              <td>String</td>
     *              <td>date of message</td>
     *          </tr><tr>
     *              <td>(9)</td>
     *              <td>i_8</td>
     *              <td>inMsgTime</td>
     *              <td>String</td>
     *              <td></td>
     *          </tr><tr>
     *              <td>(10)</td>
     *              <td>i_9</td>
     *              <td>inMsgUser</td>
     *              <td>int</td>
     *              <td>ownId of User</td>
     *          </tr>
     *      </table>
     * 
     *      <br/><br/>
     * 
     *      <table>
     *          <tr>
     *              <th>operation mode</th>
     *              <th></th>
     *              <th>i_0</th>
     *              <th>i_1</th>
     *              <th>i_2</th>
     *              <th></th>
     *              <th>i_3</th>
     *              <th>i_4</th>
     *              <th>i_5</th>
     *              <th>i_6</th>
     *              <th>i_7</th>
     *              <th>i_8</th>
     *              <th>i_9</th>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *              <td></td>
     *          </tr>
     *          <tr>
     *              <td>direct Chat</td>
     *              <td></td>
     *              <td>0</td>
     *              <td>0</td>
     *              <td>1</td>
     *              <td></td>
     *              <td>1</td>
     *              <td>0</td>
     *              <td>1</td>
     *              <td>0</td>
     *              <td>1</td>
     *              <td>1</td>
     *              <td>1</td>
     *          </tr>
     *      </table>
     * </div>
     * 
     * <h1>Legend:</h1>
     * <ul>
     *  <li>for i_0 AND i_1 AND i_2:</li>
     *     <ul>
     *          <li>0 <-> must be false.</li>
     *          <li>1 <-> must be true.</li>
     *     </ul>
     *  <li>for i_3 AND ... AND i_9:</li>
     *      <ul>
     *          <li>0 <-> value doesn't matter <-> value will not be safed.</li>
     *          <li>1 <-> value do matter <-> value will be safed.</li>
     *      </ul>
     * </ul>
     *
     * 
     * 
     * 
     * <!--
     * operation mode | i_0 | i_1 | i_2 | i_3 | i_4 | i_5 | i_6 | i_7 | i_8 | i_9
     * ===============|=================|========================================
     * new Message    |  0     0     0  | { }   {-}   {-}   { }   {-}   {-}   {-}
     * new Room       |  1     0     0  | { }   { }   {-}   {-}   { }   { }   {-}
     * del Room       |  0     1     0  | { }   {-}   { }   { }   { }   { }   {-}
     * edit Room      |  1     1     0  | { }   {-}   {-}   {-}   { }   { }   {-}
     * ---------------|-----------------|----------------------------------------
     * direct Chat    |  0     0     1  | {-}   { }   {-}   { }   {-}   {-}   {-}
     *                  '-------------'  '--------------------------------------'
     *                  modus selection     inner selection
     * -->
     */
    public void receiveFromClient(){
        try{
            DataInputStream dis = new DataInputStream(this.userSocket.getInputStream());
            while(this.userIsOnline){
                
                boolean inNewRoom = dis.readBoolean();
                boolean inDelRoom = dis.readBoolean();
                boolean inDirChat = dis.readBoolean();
                int     inDirAdrr = dis.readInt();
                int     inSelRoom = dis.readInt();
                String  inMsgCont = dis.readUTF();
                String  inMsgDisc = dis.readUTF();
                String  inMsgDate = dis.readUTF();
                String  inMsgTime = dis.readUTF();
                int     inMsgUser = dis.readInt();

                //new Message
                if(inNewRoom==false && inDelRoom==false && inDirChat==false){
                    //TODO: mache dir gedanken wie du das mit Dateinachrichten machst
                    userServer.serverAddMessage(new Message(0, inMsgDate, inMsgTime, inMsgCont, inMsgUser, false), inSelRoom);
                    //message := {type:int, Date:String, Time:String, Content:String, userId:int, isDelted:boolean}
                    userServer.serverAppendToFile(1, "0;"+inMsgDate+";"+inMsgTime+";"+inMsgCont+";"+inMsgUser+";0;0");
                }

                //new Room
                if(inNewRoom==true && inDelRoom==false && inDirChat==false){
                    userServer.serverAddRoom(new Room(userServer.serverGetNewRoomIdx(), inMsgCont, inMsgDisc));
                    //room := {idx:int, title:String, disc:String}
                    userServer.serverAppendToFile(0, userServer.serverGetNewRoomIdx()+";"+inMsgCont+";"+inMsgDisc);
                }

                //del Room
                if(inNewRoom==false && inDelRoom==true && inDirChat==false){
                    userServer.serverDelRoom(inSelRoom);
                    //TODO: overwrite file
                }

                //edit Room
                if(inNewRoom==false && inDelRoom==false && inDirChat==true){
                    userServer.serverEdtRoom(inSelRoom, inMsgCont, inMsgDisc);
                    //TODO: overwrite file and log
                }

                //dir Chat
                if(inNewRoom==true && inDelRoom==true && inDirChat==false){
                    System.out.println("RECIEVED DIR CHAT!!!!");
                    boolean dirExists = false;
                    ArrayList<DirectChat> dirs = userServer.getDirectChats();

                    for(DirectChat dir : dirs){
                        if(dir.getIsCorrectChat(inMsgUser, inDirAdrr)==true){
                            dir.setMessage(new DirectMessage(inSelRoom, 0, inMsgCont, inMsgDate, inMsgTime));
                            dirExists =true;
                        }
                    }

                    if(dirExists==false){
                        userServer.serverAddDirectChat(inMsgCont, inDirAdrr, inMsgUser);
                    }
                }

                Thread.sleep(500);
            }
        } catch(Exception e){
            this.setIsOffline();
        }
    }
/** <!--Thread blueprint for lambda: ()->userWriter()
     *  check, if updated data are available
     *          -----------------------------------------------
     *         if yes, than do following
     *              send number of new rooms            : int
     *              do in loop per room
     *                  send the room title             : String
     *                  send the number of messages     : int
     *                  do in loop per message
     *                      send out_message_type       : int
     *                      send out_message_content    : String
     *                      send out_message_time       : String
     *                      send out_message_userId     : int
     *              
     *              send the number of users            : int
     *              do in loop per every user           
     *                  send username                   : String
     *                  send isOnline                   : boolean
     *                  send selectedRoom               : int
     *                  send password                   : String
     *              ------------------------------------------ -->*/
    /**@author Staacke, Felix
     * 
     * @brief This method is saved as a lambda in User.userReceiver. This method become called in User.setIsOnline. Data become received structured by following protocoll. 
     * 
     * <table>
     *      <tr>
     *          <th>Pos.</th>
     *          <th>Operation</th>
     *      </tr>
     *      <tr>
     *          <td>(1)</td>
     *          <td>check, if updated data are available</td>
     *      </tr>
     *      <tr>
     *          <td>(2)</td>
     *          <td>if yes, than do following
     *              <ul>
     *                  <li>send number of new rooms:int</li>
     *                  <li>do in loop per room:
     *                      <ul>
     *                          <li>send the room title:String</li>
     *                          <li>send the number of messages:int</li>
     *                          
     *                              <ul>
     *                                     <li>send out_message_type:int</li>
     *                                     <li>send out_message_content:String</li>
     *                                     <li>send out_message_time:String</li>
     *                                     <li>send out_message_userId:int</li>
     *                              </ul>
     *                              
     *                      </ul>
        *                   </li>
        *              <li>send the number of users:int</li>
        *              <li>do in loop per every user:</li>
                            <ul>
                                <li>send username:String</li>
                                <li>send isOnline:boolean</li>
                                <li>send selectedRoom:int</li>
                                <li>send password:String</li>
                            </ul>
        *              </ul>
    
     * </table>
     */
    private void sendToClient() {
        try{
            DataOutputStream dos = new DataOutputStream(userSocket.getOutputStream());

            while(userIsOnline){

              
                //check, if updated data are available
                //System.out.println("*");
                if(userServer.getIsUpdate() ==true){


                    //System.out.println("**");
                    ArrayList<Room> rooms = userServer.getRooms();
                    ArrayList<User> users = userServer.getUsers();
                    ArrayList<DirectChat> directs = userServer.getDirectChats();


                    
                    dos.writeUTF("VERWARNUNG"); //verwarnung ="";

                    //send number of new rooms              : int
                    dos.writeInt(rooms.size());

                    /**  <!--
                     *   do in loop per room
                     *      send the room title             : String
                     *      send the number of messages     : int
                     *      do in loop per message
                     *          send out_message_type       : int
                     *          send out_message_content    : String
                     *          send out_message_time       : String
                     *          sned out_message_userId     : int -->
                    */
                    for(int i=0; i<rooms.size(); i++){
                        dos.writeUTF(rooms.get(i).getTitle());;
                        dos.writeInt(rooms.get(i).getNumOfMessages());;

                        for(int j=0; j<rooms.get(i).getNumOfMessages(); j++){
                            dos.writeInt(rooms.get(i).getMessage(j).getMessageType());
                            dos.writeUTF(rooms.get(i).getMessage(j).getMessageContent());
                            dos.writeUTF(rooms.get(i).getMessage(j).getMessageTime());
                            dos.writeInt(rooms.get(i).getMessage(j).getMessageUserId());
                        }
                    }

                    //send the number of users              : int
                    dos.writeInt(users.size());

                    /** <!--
                     *     do in loop per every user
                     *        send username                 : String
                     *        send isOnline                 : boolean   
                     *        send selectedRoom             : int
                     *        send password                 : String -->
                     */
                     for(int i=0; i<users.size(); i++){
                        dos.writeUTF(users.get(i).getUsername());
                        dos.writeBoolean(users.get(i).getIsOnline() );
                        dos.writeInt(users.get(i).getUserSeletedRoom());
                        dos.writeUTF("Password" );
                     }


                     System.out.println("======Starting SENDING DIRECT CHAT======");

                     System.out.print("DirectChats := {");
                     for(int i=0; i<directs.size(); i++){
                        System.out.print("["+directs.get(i).getIdx()+"]->"+directs.get(i).getTitle()+(i<directs.size()-1?",":""));
                     }
                     System.out.println("}.");

                     for(int i=0; i<directs.size(); i++){
                        System.out.print("["+i+"]->"+"("+directs.get(i).getIdx1()+directs.get(i).getIdx2()+")"+directs.get(i).getTitle()+" := {");

                        for(int j=0; j<directs.get(i).getNumOfMessages(); j++){
                            System.out.print(directs.get(i).getMessage(j).getContent()+(j<directs.get(i).getNumOfMessages()-1?",":""));
                        }
                        System.out.print("}.\n");
                     }

                     System.out.println("======Starting SENDING DIRECT CHAT======\n");

                     dos.writeInt(directs.size());
                     for(int i=0; i<directs.size(); i++){
                        dos.writeInt(directs.get(i).getIdx());
                        dos.writeInt(directs.get(i).getIdx1());
                        dos.writeInt(directs.get(i).getIdx2());
                        dos.writeUTF(directs.get(i).getTitle());

                        dos.writeInt(directs.get(i).getNumOfMessages());
                        for(int j=0; j<directs.get(i).getNumOfMessages(); j++){
                            dos.writeUTF(directs.get(i).getMessage(j).getContent());
                            dos.writeUTF(directs.get(i).getMessage(j).getDate());
                            dos.writeUTF(directs.get(i).getMessage(j).getTime());
                            dos.writeInt(directs.get(i).getMessage(j).getDirectRoomIdx());
                            dos.writeInt(directs.get(i).getMessage(j).getDirectRoomType());
                        }
                     }

                    

                    
                }

                Thread.sleep(500);
            }
        } catch(Exception e){
            this.userIsOnline = false;
            userServer.setIsUpdate(); ;
            System.out.print(this.getIsOnline());

        }
    }

    /**@author the other student
     * 
     * @brief This method checks, if the entered login data equals the safed data.
     * 
     * @param username
     * @param password
     * @return
     */
    public boolean checkIdentity(String username, String password){
        boolean result = false;    

        try{
            
            if(username.equals(this.userUsername) && password.hashCode() == this.userPasswordHash){
                result = true;
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**@author the other student
     * 
     * @return
     */
    public String getUsername(){    return this.userUsername;}
    /**@author the other student
     * 
     * @return
     */
    public boolean getIsOnline(){   return this.userIsOnline; }
    /**@author the other student
     * 
     */
    public void setUserIsKicked() { this.userIsKicked = true; }
    /**@author the other student
     * 
     */
    public void setUserIsBannd(){   this.userIsBanned = true; }
    /**@author the other student
     * 
     * @return
     */
    public boolean getIsBanned(){ return this.userIsBanned; }
    /**@author the other student
     * 
     * @return
     */
    public int getUserSeletedRoom(){ return this.userSelectedRoom;}
    /**@author the other student
     * 
     * @return
     */
    public int getUserKickCounter(){ return this.userIsKickedCounter; }
    /**@author the other student
     * 
     * @return
     */
    public int getUserIdentity(){ return this.userID;}
    /**@author the other student
     * 
     * @return
     */
    public int getHashedPassword(){ return this.userPasswordHash; }
    /**@author the other student
     * 
     * @return
     */
    public boolean getIsVerwarnt(){ return this.userIsVerwarned; }
    /**@author the other student
     * 
     * @return
     */
    public boolean getIsKicked(){ return this.userIsKicked; }
    /**@author the other student
     * 
     * @return
     */
    public String getUserRegistrationDate(){ return this.userRegistrationDate; }
    /**@author the other student
     * 
     * @return
     */
    public String getUserRegistrationTime(){ return this.userRegistrationTime; }
    /**@author the other student
     * 
     * @return
     */
    public String getUserLastLoginDate(){ return this.userLastLoginDate; }
    /**@author the other student
     * 
     * @return
     */
    public String getUserLastLoginTime(){ return this.userLastLoginTime; }
    /**@author the other student
     * 
     * @return
     */
    public boolean getUserIsBanned(){ return this.userIsBanned; }
    /**@author the other student
     * 
     * @param str
     */
    public void setUserIsVerwarned(String str){ this.userIsVerwarned = true; this.userVerwarnung = str; }
    /**@author the other student
     * 
     * @param ridx
     */
    public void setUserSelectedRoom(int ridx){ this.userSelectedRoom = ridx; }
}