package kelompok1._HappyTravelling.controller;

import kelompok1._HappyTravelling.model.Jadwal;
import kelompok1._HappyTravelling.model.Pemesanan;
import kelompok1._HappyTravelling.model.User;
import kelompok1._HappyTravelling.repo.JadwalRepository;
import kelompok1._HappyTravelling.service.JadwalService;
import kelompok1._HappyTravelling.service.PemesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@RestController
@SessionAttributes("user")
public class UserController {
    @Autowired
    JadwalService jadwalService;

    @Autowired
    PemesananService pemesananService;
    @GetMapping("/addschedule")
    public ModelAndView addSchedule(Model model){
        Jadwal jadwal = new Jadwal();
        ModelAndView mv = new ModelAndView("add_schedule");
        mv.addObject("jadwal",jadwal);
        return mv;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView saveSchedule(@ModelAttribute Jadwal jadwal, RedirectAttributes attributes){
        jadwalService.save(jadwal);
        return new ModelAndView("redirect:/admin");
    }
    @GetMapping("/pesan/{id}")
    public ModelAndView pesan(@PathVariable("id")String id){
        Pemesanan pemesanan = new Pemesanan();
        ModelAndView mv = new ModelAndView("pesan");
        Optional<Jadwal> jadwal1 = jadwalService.findJadwal(id);
        Jadwal jadwal = null;
        if(jadwal1.isPresent()){
             jadwal = jadwal1.get();
        }
        mv.addObject("pemesanan",pemesanan);
        mv.addObject("jadwal",jadwal);
        return mv;
    }
    @RequestMapping(value = "/savepesanan/{id}",method = RequestMethod.POST)
    public ModelAndView savepesanan(@PathVariable("id") String id, @ModelAttribute Pemesanan pemesanan,
                              @ModelAttribute("user") User user,final RedirectAttributes attributes){
        Optional<Jadwal> jadwal1 = jadwalService.findJadwal(id);
        Jadwal jadwal = null;
        if(jadwal1.isPresent()){
            jadwal = jadwal1.get();
        }
        Pemesanan pemesanan1 = new Pemesanan(pemesanan.getPemesan(),jadwal.getHarga(),jadwal.getId(),user.getUsername(),0,pemesanan.getPenumpang());
        pemesananService.save(pemesanan1);
        return new ModelAndView("redirect:/dashboard");
    }
}
