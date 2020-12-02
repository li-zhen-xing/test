import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName test
 * @Description
 * @Author 李振兴
 * @Date 2020/11/24 16:51
 **/
public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext bean = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object student = bean.getBean("student");
        System.out.println(student);
    }
}
