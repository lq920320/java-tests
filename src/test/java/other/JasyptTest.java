package other;

import com.ulisesbocchio.jasyptspringboot.encryptor.ByteEncryptorStringEncryptorDelegate;
import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author liuqian
 * @date 2020/9/26 9:38
 */
public class JasyptTest {

    /**
     * jasypt:
     *   encryptor:
     *     password: A1B2c3d4!
     */

    @Test
    public void jasyptTest() {
//        Environment environment = new StandardEnvironment();
//        environment.acceptsProfiles(Profiles.of("jasypt.encryptor.password=A1B2c3d4!"));
//
//        StringEncryptor encryptor = new DefaultLazyEncryptor(environment);
//        // 你的邮箱密码
//        String password = "Just4Test!";
//        // 加密后的密码(注意：配置上去的时候需要加 ENC(加密密码))
//        String encryptPassword = encryptor.encrypt(password);
//        String decryptPassword = encryptor.decrypt(encryptPassword);
//
//        System.out.println("password = " + password);
//        System.out.println("encryptPassword = " + encryptPassword);
//        System.out.println("decryptPassword = " + decryptPassword);
    }
}
