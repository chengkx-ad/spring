package spring.bean.component;

import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

    private UserService userService;
    public void sayOK() {

        System.out.println("UserService ");
        userService.hi();
    }

}
