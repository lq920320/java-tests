package file;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author liuqian
 * @date 2020/10/10 14:48
 */
@Slf4j
public class FileTest {

    @Test
    public void writeFileTest() {
        try {
            String fileName = "test.txt";
            File dir = new File("./src/main/resources/test/");
            if (!dir.exists()) {
                boolean mkResult = dir.mkdirs();
                if (mkResult) {
                    System.out.println("创建目录成功");
                }
            }
            File file = new File(dir, fileName);

            if (!file.exists()) {
                boolean createResult = file.createNewFile();
                if (createResult) {
                    System.out.println("创建文件成功");
                }
            }
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("This is a test string.");
            bw.flush();
            bw.close();
            fw.close();
        } catch (Exception e) {
            log.error("Failed to write file.", e);
        }
        System.out.println("Write is over");
    }

    @Test
    public void readFileTest() {
        String resourcePath = "test/test.txt";
        try {
            InputStream testInputStream = new ClassPathResource(resourcePath).getInputStream();
            BufferedReader reader = null;
            StringBuilder lastStr = new StringBuilder();
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(testInputStream, StandardCharsets.UTF_8);
                reader = new BufferedReader(inputStreamReader);
                String tempString;
                while ((tempString = reader.readLine()) != null) {
                    lastStr.append(tempString).append("\n");
                }
                reader.close();
            } catch (IOException e) {
                log.error("failed to read file content, {}", resourcePath, e);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        log.error("failed to read file content, {}", resourcePath, e);
                    }
                }
            }
            System.out.println(lastStr.toString());
        } catch (IOException e) {
            log.error("Failed to read file.", e);
        }
    }
}
