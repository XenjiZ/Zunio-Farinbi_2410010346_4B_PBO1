
package UAS;
// 8. INHERITANCE
public class TiketVIP extends Tiket {
    private String fasilitas;

    public TiketVIP(String judulFilm, double hargaDasar, String fasilitas) {
        super(judulFilm, hargaDasar);
        this.fasilitas = fasilitas;
    }

    // 9. POLYMORPHISM (Method Overriding)
    @Override
    public String cetakInfo() {
        // Harga VIP dinaikkan 50% dari harga dasar sebagai contoh logika
        double hargaVIP = getHargaDasar() + (getHargaDasar() * 0.5);
        return "Film: " + getJudulFilm() + " | Harga VIP: Rp" + hargaVIP + " | Tipe: VIP | Fasilitas: " + fasilitas;
    }
}