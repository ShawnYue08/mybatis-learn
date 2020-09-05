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



## mybatis-02

### ResultSet结果集元数据

结果集元数据 + 反射 -> 转换为Java对象。

```java
public class ResultSetMetaDemo<T> {
    public List<T> transferToObject(Class<T> clazz, ResultSet resultSet) {
        List<T> list = null;
        try {
            if (resultSet != null) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                Method[] declaredMethods = clazz.getDeclaredMethods();
                while (resultSet.next()) {
                    T obj = clazz.newInstance();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        Object object = resultSet.getObject(i);
                        String columnLabel = metaData.getColumnLabel(i);
                        for (Method declaredMethod : declaredMethods) {
                            if (declaredMethod.getName().toUpperCase().equals(("set" + columnLabel).toUpperCase())) {
                                declaredMethod.invoke(obj, object);
                            }
                        }
                    }
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(obj);
                }
            } else {
                return null;
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return list;
    }
}
```

### mapper代理开发

使用Mapper接口 + mapper.xml结合，来代替之前的操作。

**Mapper代理开发注意事项，必须严格遵循：**

- mapper.xml中的**namespace**必须和**接口的全路径**保持一致【因为mybatis要为接口动态产生代理
  对象，当执行接口中的方法，**代理对象就会查找对应的mapper文件**，mapper文件与接口如何对应
  呢？就需要namespace】
- mapper中的**id**必须和接口中的**方法名**保持一致
- 因为接口中的方法是可以被重载的，所以mapper中的sql id 对应的**返回值类型，和参数类型需要
  与接口中保持一致**。**接口中如果返回值是集合，xml中还是结合中的一条数据类型**，（接口中的方法可以重载，但是xml文件不可以重载）
- 一定要**将mapper接口【注册】**交给mybaits

```xml
<mappers>
    <!--<mapper class="org.westos.mapper.AccountMapper"/>-->
    <!--注意：当配置的mapper属性为resources时，后面是/，当mapper属性为class时，后面是.-->

    <!--当我们需要配置多个mapper时，可以使用包扫描-->
    <package name="org.westos.mapper"/>
</mappers>
```

更多内容可见博客：[mybatis-02]()
