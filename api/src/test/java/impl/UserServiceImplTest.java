package impl;

import com.wgymt.ApiApplication;
import com.wgymt.service.UserService;
import com.wgymt.vo.ResultVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = ApiApplication.class)
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void userRegister() {
        ResultVO resultVO = userService.userRegister("唐可可", "ABC123");
        System.out.println(resultVO);
        Assertions.assertNotEquals(null, resultVO);
    }

    @Test
    void checkLogin() {
        ResultVO resultVO = userService.checkLogin("唐可可", "ABC123");
        System.out.println(resultVO);
        Assertions.assertNotNull(resultVO);
    }
}