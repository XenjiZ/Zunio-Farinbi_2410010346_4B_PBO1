package UAS;

// 8. INHERITANCE
public class TiketReguler extends Tiket {
    private String nomorKursi;

    public TiketReguler(String judulFilm, double hargaDasar, String nomorKursi) {
        super(judulFilm, hargaDasar);
        this.nomorKursi = nomorKursi;
    }

    // 9. POLYMORPHISM (Method Overriding)
    @Override
    public String cetakInfo() {
        return super.cetakInfo() + " | Tipe: Reguler | Kursi: " + nomorKursi;
    }
}
