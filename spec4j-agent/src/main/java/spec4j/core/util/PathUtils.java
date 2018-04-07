package spec4j.core.util;

import java.net.URL;

import spec4j.core.Agent;
import spec4j.core.env.InitConsts;

public abstract class PathUtils {

  public static String getProfilerHomePath() {

    String cName = Agent.class.getName().replace(".", "/") + ".class";

    URL url = Agent.class.getClassLoader().getResource(cName);

    if (url != null) {
      try {

        String fullPath = url.getPath();

        String[] tokens = fullPath.split("[:]");

        int tokenIndex = 0;

        if (tokens.length < 1) {
          // TODO exceptions
        }

        if (tokens.length > 1 && (tokens[1].startsWith("/") || tokens[1].startsWith("\\"))) {
          tokenIndex = 1;
        }

        tokens = tokens[tokenIndex].replace('\\', '/').split("[/]");

        StringBuilder sb = new StringBuilder();

        for (String t : tokens) {

          if (t.startsWith(InitConsts.CORE_JAR_NAME)) {
            break;
          }

          if (t.length() > 0) {
            sb.append(System.getProperty("file.separator"))
                .append(t);
          }

        }

        sb.append(System.getProperty("file.separator"));

        return sb.toString();

      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    }

    return null;
  }

}
