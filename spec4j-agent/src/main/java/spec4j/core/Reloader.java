package spec4j.core;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;

import spec4j.core.secretary.Pepper;

public abstract class Reloader {

  public static synchronized void reloadAll(Instrumentation inst) {

    Class<?>[] loadedClasses = inst.getAllLoadedClasses();

    ArrayList<Class<?>> targets = new ArrayList<Class<?>>();

    for (Class<?> c : loadedClasses) {
      if (inst.isModifiableClass(c)
          && Pepper.Potts.RULE.isRecordable(c.getName().replaceAll("[.]", "/"))) {
        targets.add(c);
      }
    }

    for (Class<?> c : targets) {

      try {
        inst.retransformClasses(c);
      } catch (Throwable e) {

      }

    }
  }

}
