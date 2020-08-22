package log;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    static {
        //默认查找logback-test.xml logback.grovvy logback.xml，也可以通过配置系统属性配置
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "configurationFile.xml");
    }

    public static void main(String[] args) {
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

        Logger logger = LoggerFactory.getLogger(MyTest.class);
        logger.error("error级别");
        logger.warn("warn级别");
        logger.info("info级别");
        logger.debug("debug级别");
//        int HASH_INCREMENT = 0x61c88647;
//        int s = 0;
//        double n = 4;
//        int Max = (int) Math.pow(2, n);
//
//        List<Integer> list = new ArrayList<>();
//        for(int i=s; i<Max+s; i++){
//            int hash = i*HASH_INCREMENT & (Max-1);
//
//          System.out.println(hash + " duplicate: " + list.contains(hash));
//            list.add(hash);
//        }
    }
}

