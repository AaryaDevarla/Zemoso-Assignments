package LMS.storage;

import LMS.logger.ILogger;

/* 
    This is a factory class, so the object which is necessary is generated.
*/

public class StorageFactory{

    private StorageFactory(){}

    public static IStorage getStorage(String type, ILogger logger)
    {
        if("mysql".equals(type))
            return new MySQLDatabaseStorage(logger);
        
        // By Default use FileStorage method
        else
            return new FileStorage(logger);
    }
}
