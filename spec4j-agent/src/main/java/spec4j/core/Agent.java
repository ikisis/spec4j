package spec4j.core;

import java.lang.instrument.Instrumentation;

import spec4j.core.env.ClassPathAppender;
import spec4j.core.util.PathUtils;

public class Agent {

  public static void premain(final String arg, final Instrumentation inst) {

    instrument(PathUtils.getProfilerHomePath(), inst);

  }

  private static void instrument(String profilerHomePath, Instrumentation inst) {

    ClassPathAppender.run(profilerHomePath);

  }
}
