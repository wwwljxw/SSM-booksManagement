
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.forever.dao.*;
import com.forever.domain.Admin;
import com.forever.domain.Book;
import com.forever.domain.Type;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TypeMapper typeMapper = context.getBean("typeMapper", TypeMapper.class);
    BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
    ReaderMapper readerMapper = context.getBean("readerMapper", ReaderMapper.class);
    LendListMapper lendListMapper = context.getBean("lendListMapper", LendListMapper.class);
    AdminMapper adminMapper = context.getBean("adminMapper", AdminMapper.class);
    @Test
    public void test1(){
        Type type = new Type();
        type.setCid(31);
        type.setCname("影视");
//        执行sql语句
        int update = typeMapper.updateById(type);
    }

    /**
     * MyBatisPlus代码生成器配置
     */
    @Test
    public void test2(){
//        构建代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

//        配置生成策略
        GlobalConfig globalConfig = new GlobalConfig();
//        项目路径
        String projectPath = System.getProperty("user.dir");
//        代码生成目录
        globalConfig.setOutputDir(projectPath + "/src/main/java");
//        执行完后是否打开资源管理器
        globalConfig.setOpen(false);
//        是否覆盖原来生成的
        globalConfig.setFileOverride(false);
//        设置Service的前缀（去掉Service的I前缀）
        globalConfig.setServiceName("%sService");
//        设置主键生成策略
        globalConfig.setIdType(IdType.AUTO);
//        设置时间类型
        globalConfig.setDateType(DateType.ONLY_DATE);
//        将配置策略传入代码生成器中
        autoGenerator.setGlobalConfig(globalConfig);

//        设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mylibrary?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("1111");
        dataSourceConfig.setDbType(DbType.MYSQL);
//        将数据源传入代码生成器中
        autoGenerator.setDataSource(dataSourceConfig);

//        包的配置
        PackageConfig packageConfig = new PackageConfig();
//        实体类命名
        packageConfig.setEntity("domain");
        packageConfig.setParent("com.forever");
//        packageConfig.setController("controller");
        packageConfig.setMapper("dao");
        packageConfig.setService("service");
//        将包的配置传入代码生成器中
        autoGenerator.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        设置要映射的表名
        strategy.setInclude("admin");
//        设置表的映射规则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        自动填充配置
//        TableFill gmt_create = new TableFill("gmt_create", FieldFill.INSERT);
//        TableFill gmt_modified = new TableFill("gmt_modified", FieldFill.UPDATE);
//        ArrayList<TableFill> tableFills = new ArrayList<>();
//        tableFills.add(gmt_create);
//        tableFills.add(gmt_modified);
//        strategy.setTableFillList(tableFills);

//        自动Lombok
        strategy.setEntityLombokModel(true);

//        乐观锁
        strategy.setVersionFieldName("version");

//        设置驼峰命名
        strategy.setRestControllerStyle(false);
//        设置url下划线命名
        strategy.setControllerMappingHyphenStyle(true);

        autoGenerator.setStrategy(strategy);
//        执行代码构造器
        autoGenerator.execute();
    }

    @Test
    public void test3(){
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        Map<String, String> map = new HashMap<>();
        map.put("name","admin");
        map.put("password","admin");
        wrapper.allEq(map);
        adminMapper.selectOne(wrapper);
    }

}
