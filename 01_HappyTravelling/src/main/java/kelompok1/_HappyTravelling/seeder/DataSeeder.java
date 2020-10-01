package kelompok1._HappyTravelling.seeder;

import kelompok1._HappyTravelling.model.Role;
import kelompok1._HappyTravelling.model.User;
import kelompok1._HappyTravelling.repo.RoleRepository;
import kelompok1._HappyTravelling.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {
    @Autowired
    RoleRepository roleRepo;

    @Autowired
    UserRepository userRepository;
    //cek apakah field sudah terdaftar
    public void checkRoleIfExists(String roleName) {
        if (!roleRepo.existsByRoleName(roleName)) {
            Role roles = new Role();
            roles.setRoleName(roleName);
            saveRoles(roles);
        }
    }
    public void insertDefaultUser(String username){
        if(!userRepository.existsByUsername(username)){
            User user = new User("admin","admin","admin123",1);
            userRepository.save(user);
        }
    }
    //simpan ke DB jika field belum ada
    public void saveRoles(Role roles) {
        roleRepo.save(roles);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    //pengecekan
    @EventListener
    public void seeder(ContextRefreshedEvent contextRefreshedEvent) {
        checkRoleIfExists("Admin");
        checkRoleIfExists("User");
//        checkRoleIfExists(RoleName.ROLE_MERCHANT);
        insertDefaultUser("admin");
    }
}
