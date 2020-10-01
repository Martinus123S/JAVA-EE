package kelompok1._HappyTravelling.controller;

import kelompok1._HappyTravelling.model.User;
import kelompok1._HappyTravelling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView home(Model model){
        User user = new User();

        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("user",user);
        return mv;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView prosesLogin(@ModelAttribute User user,Model model){
        if(!userService.existByuser(user.getUsername())){
            User user1 = new User(user.getUsername(),user.getFullName(),user.getPassword(),2);
            userService.save(user1);
            ModelAndView mv = new ModelAndView("redirect:/dashboard");
            mv.addObject("user",user);

            return mv;
        }
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/dashboard")
    public ModelAndView dashboard(@ModelAttribute User user){
        System.out.println(user.getUsername());
        return new ModelAndView("home");
    }
}
