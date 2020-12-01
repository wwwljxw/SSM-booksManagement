import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.forever.domain.Type;
import com.forever.service.impl.TypeServiceImpl;
import org.junit.Test;
import com.forever.service.TypeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TypeServiceImpl typeService = context.getBean("typeServiceImpl", TypeServiceImpl.class);


        List<Type> categorylist= typeService.allTypes();
//        JSONObject obj = new JSONObject();
//        obj.put("code", 0);
//        obj.put("msg", "");
//        obj.put("count",categorylist.size());
//        obj.put("data", categorylist);
//        System.out.println(obj.toString());
        String str= JSON.toJSON(categorylist).toString();
        System.out.println(str);
    }
}
