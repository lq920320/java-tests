package other;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringSubTest {

    @Test
    public void stringSubTest() {
//        String abc = "[\"sajksjdkausdk\",\"sajksjdkausdk\",\"sajksjdkausdk\"]";
//        String lk = abc.replace("[", "").replace("]", "").replace(",", "-");
        String img = "https://test-video.youpeiliangpin.com/format/snapshot/public/video/2019/05/21/93ffbb45f58040d0a1bb9b1e48ca1a26/2000.jpgnull";
        System.out.println(img.substring(0, img.length() - 4));
//        System.out.println(abc);
//        System.out.println(lk);
    }

    @Test
    public void stringToInteger() {
        String str1 = "12.00";
        System.out.println(str1.substring(0, str1.indexOf(".")));
        System.out.println(Integer.parseInt(str1.substring(0, str1.indexOf("."))));
    }

    @Test
    public void filterTest() {
        Integer age = 20;
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeList.stream().filter(employee -> age.equals(employee.getAge())).collect(Collectors.toList());
        System.out.println(employeeList);
    }


    @Data
    private class Employee {
        private String empNo;
        private String name;
        private Integer age;
    }


    @Test
    public void subString() {
        String a = "ops-ms-adb";
        String b = a.substring(0, a.indexOf("-"));
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void replaceString() {
        String a = "pipeline {\n" +
                "  agent any \n" +
                "    stages {\n" +
                "      stage(&apos;pull&apos;) { //get project code from repo \n" +
                "        steps {\n" +
                "          sh &quot;git clone ${params.git_repo} ${params.app_name}/${env.BUILD_NUMBER} &amp;&amp; cd ${params.app_name}/${env.BUILD_NUMBER} &amp;&amp; git checkout ${params.git_ver}&quot;\n" +
                "        }\n" +
                "      }\n" +
                "      stage(&apos;image&apos;) { //build image and push to registry\n" +
                "        steps {\n" +
                "          writeFile file: &quot;${params.app_name}/${env.BUILD_NUMBER}/Dockerfile&quot;, text: &quot;&quot;&quot;FROM harbor.fengyuwl.net/base/maven:3.6.3-openjdk-8-slim as build\n" +
                "          COPY . /srv\n" +
                "          RUN cd srv &amp;&amp; mvn -B clean install -Dmanven.test.skip=true\n" +
                "\n" +
                "          FROM harbor.fengyuwl.net/base/jre:8u112-3\n" +
                "\n" +
                "          COPY --from=build /srv/target/*.jar /srv/${params.app_name}-server-1.0-SNAPSHOT.jar\n" +
                "          ENTRYPOINT [&quot;java&quot;, &quot;-server&quot;, &quot;-jar&quot;, &quot;/srv/${params.app_name}-server-1.0-SNAPSHOT.jar&quot;]&quot;&quot;&quot;\n" +
                "          sh &quot;cd  ${params.app_name}/${env.BUILD_NUMBER} &amp;&amp; docker build -t harbor.fengyuwl.net/${params.image_name}:${params.git_ver}_${params.add_tag} . &amp;&amp; docker push harbor.fengyuwl.net/${params.image_name}:${params.git_ver}_${params.add_tag}&quot;\n" +
                "        }\n" +
                "      }\n" +
                "      stage(&apos;deploy&apos;) {\n" +
                "        steps {\n" +
                "          echo &quot;deployment&quot;\n" +
                "          sh &quot;kubectl delete -f /JM/yaml/dev/${params.app_name}/dp.yml&quot;\n" +
                "          sh &quot;kubectl apply -f /JM/yaml/dev/${params.app_name}/dp.yml&quot;\n" +
                "          echo &quot;svc&quot;\n" +
                "          sh &quot;kubectl apply -f /JM/yaml/dev/${params.app_name}/svc.yml&quot;\n" +
                "          echo &quot;ingress&quot;\n" +
                "          sh &quot;kubectl apply -f /JM/yaml/dev/${params.app_name}/ingress.yml&quot;\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "}";

        String b = a.replace("pipeline {\n" +
                "  agent any \n" +
                "    stages {\n" +
                "      stage(&apos;pull&apos;) { //get project code from repo \n" +
                "        steps {\n" +
                "          sh &quot;git clone ${params.git_repo} ${params.app_name}/${env.BUILD_NUMBER} &amp;&amp; cd ${params.app_name}/${env.BUILD_NUMBER} &amp;&amp; git checkout ${params.git_ver}&quot;\n" +
                "        }\n" +
                "      }\n" +
                "      stage(&apos;image&apos;) { //build image and push to registry\n" +
                "        steps {\n" +
                "          writeFile file: &quot;${params.app_name}/${env.BUILD_NUMBER}/Dockerfile&quot;, text: &quot;&quot;&quot;FROM harbor.fengyuwl.net/base/maven:3.6.3-openjdk-8-slim as build\n" +
                "          COPY . /srv\n" +
                "          RUN cd srv &amp;&amp; mvn -B clean install -Dmanven.test.skip=true\n" +
                "\n" +
                "          FROM harbor.fengyuwl.net/base/jre:8u112-3\n" +
                "\n" +
                "          COPY --from=build /srv/target/*.jar /srv/${params.app_name}-server-1.0-SNAPSHOT.jar\n" +
                "          ENTRYPOINT [&quot;java&quot;, &quot;-server&quot;, &quot;-jar&quot;, &quot;/srv/${params.app_name}-server-1.0-SNAPSHOT.jar&quot;]&quot;&quot;&quot;\n" +
                "          sh &quot;cd  ${params.app_name}/${env.BUILD_NUMBER} &amp;&amp; docker build -t harbor.fengyuwl.net/${params.image_name}:${params.git_ver}_${params.add_tag} . &amp;&amp; docker push harbor.fengyuwl.net/${params.image_name}:${params.git_ver}_${params.add_tag}&quot;\n" +
                "        }\n" +
                "      }\n" +
                "      stage(&apos;deploy&apos;) {\n" +
                "        steps {\n" +
                "          echo &quot;deployment&quot;\n" +
                "          sh &quot;kubectl delete -f /JM/yaml/dev/${params.app_name}/dp.yml&quot;\n" +
                "          sh &quot;kubectl apply -f /JM/yaml/dev/${params.app_name}/dp.yml&quot;\n" +
                "          echo &quot;svc&quot;\n" +
                "          sh &quot;kubectl apply -f /JM/yaml/dev/${params.app_name}/svc.yml&quot;\n" +
                "          echo &quot;ingress&quot;\n" +
                "          sh &quot;kubectl apply -f /JM/yaml/dev/${params.app_name}/ingress.yml&quot;\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "}", "asdas");
        System.out.println(b);
    }

    @Test
    public void splitDiskLinks() {
        String text = "链接: https://pan.baidu.com/s/1upS6c7i_q9ZS1MxFIm5rqA 提取码: jwuv 复制这段内容后打开百度网盘手机App，操作更方便哦\n" +
                "链接: https://pan.baidu.com/s/1URNRIIaRz4FOh9nEQFkiHQ  密码: 4n67\n" +
                "https://yunpan.360.cn/surl_yR5vuAPRR7W （提取码：7373）\n" +
                "链接：https://share.weiyun.com/0zibSvx2 密码：ep6bc8\n" +
                "链接: https://pan.baidu.com/s/1AZE1W-_xbT6ovbwW6GklLQ \n提取码: wfeq \n复制这段内容后打开百度网盘手机App，操作更方便哦";

        String postfix = "复制这段内容后打开百度网盘手机App，操作更方便哦";
//        List<String> baiduWebLinks = new ArrayList<>();
//        while (text.contains(postfix)) {
//            String baiduWebLink = StringUtils.substringBefore(text, postfix);
//            System.out.println("baidulink:  " + baiduWebLink);
//            baiduWebLinks.add(baiduWebLink);
//
//            text = StringUtils.substringAfter(text, postfix);
//            System.out.println(text);
//        }

        String[] linkArray = text.split("\n");
        List<String> linkList = new ArrayList<>();

        for (int i = 0; i < linkArray.length; i++) {
            String a = linkArray[i];
            if (postfix.equals(a)) {
                linkList = linkList.subList(0, linkList.size() - 2);
                linkList.add(linkArray[i - 2] + linkArray[i - 1] + a);
            } else {
                linkList.add(a);
            }
        }

        for (String s : linkList) {
            System.out.println(s);
        }
    }


}
