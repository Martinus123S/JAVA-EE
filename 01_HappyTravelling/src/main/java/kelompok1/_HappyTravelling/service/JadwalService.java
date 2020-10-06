package kelompok1._HappyTravelling.service;

import kelompok1._HappyTravelling.model.Jadwal;

import java.util.List;
import java.util.Optional;

public interface JadwalService {
    List<Jadwal> findAll();
    void save(Jadwal jadwal);
    Optional<Jadwal> findJadwal(String id);
}
