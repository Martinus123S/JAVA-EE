package kelompok1._HappyTravelling.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "t_jadwal")

public class Jadwal {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "asal")
    private String kotaasal;

    @Column(name = "tujuan")
    private String kotatujuan;

    @Column(name = "pesawat")
    private String pesawat;

    @Column(name = "harga")
    private Long harga;

    @Column(name = "waktu")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggal;

    @Column(name = "passenger")
    private Integer passenger;

    public Jadwal(String kotaasal,String pesawat, String kotatujuan, Long harga, Date tanggal, Integer passenger) {
        this.kotaasal = kotaasal;
        this.kotatujuan = kotatujuan;
        this.pesawat = pesawat;
        this.harga = harga;
        this.tanggal = tanggal;
        this.passenger = passenger;
    }

    public String getPesawat() {
        return pesawat;
    }

    public void setPesawat(String pesawat) {
        this.pesawat = pesawat;
    }

    public Jadwal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKotaasal() {
        return kotaasal;
    }

    public void setKotaasal(String kotaasal) {
        this.kotaasal = kotaasal;
    }

    public String getKotatujuan() {
        return kotatujuan;
    }

    public void setKotatujuan(String kotatujuan) {
        this.kotatujuan = kotatujuan;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getPassenger() {
        return passenger;
    }

    public void setPassenger(Integer passenger) {
        this.passenger = passenger;
    }
}
