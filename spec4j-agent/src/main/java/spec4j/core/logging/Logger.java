package spec4j.core.logging;

public abstract class Logger {

  public static void INFO(String msg) {
    append(LogLevel.INFO, msg);
  }

  public static void TRACE(String msg) {
    append(LogLevel.TRACE, msg);
  }

  public static void DEBUG(String msg) {
    append(LogLevel.DEBUG, msg);
  }

  public static void WARN(String msg) {
    append(LogLevel.WARN, msg);
  }

  public static void ERROR(String msg) {
    append(LogLevel.ERROR, msg);
  }

  public static void FATAL(String msg) {
    append(LogLevel.FATAL, msg);
  }

  private static void append(LogLevel logLevel, String msg) {

    SystemMessage sysmsg = new SystemMessage(logLevel, System.currentTimeMillis(), msg);

    // AgentMonitor.getInstance().LOG.append(sysmsg);

    // TODO append

  }

  public static enum LogLevel {
    INFO,
    TRACE,
    DEBUG,
    WARN,
    ERROR,
    FATAL
  }

}
