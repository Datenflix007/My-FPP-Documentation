/** @file Server.java 
 * 
 *   @brief this class discribes the excecutable type Server
 * 
 *  @author  Staacke, Felix
 * 
 *  @date 14.10.2024, 22:06
 * 
 *
 * 
 *  <h1>Bullet Points</h1>
 * <h6>(click to scroll to bullet point)</h6><br/>
 *  <span onclick="location.href='#todo'" style="cursor: pointer">1. TODO </span><br/>
 *  <span onclick="location.href='#methodOverview'" style="cursor: pointer">2. Method Overview</span><br/>
 *  <span onclick="location.href='#local vars'" style="cursor: pointer">3. Local Variables</span><br/>
 *  <span onclick="location.href='#importedPackages'" style="cursor: pointer">4. Imported Packages</span><br/><br/><br/>
 * 
 * 
 * 
 * <div id="todo">
    * <caption><h1>1. TODO List</h1></caption>
    * <table width="100%" style="border: thin solid black; background-color: #ebebeb;">
    *   <tr style="border: thin solid black;">
            <th style="border: 1px solid black; background-color: #6ec8f5;" width="60%">Discribtion</th>
            <th style="border: 1px solid black; background-color: #6ec8f5;" width="20%">Error</th>
            <th style="border: 1px solid black; background-color: #6ec8f5;" width="20%">status</th>
    *   </tr><tr >
            <td style="border-bottom: 2px solid black; postition: justify;">Redesin the GUI. One central dashboard. Without any selections, just display icons for rooms, accounts and log data. If one of the icons become selected, repaint frame and show selected area instead of dashboard</td>
            <td style="border-bottom: 2px solid black;">edit Server.serverGUI()</td>
            <td style="border-bottom: 2px solid black;">work in progress</td>
        </tr><tr >
            <td style="border-bottom: 2px solid black; postition: justify;">Reimplement the room details. Display the account name, not the account idx.</td>
            <td style="border-bottom: 2px solid black;"></td>
            <td style="border-bottom: 2px solid black;">less priority</td>
        </tr><tr >
            <td style="border-bottom: 2px solid black; postition: justify;">Reimplement the User class. Save profile pictures and status strings.</td>
            <td style="border-bottom: 2px solid black;"></td>
            <td style="border-bottom: 2px solid black;">less priority</td>
        </tr><tr >
            <td style="border-bottom: 2px solid black; postition: justify;">implement the file receiving and the file saving. Maybe reimplement class Message. Code a second constructor.</td>
            <td style="border-bottom: 2px solid black;"></td>
            <td style="border-bottom: 2px solid black;">less priority</td>
        </tr>
    * </table>
 * </div>
 * 
 * 
 * 
 * 
 *  <div id="methodOverview" >
 *  <h1>2. Method Overview</h1><br/>
 *  <table style="border: 2px solid black; background-color: #ebebeb; " width="100%">
 *   <tr >
 *      <th style="border: 1px solid black; background-color: #6ec8f5;">Identity</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">visibility</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">return type</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">method name</th>
    *   <th style="border: 1px solid black; background-color: #6ec8f5;">note</th>
 *   </tr><tr style="border: 1px solid black;">
 *      <td style="border-bottom: 2px solid black;"></td>
    *   <td style="border-bottom: 2px solid black;"></td>
    *   <td style="border-bottom: 2px solid black;"></td>
    *   <td style="border-bottom: 2px solid black;"></td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.Server()</td>
    *   <td style="border-bottom: 2px solid black;"></td>
    *   <td style="border-bottom: 2px solid black;"></td>
    *   <td style="border-bottom: 2px solid black;">Server()</td>
    *   <td style="border-bottom: 2px solid black;">default constructor </td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.initialize()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">initialize()</td>
    *   <td style="border-bottom: 2px solid black;">initialize MyFileHandler<br/>
    *      get ServerSitzung out of 'sitzung.cfg'<br/>
    *      increment serverSitzung and overwrite value in 'sitzung.cfg'<br/>
    *      call initializeUseServerCFG(path to server.cfg)</td>
 *</tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.run()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">run()</td>
    *   <td style="border-bottom: 2px solid black;">calls Server.conntectionListener()</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.connectionListener()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">connectionListener()</td>
    *   <td style="border-bottom: 2px solid black;">loop continues, if serverRun equals true<br/>if socket is initialize, than accept an incoming Socket connection</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverGUI()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverGUI()</td>
    *   <td style="border-bottom: 2px solid black;">loop: read server.cfg line by line<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;select keywords as modes<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; := { frameTitle <=> (Title for Frame : String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Messages   <=> (path to messages.csv : String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rooms      <=> (path to roooms.csv : String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Users      <=> (path to users.csv : String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DirectChat <=> (path to directChats.csv),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DirectMessage<=>(path to directChatMessages.csv),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Log        <=> (path to log.txt),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;frameHeight<=> (Value for frame size : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;frameWidth <=> (Value for frame size : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;frameX     <=> (value for frame position : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;frameY     <=> (value for frame position : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;frameMenu  <=> (Title for menu : String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;frameMenuBarItem_QUIT <=> (add frameMenu an Iteam QUIT : String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Port       <=> (Port : int),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;framePanelRoomsHeigth <=> (framePanelRoomsHeigth : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;framePanelRoomsWidth  <=> (framePanelRoomsWidth  : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;framePanelUsersHeigth <=> (framePanelUsersHeigth : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;framePanelUsersWidth  <=> (framePanelUsersWidth  : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;framePanelLogHeigth   <=> (framePanelLogHeigth   : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tframePanelLogWidth    <=> (framePanelLogWidth    : (int) String),<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;frameHeadLineDimension<=> (font size for headlines: (int) String)<br />
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.initializeUseServerCFG()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">initializeUseServerCFG(String[&nbsp] cfStrings)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.getUserIdentity()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">int</td>
    *   <td style="border-bottom: 2px solid black;">getUserIdentity(String username, String password)</td>
    *   <td style="border-bottom: 2px solid black;">returns the position of user in users with username and password</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverGUI_JPanel_Log_repaint()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverGUI_JPanel_Log_repaint()</td>
    *   <td style="border-bottom: 2px solid black;">paint Panel for logs<br/>
 *          => then select all elder logs<br/>
 *          => then select for last sitzung<br/>
 *          => then select for current sitzung</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverDirectChat()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverDirectChat(int idx)</td>
    *   <td style="border-bottom: 2px solid black;">spawn Frame with directChat</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverGUI_JPanel_Rooms_repaint()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverGUI_JPanel_Rooms_repaint()</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.createScrollPane()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">JScrollPane</td>
    *   <td style="border-bottom: 2px solid black;">createScrollPane()</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td>Server.createHeaderLabel()</td>
    *   <td>private</td>
    *   <td>JLabel</td>
    *   <td>createHeaderLabel()</td>
    *   <td></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.createLinePanel()</td>
    *   <td style="border-bottom: 2px solid black;">private</td>
    *   <td style="border-bottom: 2px solid black;">JPanel</td>
    *   <td style="border-bottom: 2px solid black;">createLinePanel(labelText:String)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.createPanel()</td>
    *   <td style="border-bottom: 2px solid black;">private</td>
    *   <td style="border-bottom: 2px solid black;">JPanel</td>
    *   <td style="border-bottom: 2px solid black;">createPanel(labelText:String, width:int, height:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.addPanelToContent()</td>
    *   <td style="border-bottom: 2px solid black;">private</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">addPanelToContent(content:JPanel, panel:JPanel, gbc:GridBagConstraints, gridx:int, gridy:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverAddMessage()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverAddMessage(message:Message, room:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverAddRoom()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverAddRoom(room:Room)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverAddUser()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverAddUser(user:User)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverGetNewRoomIdx()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">int</td>
    *   <td style="border-bottom: 2px solid black;">serverGetNewRoomIdx()</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverAppendToFile()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverAppendToFile(mode:int, content:String)</td>
    *   <td style="border-bottom: 2px solid black;">mode = 0 => new room<br/>
    *      mode = 1 => new message<br/>
    *      mode = 2 => new user<br/>
    *      mode = 3 => new log entry<br/>
    *      mode = 4 => new direct chat<br/>
    *      mode = 5 => new direct chat message</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverDelRoom()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverDelRoom(idx:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverEditRoom()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverEditRoom(idx:int, content1:String, content2:String)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverAddLog()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverAddLog(user:int, content:String)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverAddDirectChat()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverAddDirectChat(title:String, idx:int, idxU:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverUserVerwarnen()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverUserVerwarnen(idx:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverUserVerwarnen()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverUserVerwarnen(idx:int, content:String)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverUserKick()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverUserKick(idx:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.serverUserBan()</td>
    *   <td style="border-bottom: 2px solid black;">public</td>
    *   <td style="border-bottom: 2px solid black;">void</td>
    *   <td style="border-bottom: 2px solid black;">serverUserBan(idx:int)</td>
    *   <td style="border-bottom: 2px solid black;"></td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.getDate()</td>
    *   <td style="border-bottom: 2px solid black;">public static</td>
    *   <td style="border-bottom: 2px solid black;">String</td>
    *   <td style="border-bottom: 2px solid black;">getDate()</td>
    *   <td style="border-bottom: 2px solid black;">returns current Date as String in format 'dd.mm.yyyy'</td>
 *   </tr><tr>
 *      <td style="border-bottom: 2px solid black;">Server.getTime()</td>
    *   <td style="border-bottom: 2px solid black;">public static</td>
    *   <td style="border-bottom: 2px solid black;">String</td>
    *   <td style="border-bottom: 2px solid black;">getTime()</td>
    *   <td style="border-bottom: 2px solid black;">returns current Time as String in format 'hh:mm'</td>
 *   </tr>
 *   </table>
 * </div>
 * 
 * 
 * <br/><br/><br/>
 * <div id="local vars">
 * <h1>3. Class Vars</h1>
 *      <ul>
 *          <li>server socket data
 *              <ul>
 *                  <li>Server.server : ServerSocket</li>
 *                  <li>Server.socket : Socket</li>
 *                  <li>Server.serverRun : boolean</li>
 *                  <li>Server.port : int</li>
 *                  <li>Server.adress : String</li>
 *              </ul>
 *              </li>
 *          <li>safing data on drive
 *              <ul>
 *                  <li>Server.FileHandler : MyFileHandler</li>
 *                  <li>Server.pathToUsers : String</li>
 *                  <li>Server.pathToRooms : String</li>
 *                  <li>Server.pathToMessages : String</li>
 *                  <li>Server.pathToLog : String</li>
 *                  <li>Server.users : ArrayList<User></li>
 *                  <li>Server.rooms : ArrayList<Room></li>
 *                  <li>Server.directCHats : ArrayList<DirectChat></li>
 *                  <li>Server.log : ArrayList<Log></li>
 *                  <li>Server.pathToDirectChat : String</li>
 *                  <li>Server.pathToDirectMessage</li>
 *              </ul>
 *              </li>
 *          <li>threads
 *              <ul>
 *                  <li>Server.serverGUI : Thread</li>
 *                  <li>Server.serverConnectionListener : Thread</li>
 *              </ul>
 *              </li>
 *          <li>framework
 *              <ul>
 *                  <li>Server.serverUpdate : boolean</li>
 *                  <li>Server.mainFrame : JFrame</li>
 *                  <li>Server.mainFrameTitle : String</li> 
 *                  <li>Server.mainFrameWidth : int</li>
 *                  <li>Server.mainFrameHeigth : int</li>
 *                  <li>Server.mainFrameX : int></li>
 *                  <li>Server.mainFrameY : int</li> 
 *                  <li>Server.mainFrameMenu : JMenu</li>
 *                  <li>Server.mainFrameMenuBar : JMenuBar</li>
 *                  <li>Server.mainFrameMenuBarItem_QUIT : JMenuItem</li>
 *              </ul>
 *              </li>
 *          <li>panel rooms
 *              <ul>
 *                  <li>Server.mainFrameJPanelRooms : JPanel</li>
 *                  <li>Server.mainFrameJPanelRoomsHeigth : int</li>
 *                  <li>Server.mainFrameJPanelRoomsWidth : int</li> 
 *              </ul>
 *              </li>
 *          <li>panel users
 *              <ul>
 *                  <li>Server.mainFrameJPanelUsers : JPanel</li>
 *                  <li>Server.mainFrameJPanelUsersHeigth : int</li>
 *                  <li>Server.mainFrameJPanelUsersWidth : int</li> 
 *              </ul>
 *              </li>
 *          <li>panel serverlog
 *              <ul>
 *                  <li>Server.mainFrameJPanelLog : JPanel</li>
 *                  <li>Server.mainFrameJPanelLogHeigth : int</li>
 *                  <li>Server.mainFrameJPanelLogWidth : int</li> 
 *              </ul>
 *              </li>
 *          <li>other stuff
 *              <ul>
 *                  <li>Server.mainFrameHeadLineDimension : int</li>
 *                  <li>Server.mainFrameRoomnameDimension : int</li>
 *                  <li>Server.serverSitzung : int</li>
 *                  <li>Server.allLogsBool : boolean</li>
 *                  <li>Server.lastLogsBool : boolean</li>
 *                  <li>Server.currentLogsBool : boolean</li>
 *                  <li>Server.withIDE : boolean; <b>Note: </b>If val is true, then the application starts with GUI. Else the server is running as a console application</li>
 *                  <li>Server.sendUpdatedData : boolean</li>
 *              </ul>
 *              </li>
 *      </ul>
 * </div>
 * <br/><br/><br/>
 * 
 * 
 * <div id="importedPackages">
 * <h1>4. Imported packages</h1>
 * <table>
 *      <tr>
 *          <th>package</th>
 *          <th>class</th>
 *          <th>note</th>
 *      </tr><tr>
 *          <td>java.awt</td>
 *          <td>java.awt.event.ActionListener</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.event.KeyListener</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.event.MouseEvent</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.event.MouseListener</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.Dimension</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.FlowLayout</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.GridLayout</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.ScrollPane</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.awt.event.ActionEvent</td>
 *          <td></td>
 *      </tr><tr>
 *          <td>java.io</td>
 *          <td>java.io.File</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.io.IOException</td>
 *          <td></td>
 *      </tr><tr>
 *          <td>java.util</td>
 *          <td>java.util.ArrayList</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.util.Date</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>java.util.logging.FileHandler</td>
 *          <td></td>
 *      </tr><tr>
 *          <td>javax.management</td>
 *          <td>javax.management.relation.RoleList</td>
 *          <td></td>
 *      </tr><tr>
 *          <td>java.net</td>
 *          <td>java.net.Socket</td>
 *          <td></td>
 *      </tr><tr>
 *          <td>javax.swing</td>
 *          <td>javax.swing.BorderFactory</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.BoxLayout</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JButton</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JFrame</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JLabel</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JMenu</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JMenuBar</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JMenuItem</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JPanel</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JScrollPane</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JTable</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JTextArea</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JTextField</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.SwingUtilities</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.event.TableModelEvent</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.event.TableModelListener</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.table.DefaultTableModel</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.table.TableColumn</td>
 *          <td></td>
 *      </tr><tr>
 *          <td></td>
 *          <td>javax.swing.JMenuItem</td>
 *          <td></td>
 *      </tr>
 * </table>
 * </div>
 * 
 *  
 **/



