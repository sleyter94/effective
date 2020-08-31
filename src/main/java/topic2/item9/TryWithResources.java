package topic2.item9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryWithResources {

  static void copy(String src, String dst) throws IOException {

    try (InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)) {
      byte[] buf = new byte[256];
      int n;
      while((n = in.read()) >= 0){
        out.write(buf, 0 , n);
      }

    }
  }
}
