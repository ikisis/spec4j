package spec4j.injector;

import java.io.Closeable;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class QuietlyUtils {

  public static void close(Object obj) {

    if (obj == null) {
      return;
    }

    try {

      if (obj instanceof Closeable) {
        ((Closeable) obj).close();
      } else if (obj instanceof Socket) {
        ((Socket) obj).close();
      } else if (obj instanceof ServerSocket) {
        ((ServerSocket) obj).close();
      } else {
        obj.getClass().getMethod("close", new Class<?>[0]).invoke(obj, new Object[0]);
      }

    } catch (Throwable ignored) {

    }
  }

  public static void close(Object... obj) {

    for (Object c : obj) {
      close(c);
    }

  }

}
