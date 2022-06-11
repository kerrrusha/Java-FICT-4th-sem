import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.layout.MessageLayout;

public class App {
    static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println("Built/run fine");

        //FileAppender fileAppender = new FileAppender("log.txt", "new MessageLayout()");
    }
}
