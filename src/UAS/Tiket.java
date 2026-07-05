package UAS;

public class Tiket {
    private String judulfilm;
    private double hargaDasar;

    public Tiket(String judulfilm, double hargaDasar) {
        this.judulfilm = judulfilm;
        this.hargaDasar = hargaDasar;
    }

    public String getJudulfilm() {
        return judulfilm;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    public void setJudulfilm(String judulfilm) {
        this.judulfilm = judulfilm;
    }

    public void setHargaDasar(double hargaDasar) {
        this.hargaDasar = hargaDasar;
    }
    
    public String CetakInfo() {
        return "Film : " + judulfilm + "| Harga Dasar: Rp" + hargaDasar;
    }
}
