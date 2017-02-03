package spec4j.core.env;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public abstract class ClassPathAppender {

  public static void run(String filePath) {

    try {

      File root = new File(filePath);

      for (File child : root.listFiles()) {

        if (child.isFile() && child.getName().endsWith(".jar")) {

          URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

          Method method =
              URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });

          method.setAccessible(true);

          method.invoke(classLoader, new Object[] { child.toURI().toURL() });

        }

      }

    } catch (Throwable th) {
      throw new RuntimeException(th);
    }

  }

}
