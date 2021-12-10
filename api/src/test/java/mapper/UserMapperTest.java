package mapper;

import com.wgymt.ApiApplication;
import com.wgymt.entity.User;
import com.wgymt.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest(classes = ApiApplication.class)
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void queryUserByName() {
        User user = userMapper.queryUserByName("zhangsan");
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

    @Test
    void insertUser() {
        User user = new User();
        user.setUsername("白霜");
        user.setPassword("123321");
        user.setUserRegtime(new Date());
        user.setUserModtime(new Date());
        Integer result = userMapper.insertUser(user);
        System.out.println(result);
        Assertions.assertEquals(1, result);
    }
}