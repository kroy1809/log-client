package logger;

public class LoggerMain {
    public static void main(String[] args) {
        final LogClient logger = new LoggerImplementation();
        logger.start("1");
        logger.poll();
        logger.start("3");
        logger.poll();
        logger.end("1");
        logger.poll();
        logger.start("2");
        logger.poll();
        logger.end("2");
        logger.poll();
        logger.end("3");
        logger.poll();
        logger.poll();
        logger.poll();
        //Print order: 1 3 2
    }
}
