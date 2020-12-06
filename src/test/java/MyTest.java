
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forever.dao.BookMapper;
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
        //        分页
        Page<Book> pageSize = new Page(1,6);
        Page<Book> typePage = bookMapper.selectPage(pageSize, null);

//        封装sql分页后的执行结果
        Map<String, Object> books = new HashMap<>();
        books.put("code", 0);
        books.put("msg", "");
        books.put("count", typePage.getTotal());
        books.put("data", typePage.getRecords());
    }
}
