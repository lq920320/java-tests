package base;

/**
 * @author zetu
 * @date 2022/6/11
 */
public class GetterAndSetter {
    public class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name != null && name.length() > 2)
                this.name = name;
        }
    }

    public class Sample {
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
