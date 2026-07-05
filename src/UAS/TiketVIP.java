package UAS;

public class TiketVIP extends Tiket{
   private String fasilitas;

    public TiketVIP(String fasilitas, String judulfilm, double hargaDasar) {
        super(judulfilm, hargaDasar);
        this.fasilitas = fasilitas;
    }
   
   @Override
   public String CetakInfo(){
       double HargaVIP = getHargaDasar() +(getHargaDasar() * 0.5);
       return "Film" + getJudulfilm() + "| Harga VIP: Rp" + HargaVIP + "Tipe : VIP | Fasilitas :" + fasilitas;
   }
}
