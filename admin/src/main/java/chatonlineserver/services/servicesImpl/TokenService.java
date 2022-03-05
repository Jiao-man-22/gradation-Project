package chatonlineserver.services.servicesImpl;
import com.jiao.chatonlineserver.pojo.TokenData;
import org.springframework.stereotype.Service;


@Service
public class TokenService<T> extends BaseMapper {
    // 当 Mybatis 与一些依赖注入框架（如 Spring 或者 Guice）搭配使用时，SqlSession 将被依赖注入框架创建并注入，所以你不需要使用 SqlSessionFactoryBuilder 或者 SqlSessionFactory


    public boolean addToken(TokenData tokendata){
        String sql="insert into tokendata (access_token,create_time) value(#{access_token},#{create_time})";
        try {
/*            InputStream resourceAsStream=Resources.getResourceAsStream("application.yml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(resourceAsStream);
            SqlSession sqlSession = factory.openSession();
            sqlSession.insert(sql,tokendata);*/
           /* SqlSessionConfig sqlSessionConfig = new SqlSessionConfig();
            SqlSessionFactoryBean sqlSessionFactory = sqlSessionConfig.createSqlSessionFactory();
            SqlSessionFactory object = sqlSessionFactory.getObject();
            SqlSession sqlSession = object.openSession();
            sqlSession.insert(sql,tokendata);*/
            try {
                int insertFlag = getBaseMapper().insert(sql, tokendata);
                System.out.print(insertFlag);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
