
package info.tol.gocd.util.archive;

import java.io.File;

import info.tol.gocd.util.Environment;

public class AssemblyZipTest {

  public static void main(String[] args) throws Exception {
    File workingDir = new File("/home/brigl/Public");
    String target = "smartio-$APP_VERSION+$BUILD_NUMBER.zip";
    String source = "build/win32-msvc/{plugins}\n" + "build/win32-msvc/{qml}\n"
        + "build/win32-msvc/{lib/smartIO-*.dll}\n" + "smartIO.exe\n" + "smartio.ico";

    Environment env = new Environment();
    env.set("APP_VERSION", "1.0");
    env.set("BUILD_NUMBER", "123");

    Assembly assembly = Assembly.of(workingDir);
    assembly.setArchive(new File(workingDir, env.replaceByPattern(target)));
    for (String pattern : source.split("[\\n]")) {
      assembly.addPattern(pattern.trim());
    }
    assembly.build(m -> System.out.println(m));
  }
}
