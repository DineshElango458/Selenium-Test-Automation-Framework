package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerUtils {
   private static Logger logger;
    private  LoggerUtils() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return logger = LogManager.getLogger(clazz);
    }
}