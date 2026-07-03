
package UAS;
import java.util.Scanner;

public class Utama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 13. ARRAY (Maksimal menampung 10 pesanan dalam satu kali jalan)
        Tiket[] daftarPesanan = new Tiket[10];
        
        int jumlahPesanan = 0; // Menghitung sudah berapa tiket yang dipesan
        int lanjutPesan = 1;   // Variabel untuk mengontrol perulangan

        System.out.println("=== SISTEM PEMESANAN TIKET BIOSKOP CINÉPOLIS ===");

        // 11. PERULANGAN (Akan terus berulang selama user memilih 1 dan array belum penuh)
        while (lanjutPesan == 1 && jumlahPesanan < daftarPesanan.length) {
            boolean inputValid = false;

            while (!inputValid) {
                try {
                    System.out.println("\n--- Daftar Film Sedang Tayang ---");
                    System.out.println("1. Jujutsu Kaisen 0 - Rp 45000");
                    System.out.println("2. Godzilla x Kong: The New Empire - Rp 50000");
                    System.out.println("3. Agak Laen - Rp 40000");
                    System.out.print("Pilih Film (1/2/3): ");
                    
                    int pilihFilm = Integer.parseInt(scanner.nextLine());

                    String judul = "";
                    double harga = 0;

                    // 10. SELEKSI (Menentukan judul dan harga otomatis tanpa perlu ketik manual)
                    if (pilihFilm == 1) {
                        judul = "Jujutsu Kaisen 0";
                        harga = 45000;
                    } else if (pilihFilm == 2) {
                        judul = "Godzilla x Kong: The New Empire";
                        harga = 50000;
                    } else if (pilihFilm == 3) {
                        judul = "Agak Laen";
                        harga = 40000;
                    } else {
                        System.out.println("[!] Pilihan film tidak tersedia. Silakan ulangi.");
                        continue; // Mengulang ke awal blok try
                    }

                    System.out.println("\nPilih Studio:");
                    System.out.println("1. Reguler");
                    System.out.println("2. VIP (Harga Dasar + 50%)");
                    System.out.print("Pilihan (1/2): ");
                    int pilihanStudio = Integer.parseInt(scanner.nextLine());

                    if (pilihanStudio != 1 && pilihanStudio != 2) {
                        System.out.println("[!] Pilihan studio tidak tersedia. Silakan ulangi.");
                        continue;
                    }

                    // 2. OBJECT & 10. SELEKSI
                    if (pilihanStudio == 1) {
                        System.out.print("Masukkan Nomor Kursi (Contoh: A12): ");
                        String kursi = scanner.nextLine();
                        // Masukkan ke array
                        daftarPesanan[jumlahPesanan] = new TiketReguler(judul, harga, kursi);
                    } else {
                        System.out.print("Masukkan Fasilitas (Contoh: Popcorn Caramel): ");
                        String fasilitas = scanner.nextLine();
                        // Masukkan ke array
                        daftarPesanan[jumlahPesanan] = new TiketVIP(judul, harga, fasilitas);
                    }

                    jumlahPesanan++; // Tambah jumlah pesanan
                    inputValid = true; // Input sukses, keluar dari loop validasi
                    
                } catch (NumberFormatException e) {
                    System.out.println("[!] ERROR: Input pilihan harus menggunakan angka mutlak!");
                } catch (Exception e) {
                    System.out.println("[!] ERROR Terjadi kesalahan sistem: " + e.getMessage());
                }
            }

            // Menanyakan apakah ingin pesan lagi (1) atau stop (2)
            System.out.println("\nApakah Anda ingin memesan tiket lagi?");
            System.out.println("1. Ya, tambah pesanan");
            System.out.println("2. Tidak, selesai dan cetak tiket");
            System.out.print("Pilihan (1/2): ");
            
            try {
                lanjutPesan = Integer.parseInt(scanner.nextLine());
                if (lanjutPesan != 1 && lanjutPesan != 2) {
                    System.out.println("[!] Pilihan tidak valid, program otomatis mencetak tiket.");
                    lanjutPesan = 2; // Paksa berhenti jika input ngawur
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] ERROR: Input bukan angka, program otomatis mencetak tiket.");
                lanjutPesan = 2; // Paksa berhenti jika diisi huruf
            }
        }

        // Tampilkan semua pesanan
        System.out.println("\n===============================================");
        System.out.println("=== REKAP PESANAN TIKET BERHASIL DICETAK ===");
        System.out.println("===============================================");
        
        // 11. PERULANGAN & 9. POLYMORPHISM
        // Looping hanya sebanyak tiket yang berhasil dipesan (jumlahPesanan)
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("Tiket ke-" + (i + 1) + ":");
            System.out.println(daftarPesanan[i].cetakInfo());
            System.out.println("-----------------------------------------------");
        }
        
        System.out.println("Terima kasih telah memesan tiket di Cinépolis!");
        System.out.println("===============================================");
        scanner.close();
    }
}