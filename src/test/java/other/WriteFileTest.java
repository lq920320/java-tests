package other;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author liuqian
 * @date 2020/9/23 14:03
 */
public class WriteFileTest {

    @Test
    public void writeFileTest() {
        writeFile();
    }

    private void writeFile() {
        try {

            String fileName = "test.txt";
            File dir = new File("./src/main/resources/dev/abc/");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, fileName);
//            file.createNewFile();
//            System.out.println(file.getPath());

            if (!file.exists()) {
                file.createNewFile();
                System.out.println("创建文件成功");
            }
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < 1; i++) {
                bw.write("789");
            }
            bw.flush();
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Write is over");
    }
}
