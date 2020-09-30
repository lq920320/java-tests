package pipedInputOutput;

import java.io.PipedOutputStream;

/**
 * @author liuqian
 * @date 2019/7/1  17:32
 */
public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
