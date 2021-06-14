package LMS.logger;

public class SystemLogger implements ILogger{
    
    public void log(String message)
    {
        System.out.println("Error : " + message);
    }
}
