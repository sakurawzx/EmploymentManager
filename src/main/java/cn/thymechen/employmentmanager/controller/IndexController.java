package cn.thymechen.employmentmanager.controller;

import cn.thymechen.employmentmanager.dao.UserRepository;
import cn.thymechen.employmentmanager.data.User;
import cn.thymechen.employmentmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@SuppressWarnings("all")
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.check(username, password);
        if (!Objects.isNull(user)) {
            user.setPassword("");
            session.setAttribute("user", user);

            switch (user.getIdentity()) {
                case 0:
                    return "admin/index";
                case 1:
                    return "company/index";
                case 2:
                    return "student/index";
                default:
                    return "redirect:/login";
            }
        } else {
            attributes.addFlashAttribute("user", "用户名或密码错误");
            return "redirect:/login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam int identity,
                           HttpSession session) {
        UserRepository userRepository;
        User user = userService.check(username, password);
        if (!Objects.isNull(user)) {
            user.setPassword("");
            session.setAttribute("user", user);

            switch (user.getIdentity()) {
                case 0:
                    return "admin/index";
                case 1:
                    return "company/index";
                case 2:
                    return "student/index";
                default:
                    return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }
    }
}
