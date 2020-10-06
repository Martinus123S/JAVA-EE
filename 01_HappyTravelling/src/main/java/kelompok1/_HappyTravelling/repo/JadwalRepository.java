package kelompok1._HappyTravelling.repo;

import kelompok1._HappyTravelling.model.Jadwal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JadwalRepository extends JpaRepository<Jadwal,String> {
}