import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;

import javax.management.relation.RoleList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JMenuItem;

import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.sound.midi.Patch;

public class Server{
    //serverSocket data 

        private ServerSocket    server;
        private Socket          socket;
        private boolean         serverRun;
        private int             port;
        private String          adress;

    //safe data on drive
        private MyFileHandler     fileHandler;
        private String          pathToUsers;
        private String          pathToRooms;
        private String          pathToMessages;
        private String          pathToLog;
        private ArrayList<User> users;
        private ArrayList<Room> rooms;
        private ArrayList<DirectChat> directChats;
        private ArrayList<Log>  logs;
        private String          pathToDirectChat;
        private String          pathToDirectMessage;

    //threads
        private Thread          serverGUI;
        private Thread          serverConntenctionListener;

    //framework
        private boolean         serverUpdate;
        private JFrame          mainFrame;
        private String          mainFrameTitle;
        private int             mainFrameWidth;
        private int             mainFrameHeigth;
        private int             mainFrameX;
        private int             mainFrameY;
        private JMenu           mainFrameMenu;
        private JMenuBar        mainFrameMenuBar;
        private JMenuItem       mainFrameMenuBarItem_QUIT;

        //Panel rooms
        private JPanel          mainFrameJPanelRooms;
        private int             mainFrameJPanelRoomsHeigth;
        private int             mainFrameJPanelRoomsWidth;

        //Panel users
        private JPanel          mainFrameJPanelUsers;
        private int             mainFrameJPanelUsersHeigth;
        private int             mainFrameJPanelUsersWidth;

        //Panel serverlog
        private JPanel          mainFrameJPanelLog;
        private int             mainFrameJPanelLogHeigth;
        private int             mainFrameJPanelLogWidth;

        private int             mainFrameHeadLineDimension;
        private int             mainFrameRoomnameDimension;
        private int             serverSitzung;

