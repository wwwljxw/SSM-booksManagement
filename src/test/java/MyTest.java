
import com.forever.dao.TypeMapper;
import com.forever.domain.Type;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TypeMapper typeMapper = context.getBean("typeMapper", TypeMapper.class);

    @Test
    public void test1(){
        Type type = new Type();
        type.setCid(31);
        type.setCname("影视");
//        执行sql语句
        int update = typeMapper.updateById(type);
    }

    @Test
    public void test2(){

    }
}
