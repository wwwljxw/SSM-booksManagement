import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forever.domain.Type;
import com.forever.service.impl.TypeServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TypeServiceImpl typeService = context.getBean("typeServiceImpl", TypeServiceImpl.class);
    @Test
    public void test1(){
//        List<Type> categorylist= typeService.allTypes();
//        JSONObject obj = new JSONObject();
//        obj.put("code", 0);
//        obj.put("msg", "");
//        obj.put("count",categorylist.size());
//        obj.put("data", categorylist);
//        System.out.println(obj.toString());
//        String str= JSON.toJSON(categorylist).toString();
//        System.out.println(str);
    }

    @Test
    public void test2(){
        int i = typeService.deleteType(30);

        System.out.println(i);

    }
}
