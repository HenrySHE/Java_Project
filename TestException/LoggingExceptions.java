import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{
  private static Logger logger = Logger.getLogger("LoggingException");
  public LoggingException() {
    StringWriter trace = new StringWriter();
    printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }
}

public class LoggingExceptions{
  public static void main(String[] args){
    try{
      throw new LoggingException();
    }catch(LoggingException e){
      System.err.println("Caught"+ e);
    }

    try{
      throw new LoggingException();
    }catch(LoggingException e){
      System.err.println("Caught"+ e);
    }
  }
}

/**
Throwing MyException from f()
MyException
        at FullConstructors.f(FullConstructors.java:9)
        at FullConstructors.main(FullConstructors.java:19)
Throwing MyException form g()
MyException: Originated in g()
        at FullConstructors.g(FullConstructors.java:14)
        at FullConstructors.main(FullConstructors.java:25)
*/
