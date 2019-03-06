package practice.thread.std10;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {

  public static void main(String[] args) {
    try {
      WriteData writeData = new WriteData();
      ReadData readData = new ReadData();

      PipedOutputStream out = new PipedOutputStream();
      PipedInputStream input = new PipedInputStream();

      out.connect(input);

      ThreadRead threadRead = new ThreadRead(readData, input);
      threadRead.start();

      Thread.sleep(2000);

      ThreadWrite threadWrite = new ThreadWrite(writeData, out);
      threadWrite.start();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
