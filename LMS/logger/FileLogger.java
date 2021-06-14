package LMS.logger;

import java.io.*;

interface FileLoggerProperties{
    String URL = "Logs.txt";
}

public class FileLogger implements ILogger, FileLoggerProperties{

    public void log(String message)
    {
        try{

            PrintWriter logger = new PrintWriter(new File("Log.txt"));
            logger.write("Error : " + message + "\n");
            logger.close();
        }

        catch(Exception e)
        {
        }
    }
}
