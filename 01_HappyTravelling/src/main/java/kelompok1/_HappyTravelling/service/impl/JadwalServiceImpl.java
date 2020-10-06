package kelompok1._HappyTravelling.service.impl;

import kelompok1._HappyTravelling.model.Jadwal;
import kelompok1._HappyTravelling.repo.JadwalRepository;
import kelompok1._HappyTravelling.service.JadwalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JadwalServiceImpl implements JadwalService {
    @Autowired
    JadwalRepository jadwalRepository;
    @Override
    public List<Jadwal> findAll() {
        return jadwalRepository.findAll();
    }

    @Override
    public void save(Jadwal jadwal) {
        jadwalRepository.save(jadwal);
    }

    @Override
    public Optional<Jadwal> findJadwal(String id) {
        return jadwalRepository.findById(id);
    }
}
