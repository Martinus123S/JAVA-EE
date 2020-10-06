package kelompok1._HappyTravelling.controller;

import kelompok1._HappyTravelling.model.Jadwal;
import kelompok1._HappyTravelling.model.User;
import kelompok1._HappyTravelling.service.JadwalService;
import kelompok1._HappyTravelling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@SessionAttributes("user")
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    JadwalService jadwalService;

    @GetMapping("/")
    public ModelAndView home(Model model){
        User user = new User();

        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("user",user);
//        model.addAttribute("verify",verify);
        return mv;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView prosesLogin(@ModelAttribute User user, Model model, final RedirectAttributes redirectAttributes){
        if(userService.isSuccessLogin(user.getUsername(),user.getPassword())){
            user = userService.findUser(user.getUsername(),user.getPassword());
            ModelAndView mv = null;
            if(user.getRoleId() == 1){
                 mv = new ModelAndView("redirect:/admin");
            }else if(user.getRoleId()==2){
                 mv = new ModelAndView("redirect:/dashboard");
            }
//            mv.addObject("user",user);
            return mv;
        }
        redirectAttributes.addFlashAttribute("verify","Akun tidak tersedia");
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/dashboard")
    public ModelAndView dashboard(@ModelAttribute User user,Model model,final RedirectAttributes attributes){
        user = userService.findUser(user.getUsername(),user.getPassword());
        if(user == null){
            attributes.addFlashAttribute("needLogin","Silahkan Login terlebih dahulu");

            return new ModelAndView("redirect:/");
        }
        System.out.println(user.getUsername());

        List<Jadwal> jadwal = jadwalService.findAll();
        model.addAttribute("jadwal",jadwal);
        return new ModelAndView("user");
    }
    @GetMapping("/register")
    public ModelAndView register(Model model){
        User user = new User();
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("user",user);
        return mv;
    }
    @RequestMapping(value = "/prosesReg",method = RequestMethod.POST)
    public ModelAndView prosesRegistrasi(@ModelAttribute User user,Model model,final RedirectAttributes redirectAttributes){
        if(!userService.existByuser(user.getUsername())){
            User user1 = new User(user.getUsername(),user.getFullName(),user.getPassword(),2);
            userService.save(user1);
            redirectAttributes.addFlashAttribute("success","Selamat Akun ada berhasil di daftar silahkan login");
            ModelAndView mv = new ModelAndView("redirect:/");
            return mv;
        }
        redirectAttributes.addFlashAttribute("needUser","Maaf, username sudah digunakan");
        return new ModelAndView("redirect:/register");
    }
    @GetMapping("/admin")
    public ModelAndView admin(@ModelAttribute User user, Model model,final RedirectAttributes attributes){
        user = userService.findUser(user.getUsername(),user.getPassword());
        if(user == null){
            attributes.addFlashAttribute("needLogin","Silahkan Login terlebih dahulu");
            return new ModelAndView("redirect:/");
        }
        model.addAttribute(user);
        List<Jadwal> jadwal = jadwalService.findAll();
        model.addAttribute("jadwal",jadwal);
        return new ModelAndView("admin");
    }
    @GetMapping("/logout")
    public ModelAndView logout(){
        return new ModelAndView("redirect:/");
    }
}
