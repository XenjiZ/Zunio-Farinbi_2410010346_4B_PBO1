package UAS;

public class Tiket {
    // 3. ATRIBUT & 7. ENCAPSULATION
    private String judulFilm;
    private double hargaDasar;

    // 4. CONSTRUCTOR
    public Tiket(String judulFilm, double hargaDasar) {
        this.judulFilm = judulFilm;
        this.hargaDasar = hargaDasar;
    }

    // 6. ACCESSOR
    public String getJudulFilm() {
        return judulFilm;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    // 5. MUTATOR
    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public void setHargaDasar(double hargaDasar) {
        this.hargaDasar = hargaDasar;
    }

    // Pendukung 9. POLYMORPHISM
    public String cetakInfo() {
        return "Film: " + judulFilm + " | Harga Dasar: Rp" + hargaDasar;
    }
}