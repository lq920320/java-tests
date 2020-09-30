package pipedInputOutput;

import java.io.PipedInputStream;

/**
 * @author liuqian
 * @date 2019/7/1  17:29
 */
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
