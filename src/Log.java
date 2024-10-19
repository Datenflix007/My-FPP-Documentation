/**@author Staacke, Felix
 * 
 * @file Log.java
 * @brief This class discribes the datastructure Log. It will be used in Server to represent log entrys out of an external log file.
 * 
 * <b>Hint:</b> this class only contains gettter and setter methods
 */
public class Log{
    private int sitzung;
    private String date;
    private String time;
    private int roll;
    private String content;

    Log(int sitzung, String date, String time, int roll, String content){
        this.sitzung = sitzung;
        this.date = date;
        this.time = time;
        this.roll = roll;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public String getDate() {
        return date;
    }
    public int getRoll() {
        return roll;
    }
    public int getSitzung() {
        return sitzung;
    }
    public String getTime() {
        return time;
    }
    
}