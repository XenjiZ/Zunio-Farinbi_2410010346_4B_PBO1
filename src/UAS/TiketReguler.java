
package UAS;

public class TiketReguler extends Tiket{
    private String nomorKursi;

    public TiketReguler(String nomorKursi, String judulfilm, double hargaDasar) {
        super(judulfilm, hargaDasar);
        this.nomorKursi = nomorKursi;
    }

    
    
    @Override
    public String CetakInfo() {
        return super.CetakInfo() + "| Tipe: Reguler | Kursi :" + nomorKursi;
    }    
}
