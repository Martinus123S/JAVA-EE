package kelompok1._HappyTravelling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "t_pemesanan")
public class Pemesanan  {
    @Id
    String id = UUID.randomUUID().toString();

    @Column(name = "userid")
    private String username;

    @Column(name = "status")
    private int status;

    @Column(name = "penumpang")
    private int penumpang;

    @Column(name="jadwalid")
    private String jadwalId;

    @Column(name = "harga")
    private Long harga;

    @Column(name="pemesan")
    private String pemesan;

    public Pemesanan() {
    }

    public Pemesanan(String pemesan,Long harga,String jadwalId, String username, int status, int penumpang) {
        this.username = username;
        this.pemesan = pemesan;
        this.jadwalId = jadwalId;
        this.status = status;
        this.harga = harga;
        this.penumpang = penumpang;
    }

    public String getJadwalId() {
        return jadwalId;
    }

    public void setJadwalId(String jadwalId) {
        this.jadwalId = jadwalId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(int penumpang) {
        this.penumpang = penumpang;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public String getPemesan() {
        return pemesan;
    }

    public void setPemesan(String pemesan) {
        this.pemesan = pemesan;
    }
}
