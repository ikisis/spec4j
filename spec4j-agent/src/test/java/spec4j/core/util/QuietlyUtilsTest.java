package spec4j.core.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class QuietlyUtilsTest {

  @Test(expected = IOException.class)
  public void test_Closeable() throws IOException {

    String cName = QuietlyUtils.class.getName().replace(".", "/") + ".class";

    InputStream is =
        QuietlyUtils.class.getClassLoader().getResourceAsStream(cName);

    int i = is.read();

    assertThat(i, not(-1));

    QuietlyUtils.close(is);

    is.read();

  }

  @Test
  public void test_no_Closeable() {

    NoCloseable nc = new NoCloseable();

    QuietlyUtils.close(nc);

    assertThat(nc.closed, equalTo(true));

  }

  static class NoCloseable {

    public boolean closed = false;

    public void close() {
      closed = true;
    }

  }
}
