
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forever.dao.BookMapper;
import com.forever.dao.ReaderMapper;
import com.forever.dao.TypeMapper;
import com.forever.domain.Book;
import com.forever.domain.Type;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TypeMapper typeMapper = context.getBean("typeMapper", TypeMapper.class);
    BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
    ReaderMapper readerMapper = context.getBean("readerMapper", ReaderMapper.class);
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
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("reader_id",10086);
        Integer integer = readerMapper.selectCount(wrapper);
        System.out.println(integer);
    }
}
