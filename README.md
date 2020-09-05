# mybatis-learn

## mybatis-01

### MyBatis依赖

```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.6</version>
</dependency>
```

### MyBatis核心配置文件

模板

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```

### MyBatis映射文件

模板

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.mybatis.example.BlogMapper">
  <select id="selectBlog" resultType="Blog">
    select * from Blog where id = #{id}
  </select>
</mapper>
```

### MyBatis重要组件

**Resources**

```java
InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
```

**SqlSessionFactoryBuilder**

SqlSessionFactoryBuilder 实例的最佳作用域是**方法作用域**（也就是局部方法变量）。

**SqlSessionFactory**

SqlSessionFactory 的最佳作用域是应用作用域。全局唯一，使用双检查锁的单例模式实现。

```java
public class SqlSessionFactoryUtil {
    private volatile static SqlSessionFactory factory;
    //volatile，禁止指令重排序，主要是new对象的操作

    private static final String CONFIG_FILE_NAME = "mybatis-config.xml";

    private SqlSessionFactoryUtil() {

    }

    /**
     * 保证SqlSessionFactory是系统唯一的
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        if (factory == null) {
            synchronized (SqlSessionFactoryUtil.class) {
                if (factory == null) {
                    try {
                        InputStream in = Resources.getResourceAsStream(CONFIG_FILE_NAME);
                        factory = new SqlSessionFactoryBuilder().build(in);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return factory;
    }
}
```

**SqlSession**

SqlSession 的实例**不是线程安全的，因此是不能被共享的**，所以它的最佳的作用域是请求或方法作用域。

### MyBatis优化开发

**properties**

```xml
<properties resource="db.properties"/>
```

**typeAlias**

```xml
<typeAliases>
    <package name="org.westos.model"/>
    <!--对一个包下的所有类进行别名映射，别名都是类的名字，且不区分大小写-->
</typeAliases>
```

**mappers**

```xml
<mappers>
    <mapper resource="org/westos/mapper/AccountMapper.xml"/>
    <!--<package name="org.westos.mapper"/>-->
    <!--包扫描，加载的是Mapper接口-->
</mappers>
```

**日志**

引入log4j依赖，log4j核心配置文件。

### #{}

总结：#{}如果参数是非自定义对象，值可以随意填写；如果参数是自定义对象，那么值必须为属性。

#{}可以根据数据类型自动选择是否增加单引号。

### ${}

总结：${}如果参数是非自定义对象，那么值只能为value；如果参数是自定义对象，那么值必须为属性；

${}存在Sql注入的风险；

${}不会根据数据类型自动增加单引号。



更多内容可见博客：[mybatis-01](https://blog.csdn.net/ShawnYue_08/article/details/108402198)
