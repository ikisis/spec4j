package spec4j.core;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import spec4j.core.env.InitConsts;
import spec4j.core.util.QuietlyUtils;

public class AgentInstaller {

  public static void attach() {

    String iString = null;

    Scanner input = null;

    while (iString == null) {

      try {

        System.out.print("Target process ID (ex1 4321 ex2 4321 8765) : ");

        input = new Scanner(System.in);

        iString = input.nextLine();

      } finally {

        QuietlyUtils.close(input);

      }

    }

    for (String pid : iString.split("[ ]")) {

      System.out.print("trying to attach [pid: " + pid + "] ..");

      try {
        attach(pid);
        System.out.println("[Done]");
      } catch (Throwable ignored) {

        ignored.printStackTrace();

      }

    }

  }

  private static void attach(String pid) throws AttachNotSupportedException, IOException,
      AgentLoadException, AgentInitializationException {

    VirtualMachine vm = VirtualMachine.attach(pid);

    vm.loadAgent(
        new File(InitConsts.CORE_JAR_NAME).getAbsolutePath(),
        null);

  }

}
