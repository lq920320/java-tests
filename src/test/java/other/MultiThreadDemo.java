package other;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * 多线程demo
 *
 * @author zetu
 * @date 2021/7/6
 */
public class MultiThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        int jobs = 10;//假设一个任务需要10个job

        //固定个数的线程池
        ExecutorService service = Executors.newFixedThreadPool(jobs);

        //每个job结束时，则报告一下结束，所有job都结束时，则任务结束
        CountDownLatch latch = new CountDownLatch(jobs);

        for (int i = 0; i < jobs; i++) {//准备执行
            Job job = new Job("job" + i, latch);
            service.submit(job);
        }

        //等待所有job结束
        latch.await();

        //注意：此时main线程已经要结束了，但是service线程如果不关闭是不会结束的
        service.shutdown();

        long end = System.currentTimeMillis();
        System.out.println(">>>>>>>>任务总耗时" + (end - start) + "ms");
    }


    /**
     * job类
     */
    static class Job implements Runnable {
        /**
         * job名称
         */
        private final String jobName;

        /**
         * 同步计数器(倒数计数锁:当倒数到0时触发事件，也就是开锁，其他人就可以进入了。)
         */
        private final CountDownLatch latch;

        /**
         * 构造函数
         *
         * @param jobName job名称
         * @param latch   同步计数器
         */
        public Job(String jobName, CountDownLatch latch) {
            this.jobName = jobName;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(jobName + " has start...");
                long useTime = (long) (Math.random() * 1000);
                Thread.sleep(useTime);//模拟job需要的时间
                System.out.println(jobName + " has finished,useTime=" + useTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();//报告job结束了
            }
        }
    }


    @Test
    public void multiSortedTest() throws JsonProcessingException, ParseException {
        // 根据年纪升序，根据薪水降序，得到一个有序的列表
        // 排序条件逆序设置：先排序的条件放在后面，后排序的条件放前面
        ObjectMapper objectMapper = new ObjectMapper();
        List<TestModel> testModels = getTestDatas();
        System.out.println(objectMapper.writeValueAsString(testModels));
//        List<TestModel> sortedWorkers = testWorkers.stream()
//                .sorted(Comparator.comparing(Worker::getSalary, Comparator.reverseOrder()))
//                .sorted(Comparator.comparing(Worker::getAge))
//                .collect(Collectors.toList());
        List<TestModel> testModels2 = testModels.stream()
                .sorted(Comparator.comparing(TestModel::getType))
                .sorted(Comparator.comparing(TestModel::getDate))
                .collect(Collectors.toList());
        System.out.println(objectMapper.writeValueAsString(testModels2));
    }

    private List<TestModel> getTestDatas() throws ParseException {
        List<TestModel> models = new ArrayList<>();

        TestModel model1 = new TestModel();
        model1.setDate(DateUtils.parseDate("2021-07-06 16:40:11", "yyyy-MM-dd HH:mm:ss"));
        model1.setType("ADD");

        TestModel model2 = new TestModel();
        model2.setDate(DateUtils.parseDate("2021-07-06 16:40:11", "yyyy-MM-dd HH:mm:ss"));
        model2.setType("ADD");

        TestModel model3 = new TestModel();
        model3.setDate(DateUtils.parseDate("2021-07-06 16:40:11", "yyyy-MM-dd HH:mm:ss"));
        model3.setType("REMOVE");

        TestModel model4 = new TestModel();
        model4.setDate(DateUtils.parseDate("2021-07-06 16:40:12", "yyyy-MM-dd HH:mm:ss"));
        model4.setType("REMOVE");

        TestModel model5 = new TestModel();
        model5.setDate(DateUtils.parseDate("2021-07-06 16:40:12", "yyyy-MM-dd HH:mm:ss"));
        model5.setType("ADD");

        TestModel model6 = new TestModel();
        model6.setDate(DateUtils.parseDate("2021-07-06 16:40:13", "yyyy-MM-dd HH:mm:ss"));
        model6.setType("ADD");

        TestModel model7 = new TestModel();
        model7.setDate(DateUtils.parseDate("2021-07-06 16:40:14", "yyyy-MM-dd HH:mm:ss"));
        model7.setType("REMOVE");

        TestModel model8 = new TestModel();
        model8.setDate(DateUtils.parseDate("2021-07-06 16:40:15", "yyyy-MM-dd HH:mm:ss"));
        model8.setType("ADD");

        models.add(model1);
        models.add(model2);
        models.add(model3);
        models.add(model4);
        models.add(model5);
        models.add(model6);
        models.add(model7);
        models.add(model8);
        return models;
    }

    @Data
    static class TestModel {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date date;
        private String type;
    }
}
