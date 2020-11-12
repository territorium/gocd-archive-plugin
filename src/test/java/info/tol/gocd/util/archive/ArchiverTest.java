
package info.tol.gocd.util.archive;

import java.io.File;

public class ArchiverTest {


  public static void main(String[] args) throws Exception {
    File workingDir = new File("/data/smartIO/test");

    try (ArchiveBuilder c = Archive.builder(new File(workingDir, "test.tar"))) {
      c.addDirectory(new File(workingDir, "qt-5.12.7-gcc-tools"),null);
    }

    try (ArchiveBuilder c = Archive.builder(new File(workingDir, "test.tar.gz"))) {
      c.addDirectory(new File(workingDir, "qt-5.12.7-gcc-tools"),null);
      // c.addFile(workingDir, "Monitor");
      // c.addFile(new File(workingDir, "qt-5.12.7-gcc-tools"), "");
    }

    try (ArchiveBuilder c = Archive.builder(new File(workingDir, "test.zip"))) {
      c.addDirectory(new File(workingDir, "qt-5.12.4-msvc-tools"),null);
      c.addFile(workingDir, "[bin]Monitor.exe",null);
      // c.addFile(new File(workingDir, "qt-5.12.4-msvc-tools"), "");
    }
  }
}
