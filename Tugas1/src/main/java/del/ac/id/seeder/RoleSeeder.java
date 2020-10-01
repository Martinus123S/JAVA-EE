package del.ac.id.seeder;

import del.ac.id.model.RoleName;
import del.ac.id.model.Roles;
import del.ac.id.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {
    @Autowired
    RoleRepository roleRepo;

    //cek apakah field sudah terdaftar
    public void checkRoleIfExists(RoleName roleName) {
        if (!roleRepo.existsByName(roleName)) {
            Roles roles = new Roles();
            roles.setName(roleName);
            saveRoles(roles);
        }
    }

    //simpan ke DB jika field belum ada
    public void saveRoles(Roles roles) {
        roleRepo.save(roles);
    }

    //pengecekan
    @EventListener
    public void seeder(ContextRefreshedEvent contextRefreshedEvent) {
        checkRoleIfExists(RoleName.ROLE_USER);
        checkRoleIfExists(RoleName.ROLE_ADMIN);
    }
}
