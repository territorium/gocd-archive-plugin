
package info.tol.gocd.util.archive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import info.tol.gocd.util.Environment;

public class AssemblyTarGzTest {

  public static void main(String[] args) throws Exception {
    File workingDir = new File("/home/brigl/build2104/linux-g++");
    String target = "smartio-$APP_VERSION+$BUILD_NUMBER.tar.gz";

    List<String> sources = new ArrayList<>();
    sources.add("bin/smartIO-odb;bin");
    sources.add("lib/{libsmartIO-*.so*};lib");
    sources.add("$QT_HOME/$QT_ARCH/{plugins/sqldrivers/*}");
    sources.add("$QT_HOME/$QT_ARCH/lib/{libicu*,libQt5Core*,libQt5Network*,libQt5Sql*};lib");
    String source = String.join("\n", sources);


    Environment env = new Environment();
    env.set("APP_VERSION", "1.0");
    env.set("BUILD_NUMBER", "123");
    env.set("QT_SPEC", "linux-g++");
    env.set("QT_ARCH", "gcc_64");
    env.set("QT_HOME", "/data/Software/Qt/5.15.2");

    Assembly assembly = Assembly.of(workingDir);
    assembly.setArchive(new File(workingDir, env.replaceByPattern(target)));
    assembly.setSources(env.replaceByPattern(source));
    assembly.build(m -> System.out.println(m));
  }
}
