package UAS;
//import
import java.util.Scanner;
public class Utama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Membuat array dengan class induk tiket
        Tiket [] daftarPesanan = new Tiket[10];
        int jumlahPesanan = 0;
        int lanjutPesan = 1;
        
        System.out.println("Sistem Pemesanan Tiket Bioskop Cinepolis");
        
        while (lanjutPesan == 1 && jumlahPesanan < 10) {
            try {
                System.out.println("Daftar Film Sedang Tayang");
                System.out.println("1. Toy Story 5 - Rp 45000");
                System.out.println("2. Agak Lain - Rp 50000");
                System.out.println("3. The Mandalorian And Grogu - Rp 55000");
                System.out.println("Pilih Film 1/2/3 ");
                
                int pilihFilm = Integer.parseInt(scanner.nextLine());
                String judul = "";
                double harga = 0;
                
                if (pilihFilm == 1){
                    judul = "Toy Story 5";
                    harga = 45000;
                }
                else if (pilihFilm == 2){
                    judul = "Agak Lain";
                    harga = 50000;
                }
                else if (pilihFilm == 3){
                    judul = "The Mandalorian And Grogu";
                    harga = 55000;
                }
                else{
                    System.out.println("Pilihan yang Diinput Tidak Valid");
                    continue;
                }
                
                System.out.println("Pilih Studio");
                System.out.println("1. Reguler");
                System.out.println("2. VIP");
                System.out.println("Pilih 1/2 ");
                
                int pilihanStudio = Integer.parseInt(scanner.nextLine());
                
                if (pilihanStudio == 1) {
                    System.out.println("Masukkan Nomor Kursinya (Contoh : A2): ");
                    String kursi = scanner.nextLine();
                    //
                    daftarPesanan[jumlahPesanan] = new TiketReguler(kursi, judul, harga);
                    jumlahPesanan++;
                }
                else if (pilihanStudio == 2) {
                    System.out.println("Masukkan Fasilitas (Contoh : Popcorn): ");
                    String fasilitas = scanner.nextLine();
                    
                    daftarPesanan[jumlahPesanan] = new TiketVIP(fasilitas, judul, harga);
                    jumlahPesanan++;
                }
                else {
                    System.out.println("Pilihan Studio TIDAK VALID");
                    continue;
                }
            }
             catch(Exception e){
                        System.out.println("Error Massukan Angka Yang Benar");
                        continue;
                        }
            
            System.out.println("Apakah anda Ingin Mmemesan tiket lagi? ");
            System.out.println("1. Ya Tambah Pesanan ");
            System.out.println("2. Tidak, Selesai daan Cetak Tiket");
            System.out.println("Pilih 1/2: ");
            
            try { //untuk mengamankan proses pembacaan dari lanjut pesan
            lanjutPesan = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
                // jika user salah input (misalnya huruf) dia akan menampilkan ini
                System.out.println("Input salah, Otomatis mencetak tiket");
                lanjutPesan = 2;
             
        }
            System.out.println("REKAP PESANAN TIKET BERHASIL DI CETAK");
     for (int i = 0; i < jumlahPesanan; i++){ //looping untuk rekap data
             System.out.println("Tiket ke- " + (i + 1) + ":");
             System.out.println(daftarPesanan[i].CetakInfo());
         }
     }
         
         System.out.println("Terima Kasih Telah Memasan Tiket Di Cinepolis");
    }
}
