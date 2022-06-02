package other;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author zetu
 * @date 2022/6/2
 */
public class UrlEncodeTest {


    @Test
    public void urlTest() {
        String url = "https://www.baidu.com?vagueSearch=";
        String title = "如何获取女人芳心";
        String encodeUrl = "";
        try {
            encodeUrl = url + URLEncoder.encode(title, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        System.out.println("encodeUrl is :" + encodeUrl);

        String decodeUrl = null;
        try {
            decodeUrl = URLDecoder.decode(encodeUrl, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("decodeUrl is :" + decodeUrl);

    }
}
