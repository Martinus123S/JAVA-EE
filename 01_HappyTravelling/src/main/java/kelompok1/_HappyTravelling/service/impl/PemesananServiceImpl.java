package kelompok1._HappyTravelling.service.impl;

import kelompok1._HappyTravelling.model.Pemesanan;
import kelompok1._HappyTravelling.repo.PemesananRepository;
import kelompok1._HappyTravelling.service.PemesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PemesananServiceImpl implements PemesananService {
    @Autowired
    PemesananRepository pemesananRepository;
    @Override
    public void save(Pemesanan pemesanan) {
        pemesananRepository.save(pemesanan);
    }
}
