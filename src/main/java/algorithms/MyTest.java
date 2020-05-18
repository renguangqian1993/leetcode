package algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {
    private static Logger logger = LoggerFactory.getLogger(MyTest.class);

    public static void main(String[] args) {
        logger.error("error级别");
        logger.warn("warn级别");
        logger.info("info级别");
        logger.debug("debug级别");
    }
}