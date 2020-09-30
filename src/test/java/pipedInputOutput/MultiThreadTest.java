package pipedInputOutput;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author liuqian
 * @date 2019/7/1  17:08
 */
public class MultiThreadTest {

    /**
     * 管道输入/输出流和普通文件的输入/输出流或者网络输入、输出流的不同之处在于管道输入/输出流主要用于线程之间的数据传输，而且传输的媒介为内存。
     * 主要包括两类实现
     * 面向字节：PipedOutputStream、PipedInputStream
     * 面向字符：PipedWriter、PipedReader
     */


    @Test
    public void pipedStream() {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

//            inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();

            Thread.sleep(5000);

            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