        boolean allLogsBool = false;
        boolean lastLogsBool = false;
        boolean currentLogsBool = true;
        boolean withIDE;
        boolean sendUpdatedData;

    Server(){

    }

    /**@author Felix Staacke
     * 
     * @brief The function class the method Server.initializeUseServerCFG(), which parse 'docs/server.cfg'. Then it declare and preinitialize some vars. Then the method declare datastructures like FileHandler.
     * 
     */
    public void initialize(){

        withIDE = false;
        try{
            //initialize data for FileHandler
                this.port = -1;
                this.fileHandler = new MyFileHandler();
                
                this.serverSitzung = this.fileHandler.parseSitzung(((Paths.get((withIDE==true? "docs/sitzung.cfg" : "../docs/sitzung.cfg"))).toAbsolutePath()))+1;
                this.fileHandler.overwriteSitzung((withIDE==true? "docs/sitzung.cfg" : "../docs/sitzung.cfg"), serverSitzung);
                String path = withIDE==true? "docs/server.cfg" : "../docs/server.cfg";
                this.logs = new ArrayList<>();
                this.rooms = new ArrayList<>();
                this.users = new ArrayList<>();
                this.directChats = new ArrayList<>();
                
                initializeUseServerCFG(this.fileHandler.parseServerCFG(path));
                serverAddLog(-1, "started server as a new instance!");
                serverAddLog(-1, "data were parsed out of file'"+path+"'");

            //initialize data for Threads
                this.serverGUI = new Thread(this::serverGUI);
                serverAddLog(-1, "Thread this::serverGUI started...");
                this.serverConntenctionListener = new Thread(this::connectionListener);
                serverAddLog(-1, "Thread this::conntectionListener started...");

            //initialize data for framework
                //if no values could be readed out of '../docs/server.cfg', than initialise with default data
                if(this.mainFrameTitle.equals("")){this.mainFrameTitle = "Server"; this.mainFrame = new JFrame(this.mainFrameTitle); }
                if(this.mainFrameHeigth<=0){this.mainFrameHeigth = 800; }
                if(this.mainFrameWidth<=0){this.mainFrameWidth = 800; }

                
                serverAddLog(-1, "set var 'serverRun' to true");   
                this.serverUpdate = true;
                if(this.port==-1) 
                    this.server = new ServerSocket(this.port);

                allLogsBool = false;
                lastLogsBool = false;
                currentLogsBool = true;
                sendUpdatedData = false;

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /** @param cfStrings : String[]
     * 
     *  @brief This function become called by Server.initialize(). Then the function will parse 'docs/server.cfg' with calling FileHandler. Then the called FileHandler method will return a array of rooms, or users, or messages to this function. Than this function will safe the data in the array of rooms, users, or messages. This function initialise data like position and size too. Parsed data: rooms, users, directChats, directMessage, Message, frameTitle, frameHeigth, frameWidth, frameX, frameY, frameMenuBarItem, frameMenuBarItem_QUIT, adress, framePanelRoomsHeigth, framePanelRoomsWidth, framePanelLogsHeigth, framePanelLogsHeigth, framePanelUsersHeigth, framePanelUsersWidth.
     */ 
    public void initializeUseServerCFG(String[] cfStrings){
        if(cfStrings != null){
            String mode = "";
            //serverAddLog(-1, "parsing data files...");
            //serverAddLog(-1, "|");
            for(int i=0; i<cfStrings.length; i++){
                if(i%2==0){    //Attributname
                    //System.out.println("i="+i+"Attribut: "+cfStrings[i]);
                    mode = cfStrings[i];
                    
                } else {         //Attributinhalt
                    //System.out.println("i="+i+"Wert"+cfStrings[i]+"\n");

                    if(mode.equals("Rooms")){   //important: the path of messages in server.cfg must be written before the path to rooms
                        this.pathToRooms = withIDE==true? cfStrings[i]:"../"+cfStrings[i];
                        this.rooms = fileHandler.parseRoomsCSV(pathToRooms);
                        for(int j=0; j<this.rooms.size(); j++){
                            this.rooms.get(j).setMessages(fileHandler.parseMessageCSV(pathToMessages, j));
                        } 
                        serverAddLog(-1, "|->'"+pathToRooms+" became parsed...");
                        serverAddLog(-1, "| '->parsed data: "+this.rooms.size()+" rooms");
                    } else if(mode.equals("Users")){
                        this.pathToUsers = withIDE==true? cfStrings[i]:"../"+cfStrings[i];
                        System.out.println(mode+"="+this.pathToUsers);
                        this.users = this.fileHandler.parseUserCSV(pathToUsers);

                        for(User user : this.users){
                            System.out.println("user: "+user.getUsername());
                        }
                        serverAddLog(-1, "|->'"+pathToUsers+" became parsed...");
                        serverAddLog(-1, "| '->parsed data: "+this.users.size());
                    } else if(mode.equals("DirectChat")){
                        this.pathToDirectChat = withIDE==true? cfStrings[i]:"../"+cfStrings[i];

                        this.directChats = new ArrayList<DirectChat>();
                        this.directChats = this.fileHandler.parseDirectChatCSV(pathToDirectChat);

                        for(DirectChat chat : this.directChats){
                            System.out.println("Direktname "+chat.getTitle()+" Nachrichten: "+chat.getNumOfMessages());
                        }
                        serverAddLog(-1, "|->'"+pathToDirectChat+" became parsed...");
                        serverAddLog(-1, "| '->parsed data: "+this.directChats.size());
                    } else if(mode.equals("DirectMessage")){
                        this.pathToDirectMessage = withIDE==true? cfStrings[i]:"../"+cfStrings[i];

                        for(int j=0; j<this.directChats.size(); j++){
                            ArrayList<DirectMessage> msg = this.fileHandler.parseDirectChatMessageCSV(pathToDirectMessage, j);

                    
                            for(DirectMessage messages : msg){
                                this.directChats.get(j).setMessage(messages);
                            }
                        }

                        int msgSum=0;
                        for(DirectChat chat : this.directChats){
                            msgSum += chat.getNumOfMessages();
                        }

                        serverAddLog(-1, "|->'"+pathToDirectMessage+" became parsed...");
                        serverAddLog(-1, "| '->parsed data: "+msgSum+" direct messages");
                    }
                    
                    else if(mode.equals("Messages")){
                        this.pathToMessages = withIDE==true? cfStrings[i]:"../"+cfStrings[i];
                    } else if(mode.equals("Log")){                        
                        this.pathToLog = withIDE==true? cfStrings[i]:"../"+cfStrings[i];  
                        serverAddLog(-1, "parsing data files...");
                        serverAddLog(-1, "|");
                        serverAddLog(-1, "|->'"+pathToLog+" became parsed...");
                        serverAddLog(-1, "| '->parsed data: "+this.logs.size());
                    } else if(mode.equals("frameTitle")){
                        this.mainFrameTitle = cfStrings[i];
                        this.mainFrame = new JFrame(this.mainFrameTitle);
                    } else if(mode.equals("frameHeight")){
                        this.mainFrameHeigth = Integer.parseInt(cfStrings[i]);
                    } else if(mode.equals("frameWidth")){
                        this.mainFrameWidth = Integer.parseInt(cfStrings[i]);
                    } else if(mode.equals("frameX")){
                        this.mainFrameX = Integer.parseInt(cfStrings[i]);
                    } else if(mode.equals("frameY")){
                        this.mainFrameY = Integer.parseInt(cfStrings[i]);
                    } else if(mode.equals("frameMenu")){
                        this.mainFrameMenu = new JMenu(cfStrings[i]);
                    } else if(mode.equals("frameMenuBarItem_QUIT")){
                        this.mainFrameMenuBarItem_QUIT = new JMenuItem(cfStrings[i]);
                        if(this.mainFrameMenu==null){this.mainFrameMenu = new JMenu("Menü"); }
                        if(this.mainFrameMenuBar==null){ this.mainFrameMenuBar = new JMenuBar();}

                        this.mainFrameMenuBarItem_QUIT.addActionListener(new ActionListener(){ @Override public void actionPerformed(ActionEvent ae){ System.exit(0); }});
                        this.mainFrameMenu.add(mainFrameMenuBarItem_QUIT);                   
                        this.mainFrameMenuBar.add(mainFrameMenu);
                        this.mainFrame.setJMenuBar(mainFrameMenuBar);
                    } else if(mode.equals("Port")){
                        this.port = Integer.parseInt(cfStrings[i]);
                        try{
                            this.server = new ServerSocket(this.port);
                            
                        } catch(IOException ioe){

                        }
                        
                    } else if(mode.equals("Adress")){
                        this.adress = cfStrings[i];
                    } 
                    //Panel ROoms
                    else if(mode.equals("framePanelRoomsHeigth")){
                        this.mainFrameJPanelRoomsHeigth = Integer.parseInt(cfStrings[i]);
                    } else if(mode.equals("framePanelRoomsWidth")){
                        this.mainFrameJPanelRoomsWidth = Integer.parseInt(cfStrings[i]);
                    } 
                    //Panel Users
                    else if(mode.equals("framePanelUsersHeigth")){
                        this.mainFrameJPanelUsersHeigth = Integer.parseInt(cfStrings[i]);
                    } else if(mode.equals("framePanelUsersWidth")){
                        this.mainFrameJPanelUsersWidth = Integer.parseInt(cfStrings[i]);
                    } 
                    //Panel Log
                    else if(mode.equals("framePanelLogHeigth")){
                        this.mainFrameJPanelLogHeigth = Integer.parseInt(cfStrings[i]);
                    } else if(mode.equals("framePanelLogWidth")){
                        this.mainFrameJPanelLogWidth = Integer.parseInt(cfStrings[i]);
                    } 

                    else if(mode.equals("frameHeadLineDimension")){
                        this.mainFrameHeadLineDimension = Integer.parseInt(cfStrings[i]);
                    } 
                } 
            }
        }
    }

    /** @author Staacke, Felix
     * 
     *  @brief This function starts the two threads, which are safed in Server.serverGUI and in Server.serverConntenctionListener.
     *  
     *  @date 16.10.2024 (normalerweise das letzte Edit-date, hier exemplarisch das heutige Datum)
     */
    public void run(){        

        this.serverRun= true;
        this.serverGUI.start();
        serverAddLog(-1, "starting GUI...");
        this.serverConntenctionListener.start();
        serverAddLog(-1, "starting connectionListener()...");
    }

    /** @author Staacke, Felix
     * 
     *  @brief This function contains a thread. This thread waits in the try-catch block for the server socket to be accepted by establishing a connection. The connection is stored in a temporary socket. The login process with the client takes place via this thread. Than the function calls the method Server.getUserIdentity(). The called method returns the index of the account. Than the socket of the user with the index become copied into the user-socket. Than the client will communicate with an Instance of the type User.
     * 
     */
    public void connectionListener(){
        try{
            System.out.println(this.server.getInetAddress() + " " + this.server.getLocalPort());
            while (this.serverRun) {
                Socket socket = server.accept();
                serverAddLog(-1, "socket("+ socket.getInetAddress()+"/"+socket.getLocalAddress()+":"+socket.getLocalPort()+") connected with ServerSocket");

                if (socket != null) {
                    
                    System.out.println("gebudnen");
                    Thread clientHandler = new Thread(() -> {
                    try {
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        String username = "";
                        String password = "";

                        while(username.equals("") && password.equals("")){
                            username = dis.readUTF();
                            password = dis.readUTF();
                        }
                        System.out.println(username + password);
                        //appendToFile(path_logfile, getDate()+";"+getTime()+";"+"Anmeldeversuch mit der Datenrelation: ("+username+","+password+")");

                        int userId = getUserIdentity(username, password);
                        System.out.println("L192: "+userId);
                        if(users.get(userId).getIsBanned() == true){
                            //appendToFile(path_logfile, getDate()+";"+getTime()+";"+"'-> Anfrage abgelehnt, da Nutzer gebannt");
                            socket.close();
                            serverUpdate = true;
                        }
                        if (userId > -1 && userId < users.size() && socket != null && users.get(userId).getIsBanned()==false) {
                            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                            dos.writeInt(userId);
                            users.get(userId).setIsOnline(socket, this);
                            //appendToFile(path_logfile, getDate()+";"+getTime()+";"+"Nutzer ("+username+", "+password+") geht online!");
                            serverUpdate = true;
                            sendUpdatedData = true;
                        } else{
                            System.out.println("Erneuter Anmeldeversuch geblockt!");
                        }
                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                });
                
                clientHandler.start(); // Start handling the client in a new thread
                }


                Thread.sleep(500);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /** @author Staacke, Felix
     *  
     *  @brief This function traverses the stored accounts (users). The method User.checkIdendity() is always used to check whether the login data is stored. If yes, the index of the account is returned. If not, a new account is created and the index of the new account is returned.
     * 
     *  @param username
     *  @param password
     *  @return
     */
    public int getUserIdentity(String username, String password){
        int result = -1;

        for(int i=0; i<this.users.size(); i++){
            if(this.users.get(i).checkIdentity(username, password)==true){result=i; System.out.println("user already existed");}
            
        }



        if(result ==-1 ){
            int newIdx = this.users.size();
            this.serverAddUser(new User(newIdx, username, password), password);
            result = newIdx;
        }

        System.out.println(result);

        return result;
    }

    /** @author Staacke, Felix
     *  @author the other student
     * 
     *  @brief do graphical stuff
     * 
     * @todo reimplement the function
     * @todo implement one default dashboard 
     * 
     */
    public void serverGUI() {
        mainFrame = new JFrame("Server GUI::Sitzung "+this.serverSitzung);
        mainFrame.setBounds(mainFrameX, mainFrameY, mainFrameWidth, mainFrameHeigth);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        if(this.mainFrameMenu==null || this.mainFrameMenuBar==null || this.mainFrameMenuBarItem_QUIT==null){
            this.mainFrameMenu = new JMenu("Anwendung");
            this.mainFrameMenuBar = new JMenuBar();
            this.mainFrameMenuBarItem_QUIT = new JMenuItem("Beenden");
            this.mainFrameMenuBarItem_QUIT.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae){
                    System.exit(0);
                }
            });
            this.mainFrameMenu.add(this.mainFrameMenuBarItem_QUIT);
            this.mainFrameMenuBar.add(this.mainFrameMenu);
        }


        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        mainFrameJPanelRooms = createPanel("Räume", mainFrameJPanelRoomsWidth, mainFrameJPanelRoomsHeigth);
        //mainFrameJPanelRooms.setLayout(new BoxLayout(mainFrameJPanelRooms, BoxLayout.Y_AXIS));
        addPanelToContent(content, mainFrameJPanelRooms, gbc, 0, 0);

        mainFrameJPanelUsers = createPanel("Benutzer", mainFrameJPanelUsersWidth, mainFrameJPanelUsersHeigth);
        addPanelToContent(content, mainFrameJPanelUsers, gbc, 0, 1);

        mainFrameJPanelLog = createPanel("Log", mainFrameJPanelLogWidth, mainFrameJPanelLogHeigth);
        addPanelToContent(content, mainFrameJPanelLog, gbc, 0, 2);

        mainFrame.add(content);
        mainFrame.setVisible(true);
        this.serverUpdate = true;

        try {
            while (serverRun) {
                if (this.serverUpdate==true) {
                    this.mainFrame.setJMenuBar(this.mainFrameMenuBar);
                    serverGUI_JPanel_Rooms_repaint();
                    serverGUI_JPanel_Users_repaint();
                    serverGUI_JPanel_Log_repaint();
                    this.mainFrame.repaint();
                }

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** @author Staacke, Felix
     *  @author the other student
     * 
     *  @brief do graphical Stuff
     * 
     */
    public void serverGUI_JPanel_Log_repaint(){
        mainFrameJPanelLog.removeAll();
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(mainFrameJPanelLog.getWidth(), 250));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("<html><h"+this.mainFrameHeadLineDimension+"><center>Log-Datei</center></h"+this.mainFrameHeadLineDimension+"></html>"));

        ScrollPane log_content = new ScrollPane();
        String[] columnNames = {"Sitzung", "Datum", "Uhrzeit","Rolle","Inhalt"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        ArrayList<Log> logs = new ArrayList<>();
        logs = this.fileHandler.parseLogs(pathToLog);

        

        JButton allLogs = new JButton("Log-Einträge aller Sitzungen: " + (allLogsBool==true ? "eingeblendet" : "ausgeblendet"));
        allLogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(allLogsBool==true){
                    allLogsBool=false;
                } else{
                    allLogsBool=true;
                }
                serverUpdate=true;
            }
        });
        JButton lastLogs = new JButton("Log-Einträge der letzten Sitzung" + (lastLogsBool==true ? "eingeblendet" : "ausgeblendet"));
        lastLogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lastLogsBool==true){
                    lastLogsBool=false;
                } else{
                    lastLogsBool=true;
                }
                serverUpdate=true;
            }
        });
        JButton currentLogs = new JButton("Log-Einträge der aktuellen Sitzung" + (currentLogsBool==true ? "eingeblendet" : "ausgeblendet"));
        currentLogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentLogsBool==true){
                    currentLogsBool=false;
                } else{
                    currentLogsBool=true;
                }
                serverUpdate=true;
            }
        });
        
        panel.add(allLogs);
        panel.add(lastLogs);
        panel.add(currentLogs);
        
        

        if(allLogsBool==true){
            for(int i=0;i<logs.size(); i++){
                if(serverSitzung-1 >= 0 && logs.get(i).getSitzung()<serverSitzung-1){
                    model.addRow(new Object[]{logs.get(i).getSitzung(),logs.get(i).getDate(),logs.get(i).getTime(),(logs.get(i).getRoll() == -1 ? "[SERVER]" : users.get(logs.get(i).getRoll()).getUsername()),logs.get(i).getContent()});
                }
            }
        }
        if(lastLogsBool==true){
            for(int i=0;i<logs.size(); i++){
                if(serverSitzung-1 >= 0 && logs.get(i).getSitzung()==serverSitzung-1){
                    model.addRow(new Object[]{logs.get(i).getSitzung(),logs.get(i).getDate(),logs.get(i).getTime(),(logs.get(i).getRoll() == -1 ? "[SERVER]" : users.get(logs.get(i).getRoll()).getUsername()),logs.get(i).getContent()});
                }
            }
        }
        if(currentLogsBool==true){
            for(int i=0;i<logs.size(); i++){
                if(logs.get(i).getSitzung()==serverSitzung){
                    model.addRow(new Object[]{logs.get(i).getSitzung(),logs.get(i).getDate(),logs.get(i).getTime(),(logs.get(i).getRoll() == -1 ? "[SERVER]" : users.get(logs.get(i).getRoll()).getUsername()),logs.get(i).getContent()});
                }
            }


            
        }
        

        JTable table = new JTable(model);

         table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        log_content.add(table);
        panel.add(log_content);
        mainFrameJPanelLog.add(panel);
        mainFrameJPanelLog.repaint();
    }

    /** @author Staacke, Felix
     * 
     *  @brief do graphical stuff
     *  
     */
    public void serverGUI_JPanel_Users_repaint(){
        mainFrameJPanelUsers.removeAll();

        mainFrameJPanelUsers.setLayout(new GridLayout(1, 4));

        JPanel mainFrameJPanelUsersNewUser = new JPanel();
        mainFrameJPanelUsersNewUser.setLayout(new BoxLayout(mainFrameJPanelUsersNewUser, BoxLayout.Y_AXIS));
        mainFrameJPanelUsersNewUser.add(new JLabel("<html><h"+this.mainFrameHeadLineDimension+"><center>neuer Raum</center></h"+this.mainFrameHeadLineDimension+"></html>"));
        JButton newUser = new JButton("Neuer Account");
        mainFrameJPanelUsersNewUser.add(newUser);

        JPanel mainFrameJPanelUsersOnlineUsers = new JPanel();
        mainFrameJPanelUsersOnlineUsers.setLayout(new BoxLayout(mainFrameJPanelUsersOnlineUsers, BoxLayout.Y_AXIS));
        mainFrameJPanelUsersOnlineUsers.add(new JLabel("<html><h"+this.mainFrameHeadLineDimension+">Online Benutzer</h"+this.mainFrameHeadLineDimension+"></html>"));
        for(int i=0; i<this.users.size();i++){
            final int k = i;
            JLabel label = new JLabel(this.users.get(i).getUsername());
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    JFrame onlineUsers = new JFrame();
                    onlineUsers.setSize(new Dimension(300,300));
                    JPanel content = new JPanel();
                    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

                    content.add(new JLabel("Benutzername: "+users.get(k).getUsername()));
                    content.add(new JLabel("Raum:"+rooms.get(users.get(k).getUserSeletedRoom()).getTitle()));

                    JButton directChat = new JButton("Direktnachricht");
                    directChat.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            onlineUsers.setVisible(false);
                            
                            serverDirectChat(k);
                          
                        }
                    });
                    content.add(directChat);

                    content.add(new JLabel("wurde bereits gekickt: "+users.get(k).getUserKickCounter()+"mal"));

                    JTextField tfverwarnen = new JTextField("Begründung");
                    tfverwarnen.addKeyListener(new KeyListener() {
                        @Override public void keyTyped(KeyEvent e) { }
                        @Override public void keyReleased(KeyEvent e) { }
                        @Override
                        public void keyPressed(KeyEvent e) {
                            serverUserVerwarnen(k, tfverwarnen.getText());
                            serverUpdate = true;
                        }
                        
                    }); 
                    content.add(tfverwarnen);

                    JButton verwarnen = new JButton("Verwarnen");
                    verwarnen.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serverUserVerwarnen(k, tfverwarnen.getText());
                            serverUpdate = true;
                            sendUpdatedData =true;
                            onlineUsers.setVisible(false);
                        }
                    });
                    content.add(verwarnen);

                    JButton kick = new JButton("Kick");
                    kick.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serverUserKick(k);
                            serverUpdate = true;
                            sendUpdatedData=true;
                            onlineUsers.setVisible(false);
                        }
                    });
                    content.add(kick);

                    JButton ban = new JButton("Ban");
                    ban.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serverUserBan(k);
                            serverUpdate = true;
                            sendUpdatedData=true;
                            onlineUsers.setVisible(false);
                        }
                    });
                    content.add(ban);
                    content.add(directChat);
                    
                    onlineUsers.add(content);
                    onlineUsers.setVisible(true);
                }
                @Override public void mouseEntered(MouseEvent e) { }
                @Override public void mouseExited(MouseEvent e) { }
                @Override public void mousePressed(MouseEvent e) { }
                @Override public void mouseReleased(MouseEvent e) { }
            });
            if(users.get(i).getIsOnline()==true && users.get(i).getIsBanned() ==false){mainFrameJPanelUsersOnlineUsers.add(label); }
        }

        JPanel mainFrameJPanelUsersOffineUsers = new JPanel();
        mainFrameJPanelUsersOffineUsers.setLayout(new BoxLayout(mainFrameJPanelUsersOffineUsers, BoxLayout.Y_AXIS));
        mainFrameJPanelUsersOffineUsers.add(new JLabel("<html><h"+this.mainFrameHeadLineDimension+">Offline Benutzer</h"+this.mainFrameHeadLineDimension+"></html>"));
        for(int i=0; i<this.users.size();i++){
            final int k=i;
            JLabel label = new JLabel(this.users.get(i).getUsername());
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    JFrame onlineUsers = new JFrame();
                    onlineUsers.setSize(new Dimension(300,300));
                    JPanel content = new JPanel();
                    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

                    content.add(new JLabel("Benutzername: "+users.get(k).getUsername()));
                    content.add(new JLabel("Raum:"+rooms.get(users.get(k).getUserSeletedRoom()).getTitle()));
                    content.add(new JLabel("wurde bereits gekickt: "+users.get(k).getUserKickCounter()+"mal"));

                    JButton directChat = new JButton("Direktnachricht");
                    directChat.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            onlineUsers.setVisible(false);
                            serverDirectChat(k);
                        }
                    });
                    content.add(directChat);

                    JTextField tfverwarnen = new JTextField("Begründung");
                    tfverwarnen.addKeyListener(new KeyListener() {
                        @Override public void keyTyped(KeyEvent e) { }
                        @Override public void keyReleased(KeyEvent e) { }
                        @Override
                        public void keyPressed(KeyEvent e) {
                            serverUserVerwarnen(k, tfverwarnen.getText());
                            sendUpdatedData= true;
                        }
                        
                    }); 
                    content.add(tfverwarnen);

                    JButton verwarnen = new JButton("Verwarnen");
                    verwarnen.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serverUserVerwarnen(k, tfverwarnen.getText());
                            sendUpdatedData=true;
                            onlineUsers.setVisible(false);
                        }
                    });
                    content.add(verwarnen);

                    JButton ban = new JButton("Ban");
                    ban.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serverUserBan(k);
                            sendUpdatedData=true;
                            onlineUsers.setVisible(false);
                        }
                    });
                    content.add(ban);

                    onlineUsers.add(content);
                   
                    onlineUsers.setVisible(true);
                }
                @Override public void mouseEntered(MouseEvent e) { }
                @Override public void mouseExited(MouseEvent e) { }
                @Override public void mousePressed(MouseEvent e) { }
                @Override public void mouseReleased(MouseEvent e) { }
            });
            if(users.get(i).getIsOnline()==false && users.get(i).getIsBanned()==false){mainFrameJPanelUsersOffineUsers.add(label); }
        }

        JPanel mainFrameJPanelUsersBannedUsers = new JPanel();
        mainFrameJPanelUsersBannedUsers.setLayout(new BoxLayout(mainFrameJPanelUsersBannedUsers, BoxLayout.Y_AXIS));
        mainFrameJPanelUsersBannedUsers.add(new JLabel("<html><h"+this.mainFrameHeadLineDimension+">Offline Benutzer</h"+this.mainFrameHeadLineDimension+"></html>"));
        for(int i=0; i<this.users.size();i++){
            final int k=i;
            JLabel label = new JLabel(this.users.get(i).getUsername());
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    JFrame onlineUsers = new JFrame();
                    JPanel content = new JPanel();
                    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

                    content.add(new JLabel("Benutzername: "+users.get(k).getUsername()));
                    content.add(new JLabel("Raum:"+rooms.get(users.get(k).getUserSeletedRoom()).getTitle()));
                    content.add(new JLabel("wurde bereits gekickt: "+users.get(k).getUserKickCounter()+"mal"));
                    

                    onlineUsers.add(content);
                    onlineUsers.pack();
                    onlineUsers.setVisible(true);
                }
                @Override public void mouseEntered(MouseEvent e) { }
                @Override public void mouseExited(MouseEvent e) { }
                @Override public void mousePressed(MouseEvent e) { }
                @Override public void mouseReleased(MouseEvent e) { }
            });
            if(users.get(i).getIsBanned()==true){mainFrameJPanelUsersBannedUsers.add(label); }
        }

        
        mainFrameJPanelUsers.add(mainFrameJPanelUsersNewUser);
        mainFrameJPanelUsers.add(mainFrameJPanelUsersOnlineUsers);
        mainFrameJPanelUsers.add(mainFrameJPanelUsersOffineUsers);
        mainFrameJPanelUsers.add(mainFrameJPanelUsersBannedUsers);
        mainFrameJPanelUsers.repaint();
    }

    /** @author Staacke, Felix
     * 
     *  @brief This method generate a new Frame. This frame contains an input dialog, to send a direct chat message to the user.
     * 
     *  @todo do not spawn a own Frame. Repaint the Server Main Frame. Show the dialog instead of the dashboard.
     * 
     * @param idx
     */
    public void serverDirectChat(int idx) {
        JFrame directChatFrame = new JFrame();
        //this.directChats = this.fileHandler.parseDirectChatCSV(pathToDirectChat);
        directChatFrame.setTitle(idx < this.users.size() ? this.users.get(idx).getUsername() : Integer.toString(idx));

        JPanel content = new JPanel();

        //if (this.directChats.get(idx).getIsCorrectChat(-1, idx)) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            System.out.println("Direktchat Nr. " + idx + "|Nachrichten| = " + this.directChats.get(idx).getNumOfMessages());

            for (int i = this.directChats.get(idx).getNumOfMessages()-1; i >= 0 ; i--) {
                panel.add(new JLabel("   "+
                        this.directChats.get(idx).getMessage(i).getDate() + "  |  "+
                                this.directChats.get(idx).getMessage(i).getTime() + "  |  "+
                                this.directChats.get(idx).getMessage(i).getContent()));
            }

            JTextField tf = new JTextField("Neue Direktnachricht");
            tf.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        serverAddDirectChatMessage(idx, directChats.get(idx).getIdx1(), directChats.get(idx).getIdx2(), tf.getText());
                        serverUpdate = true;
                        sendUpdatedData = true;
                    }
                }
                @Override public void keyReleased(KeyEvent e) { }
                @Override public void keyTyped(KeyEvent e) { }

            });
            JButton button = new JButton("Absenden");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    serverAddDirectChatMessage(idx, directChats.get(idx).getIdx1(), directChats.get(idx).getIdx2(), tf.getText());
                    panel.add(new JLabel("   "+
                        directChats.get(idx).getMessage(directChats.get(idx).getNumOfMessages()-1).getDate() + "  |  "+
                                directChats.get(idx).getMessage(directChats.get(idx).getNumOfMessages()-1).getTime() + "  |  "+
                                directChats.get(idx).getMessage(directChats.get(idx).getNumOfMessages()-1).getContent()));
                                serverUpdate = true;
                            }
            });

            content.add(tf);
            content.add(button);

            // Erstelle eine JScrollPane und füge das Panel hinzu
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setPreferredSize(new Dimension(400, 400));

            content.add(scrollPane);
       /**  } else {
            content.add(new JLabel(
                    "Bisher kein Direktchat eröffnet. Klicke Knopf im neuen Chat zu öffnen!"));

            JButton button = new JButton("Neuer Direktchat");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    serverAddDirectChat("Server" + users.get(idx).getUsername(), directChats.size(), idx);
                }
            });

            // Füge den Button zum content Panel hinzu
            content.add(button);
        }*/

        content.setBounds(0, 0, 400, 400);
        directChatFrame.add(content);
        directChatFrame.setSize(new Dimension(400, 500));
        directChatFrame.setVisible(true);
    }

    /** @author Staacke, Felix
     * 
     *  @brief do graphical stuff
     * 
     */
    public void serverGUI_JPanel_Rooms_repaint() {
        mainFrameJPanelRooms.removeAll();

        mainFrameJPanelRooms.setLayout(new GridLayout(1, 3));

        JPanel panelNewRoom = new JPanel();
        //panelNewRoom.setLayout(new BoxLayout(mainFrameJPanelRooms, BoxLayout.Y_AXIS));
        panelNewRoom.setSize(new Dimension(200,50));
        JButton buttonNewRoom = new JButton("Neuen Raum erstellen");
        JTextField tfNewRoom = new JTextField("Raumname");
        tfNewRoom.setPreferredSize(new Dimension(panelNewRoom.getWidth(), 30));

        JTextArea taNewRoom = new JTextArea("Beschreibung");
        taNewRoom.setPreferredSize(new Dimension(panelNewRoom.getWidth(), 140));

        tfNewRoom.addKeyListener(new KeyListener() {
            @Override public void keyTyped(KeyEvent e) { }
            @Override public void keyReleased(KeyEvent e) { }

            @Override public void keyPressed(KeyEvent e) {                
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    serverAddRoom(new Room(serverGetNewRoomIdx(), tfNewRoom.getText(), taNewRoom.getText()));
                    tfNewRoom.setText("Raumname");
                    taNewRoom.setText("Beschreibung");
                    serverUpdate = true;
                } } });
        
        taNewRoom.addKeyListener(new KeyListener() {
            @Override public void keyTyped(KeyEvent e) { }
            @Override public void keyReleased(KeyEvent e) { }

            @Override public void keyPressed(KeyEvent e) {                
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    serverAddRoom(new Room(serverGetNewRoomIdx(), tfNewRoom.getText(), taNewRoom.getText()));
                    tfNewRoom.setText("Raumname");
                    taNewRoom.setText("Beschreibung");
                    serverUpdate = true;
                } } });
        buttonNewRoom.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent ae){
                serverAddRoom(new Room(serverGetNewRoomIdx(), tfNewRoom.getText(), taNewRoom.getText()));
                tfNewRoom.setText("Raumname");
                    taNewRoom.setText("Beschreibung");
                    serverUpdate = true;
            }
        });
        panelNewRoom.add(tfNewRoom);
        panelNewRoom.add(taNewRoom);
        panelNewRoom.add(buttonNewRoom);
        mainFrameJPanelRooms.add(panelNewRoom);

        JPanel showRooms = new JPanel();
        showRooms.setLayout(new BoxLayout(showRooms, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = createScrollPane();
        showRooms.add(scrollPane);

        mainFrameJPanelRooms.add(showRooms);

        

        mainFrameJPanelRooms.revalidate();
        mainFrameJPanelRooms.repaint();

        this.serverUpdate = false;
    }

    /** @author Staacke, Felix  
     * 
     * @brief do graphical stuff
     * 
     * @return
     */
    public JScrollPane createScrollPane() {
        JPanel roomsPanel = new JPanel();
        roomsPanel.setLayout(new BoxLayout(roomsPanel, BoxLayout.Y_AXIS));

        roomsPanel.add(createHeaderLabel());

        String[] columnNames = {"Raumname", "Raumbeschreibung"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Room room : rooms) {    
            model.addRow(new Object[]{room.getTitle(), room.getDiscribtion()});

        }

        JTable table = new JTable(model);

         table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    System.out.println("Row " + row + " wurde geändert in Spalte " + col);
                }
            }
        });

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int selectedRow2 = -1;
                if (selectedRow != -1) {
                    System.out.println("Ich wurde angeklickt: " + selectedRow+rooms.get(selectedRow).getTitle());

                    JFrame editRoom = new JFrame();

                    JPanel editRoomPanel = new JPanel();

                    String[] messagesNames = {"Datum","Zeit", "Benutzer", "Nachricht"};
                    DefaultTableModel model2 = new DefaultTableModel(messagesNames, 0);

                    for(int i=0; i<rooms.get(selectedRow).getNumOfMessages(); i++){
                        System.out.println(selectedRow);
                        model2.addRow(new Object[]{ rooms.get(selectedRow).getMessage(i).getMessageDate(), 
                            rooms.get(selectedRow).getMessage(i).getMessageTime(), 
                            Integer.toString(rooms.get(selectedRow).getMessage(i).getMessageUserId()), 
                            rooms.get(selectedRow).getMessage(i).getMessageContent()});
                    }
                    
                    JTable table2 = new JTable(model2);
                    table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    table2.addMouseListener(new MouseListener() {
                        boolean roomSelected = false;
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // TODO Auto-generated method stub
                            int selectedRow2= table2.getSelectedRow();
                            //System.out.println(rooms.get(selectedRow).getMessage(selectedRow2).getMessageContent()); 

                            if(selectedRow2 >-1 && roomSelected==false){
                                JButton verwarnen = new JButton("Verwarnen");
                                verwarnen.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // TODO Auto-generated method stub
                                        serverUserVerwarnen(rooms.get(selectedRow).getMessage(selectedRow2).getMessageUserId());
                                    }   
                                });
                                roomSelected = true;
                                editRoomPanel.add(verwarnen);
                                serverUpdate = true;
                                editRoom.pack();
                                editRoom.repaint();
                                System.out.println("ausgewählt");
                                
                            } 
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // TODO Auto-generated method stub
                            
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            // TODO Auto-generated method stub
                            
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            // TODO Auto-generated method stub
                            
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            // TODO Auto-generated method stub
                            
                        }
                    });
            
                    JScrollPane scrollPane2 = new JScrollPane(table2);
                    scrollPane2.setPreferredSize(new Dimension(400, 150));
                    scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
                    editRoomPanel.add(scrollPane2, BorderLayout.CENTER);

                    editRoomPanel.add(new JLabel("Raumname: "));
                    JTextField editRoomTf = new JTextField(rooms.get(selectedRow).getTitle());
                    editRoomPanel.add(editRoomTf);
                    editRoomPanel.add(new JLabel("Raumbeschreibung: "));
                    JTextField editRoomTa = new JTextField(rooms.get(selectedRow).getDiscribtion());
                    editRoomPanel.add(editRoomTa);

                    int inUse=0;
                    for(User user : users){
                        if(user.getIsOnline()==true){ inUse++; }
                    }
                    editRoomPanel.add(new JLabel("wird benutzt: "+inUse));

                    JButton safe = new JButton("Änderungen sichern");
                    safe.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serverEdtRoom(selectedRow, editRoomTf.getText(), editRoomTa.getText());
                            editRoom.setVisible(false);
          
                        }
                    });
                    editRoomPanel.add(safe);

                    JButton delete = new JButton("Löschen");
                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            serverDelRoom(selectedRow);     
                            editRoom.setVisible(false);                       
                        }
                    });
                    editRoomPanel.add(delete);

                    editRoom.add(editRoomPanel);
                    editRoom.pack();
                    editRoom.setLocation(300, 500); //TODO: überdenke die Position
                    editRoom.setVisible(true);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });


        JScrollPane scrollPane = new JScrollPane(table);
        roomsPanel.add(scrollPane);

        return new JScrollPane(roomsPanel);
    }

    /** @author Staacke, Felix  
     * 
     * @brief do graphical stuff
     * 
     * @return
     */
    private JLabel createHeaderLabel() {
        return new JLabel("<html><body><b><h" + mainFrameHeadLineDimension + ">Räume</h" + mainFrameHeadLineDimension + "></b></html>");
    }



    /** @author Staacke, Felix
     * 
     * @brief do graphical stuff
     * 
     * @param labelText
     * @return
     */
    private JPanel createLinePanel(String labelText) {
        JPanel linePanel = new JPanel();
        linePanel.setLayout(new FlowLayout());
        linePanel.add(new JLabel(labelText));
        linePanel.setAlignmentX(Component.TOP_ALIGNMENT); // Oberer Rand ausrichten
        linePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Fester Abstand
        return linePanel;
    }

    
    /** @author Staacke, Felix
     * 
     * @brief do graphical stuff
     * 
     * @param labelText
     * @param width
     * @param height
     * @return
     */
    private JPanel createPanel(String labelText, int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(new JLabel(labelText));
        return panel;
    }

    /** @author Staacke, Felix
     * 
     * @brief do graphical Stuff
     * 
     * @param content
     * @param panel
     * @param gbc
     * @param gridx
     * @param gridy
     */
    private void addPanelToContent(JPanel content, JPanel panel, GridBagConstraints gbc, int gridx, int gridy) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        content.add(new JScrollPane(panel), gbc);
    }

   
    /** @author Staacke, Felix
     * 
     * @brief This server adds a message into a room.
     * 
     * @param message
     * @param room
     */
    public void serverAddMessage(Message message, int room){
        this.rooms.get(room).addMessage(message);
        String del = message.getMessageIsDeleted()==true? "1":"0";
        this.serverAppendToFile(1, message.getMessageType()+";"+message.getMessageDate()+";"+message.getMessageTime()+";"+message.getMessageContent()+";"+message.getMessageUserId()+";"+del+";"+room);
        serverUpdate=true;
    }

    /** @author the other student
     * 
     * @brief This server adds a new Room to the server.
     * 
     * @param room
     */
    public void serverAddRoom(Room room){
        this.rooms.add(room);
        //this.serverAppendToFile(0, serverGetNewRoomIdx()+";"+room.getTitle()+";"+room.getDiscribtion());
        serverUpdate=true;
    }

    /** @author Staacke, Felix
     * 
     * @brief This method adds a new User-Account to the server.
     * 
     * @param user
     * @param password
     */
    public void serverAddUser(User user, String password){
        this.users.add(user);
        int id = this.users.get(this.users.size()-1).getUserIdentity()+1;
        String str = Integer.toString(id)+
                        ";"+user.getUsername()+
                        ";"+password+
                        ";"+(user.getIsOnline()==true ? "1":"0")+
                        ";"+user.getUserSeletedRoom()+
                        ";"+(user.getIsVerwarnt()==true ? "1":"0")+
                        ";"+(user.getIsKicked()==true ? "1":"0")+
                        ";"+user.getUserKickCounter()+
                        ";"+(user.getIsBanned()==true ? "1":"0")+
                        ";"+user.getUserRegistrationDate()+
                        ";"+user.getUserRegistrationTime()+
                        ";"+user.getUserLastLoginDate()+
                        ";"+user.getUserLastLoginTime();
        this.serverAppendToFile(2, str);
        serverUpdate=true;
    }

    /** @author the other student
     * 
     * @brief This method gets the highest index of the rooms. Than the highest index incremented by 1 become the index for a new room.
     * 
     * @return
     */
    public int serverGetNewRoomIdx(){
        int result =-1;

        result = this.rooms.get(this.rooms.size()-1).getIdx()+1;

        return result;
    }

    /** @author Staacke, Felix
     * 
     * @brief This method class MyFileHandler.appendToFile() to append an entry into a file.
     * 
     * @param mode
     * @param content
     */
    public void serverAppendToFile(int mode, String content){
        if(mode == 0){ //new room
            this.fileHandler.appendToFile(pathToRooms, content);
        } else if(mode == 1){ //new message
            this.fileHandler.appendToFile(pathToMessages, content);
        } else if(mode == 2){ //new user
            this.fileHandler.appendToFile(pathToUsers, content);
        } else if(mode == 3){ //new log entry
            this.fileHandler.appendToFile(pathToLog, content);
        } else if(mode == 4){   //direct chat
            this.fileHandler.appendToFile(pathToDirectChat, content);
        } else if(mode == 5){   //direct chat messages
            this.fileHandler.appendToFile(pathToDirectMessage, content);
        }
        serverUpdate=true;
    }

    /** @author the other student
     * 
     * @brief This method removes a romm from the class var. Than the method MyFileHandler.overwriteFile() become called. This deletes the entry with the selected room.
     * 
     * @param idx
     */
    public void serverDelRoom(int idx){
        this.rooms.remove(idx);
        this.fileHandler.overwriteFile(pathToRooms, idx);
        serverUpdate=true;
    }

    /** @author the other student 
     * 
     * @brief This method edit an existing room. The data of one room become reinitialised. The method MyFileHandler.overwriteFile() become called.
     * 
     * @param idx
     * @param content1
     * @param content2
     */
    public void serverEdtRoom(int idx, String content1, String content2){
        if(!content1.equals("")){//title
            this.rooms.get(idx).setTitle(content1);
            this.fileHandler.overwriteFile(pathToRooms, idx, idx+";"+content1+";"+this.rooms.get(idx).getDiscribtion());
        }
        if(!content2.equals("")){//discribtion
            this.rooms.get(idx).setDiscribtion(content2);
            this.fileHandler.overwriteFile(pathToRooms, idx, idx+";"+this.rooms.get(idx).getTitle()+";"+content2);
        }
        this.serverUpdate = true;
    }

    /** @author the other student
     * 
     * @brief This method 
     * 
     * @param user
     * @param content
     */
    public void serverAddLog(int user, String content){//Servers user id is -1
        if(this.logs != null){ this.logs.add(new Log(serverSitzung, getDate(), getTime(), user, content));}
        this.fileHandler.appendToFile(pathToLog, serverSitzung+";"+getDate()+";"+getTime()+";"+user+";"+content);
        serverUpdate = true;
    }

    /**@author the other student
     * 
     * @brief This adds a direct-chat-message into Server.directsChats and calls MyFileHandler.serverAppendToFile().
     * 
     * @param idx
     * @param idx1
     * @param idx2
     * @param content
     */
    public void serverAddDirectChatMessage(int idx, int idx1, int idx2, String content){//Servers user id is -1
        this.directChats.get(idx).setMessage(new DirectMessage(idx, 0, content, getDate(), getTime()));
        serverAppendToFile(5, idx+";"+0+";"+content+";"+getDate()+";"+getTime());    
        serverUpdate = true;
    }

    /** @author the other student
     * 
     * @brief This method adds a new Direct-Chat to Server.directChats and calls MyFileHandler.serverAppendToFile().
     * 
     * @param title
     * @param idx
     * @param idxU
     */
    public void serverAddDirectChat(String title, int idx, int idxU){
        this.directChats.add(new DirectChat(this.directChats.size(), idx, idxU, title));
        serverAppendToFile(4, idx+";"+-1+";"+idxU+";"+title);
        this.serverUpdate = true;
    }

    /** @author the other student 
     * 
     * @brief This method warns a user. The method MyFileHandler.overwriteFile() become called.
     * 
     * @param idx
     */
    public void serverUserVerwarnen(int idx){
        System.out.println("ich verwarnen"+idx);
        this.users.get(idx).setUserIsVerwarned("Sie wurden verwarnt!");
        String online = this.users.get(idx).getIsOnline()==true?"1":"0";
        String kicked = this.users.get(idx).getIsKicked()==true?"1":"0";
        String banned = this.users.get(idx).getUserIsBanned()==true?"1":"0";
        
        String str = idx+
                        ";"+this.users.get(idx).getUsername()+
                        ";"+this.users.get(idx).getHashedPassword()+
                        ";"+online+
                        ";"+this.users.get(idx).getUserSeletedRoom()+
                        ";"+"1"+
                        ";"+kicked+
                        ";"+this.users.get(idx).getUserKickCounter()+
                        ";"+banned+
                        ";"+this.users.get(idx).getUserRegistrationDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime()+
                        ";"+this.users.get(idx).getUserLastLoginDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime();
        this.fileHandler.overwriteFile(pathToUsers, idx, str);
        this.serverUpdate = true;
    }

    /** @author the other student
     * 
     * @brief This method warns a user. The method MyFileHandler.overwriteFile() become called.
     * 
     * @param idx
     * @param content
     */
    public void serverUserVerwarnen(int idx, String content){
        System.out.println("ich verwarnen"+idx);
        this.users.get(idx).setUserIsVerwarned(content);
        String online = this.users.get(idx).getIsOnline()==true?"1":"0";
        String kicked = this.users.get(idx).getIsKicked()==true?"1":"0";
        String banned = this.users.get(idx).getUserIsBanned()==true?"1":"0";
        
        String str = idx+
                        ";"+this.users.get(idx).getUsername()+
                        ";"+this.users.get(idx).getHashedPassword()+
                        ";"+online+
                        ";"+this.users.get(idx).getUserSeletedRoom()+
                        ";"+"1"+
                        ";"+kicked+
                        ";"+this.users.get(idx).getUserKickCounter()+
                        ";"+banned+
                        ";"+this.users.get(idx).getUserRegistrationDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime()+
                        ";"+this.users.get(idx).getUserLastLoginDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime();
        System.out.println(this.pathToUsers);
        this.fileHandler.overwriteFile(pathToUsers, idx, str);
        this.serverUpdate = true;
    }

    /** @author the other student
     * 
     * @brief This method kicks a user from the server. The Method MyFileHandler.overwriteFile() become called.
     * 
     * @param idx
     */
    public void serverUserKick(int idx){
        System.out.println("ich kicke"+idx);
        this.users.get(idx).setUserIsKicked();
        String online = this.users.get(idx).getIsOnline()==true?"1":"0";
        String verwarnt = this.users.get(idx).getIsVerwarnt()==true?"1":"0";
        String banned = this.users.get(idx).getUserIsBanned()==true?"1":"0";

        String str = idx+
                        ";"+this.users.get(idx).getUsername()+
                        ";"+this.users.get(idx).getHashedPassword()+
                        ";"+online+
                        ";"+this.users.get(idx).getUserSeletedRoom()+
                        ";"+verwarnt+
                        ";"+"1"+
                        ";"+this.users.get(idx).getUserKickCounter()+
                        ";"+banned+
                        ";"+this.users.get(idx).getUserRegistrationDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime()+
                        ";"+this.users.get(idx).getUserLastLoginDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime();
        this.fileHandler.overwriteFile(pathToUsers, idx, str);
        this.serverUpdate = true;
    }

    /** @author the other student
     * 
     * @brief This server bans a user. The method MyFileHandler.overwriteFile() become called.
     * 
     * @param idx
     */
    public void serverUserBan(int idx){
        System.out.println("ich banne"+idx);
        this.users.get(idx).setUserIsBannd();
        String online = this.users.get(idx).getIsOnline()==true?"1":"0";
        String verwarnt = this.users.get(idx).getIsVerwarnt()==true?"1":"0";
        String kicked = this.users.get(idx).getIsKicked()==true?"1":"0";      

        String str = idx+
                        ";"+this.users.get(idx).getUsername()+
                        ";"+this.users.get(idx).getHashedPassword()+
                        ";"+online+
                        ";"+this.users.get(idx).getUserSeletedRoom()+
                        ";"+verwarnt+
                        "M"+kicked+
                        ";"+this.users.get(idx).getUserKickCounter()+
                        ";"+"1"+
                        ";"+this.users.get(idx).getUserRegistrationDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime()+
                        ";"+this.users.get(idx).getUserLastLoginDate()+
                        ";"+this.users.get(idx).getUserLastLoginTime();
        this.fileHandler.overwriteFile(pathToUsers, idx, str);
        this.serverUpdate = true;
    }

    /** @author the other student
     * 
     * @brief This method returns the current Date in String format. 
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

    /**@author the other student
     * 
     * @brief This method returns the current time in String format.
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
     * @return
     */
    public int getNumOfUsers(){
        return this.users.size();
    }

    /**@author the other student
     * 
     * @param idx
     * @return
     */
    public User getUser(int idx){
        System.out.println("SERVER username = "+this.users.get(idx).getUsername());
        return this.users.get(idx);
    }

    /**@author the other student
     * 
     * @return
     */
    public int getNumOfRooms(){
        return this.users.size();
    }

    /**@author the other student
     * 
     * @param idx
     * @return
     */
    public Room getRoom(int idx){
        return this.rooms.get(idx);
    }

    /**@author the other student
     * 
     * @return
     */
    public int getNumOfDirectChat(){
        return this.directChats.size();
    }

    /**@author the other student
     * 
     * @param idx
     * @return
     */
    public DirectChat getDirectChat(int idx){
        return this.directChats.get(idx);
    }

    /**@author the other student
     * 
     * @return
     */
    public boolean getIsUpdate(){
        System.out.println("Aktueller server Update "+this.serverUpdate+", |DirChat| = "+this.directChats.size());
        return this.serverUpdate;
    }

    /**@author the other student
     * 
     */
    public void setIsUpdate(){
        this.serverUpdate = true;
    }

    /**@author the other student
     * 
     * @return
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    /**@author the other student
     * 
     * @return
     */
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    /**@author the other student
     * 
     * @return
     */
    public ArrayList<DirectChat> getDirectChats(){
        return this.directChats;
    }

    /**@author the other student
     * 
     * @param k balblacar
     * @return
     */
    public ArrayList<Message> getMessages(int k){
        return this.rooms.get(k).getMessages();
    }



    /**@author Staacke, Felix
     * 
     * @param args
     */
    public static void main(String[] args){
        Server server = new Server();
        server.initialize();
        server.run();
    }
}