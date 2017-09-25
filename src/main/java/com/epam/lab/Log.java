package com.epam.lab;

import org.apache.log4j.Logger;

public class Log {
    public static Logger LOGGER  = Logger.getLogger(Log.class);

    public static void infoMessage(String message){
        LOGGER.info(message);
    }
}
