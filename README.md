# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah aplikasi Sistem Pemesanan Tiket Bioskop Cinépolis berbasis CLI (Command Line Interface) menggunakan bahasa pemrograman Java. Aplikasi ini dibuat sebagai pemenuhan tugas akhir (UAS) dari mata kuliah Pemrograman Berbasis Objek 1.

## Deskripsi

Aplikasi ini menyimulasikan mesin kasir pemesanan tiket bioskop. Program akan menerima input dari pengguna berupa pilihan film yang sedang tayang, jenis studio (Reguler atau VIP), serta detail tambahan seperti nomor kursi (untuk Reguler) atau fasilitas khusus (untuk VIP). 

Output yang dihasilkan oleh aplikasi ini adalah rekapitulasi nota atau struk pemesanan tiket secara kolektif yang menampilkan kalkulasi harga akhir beserta detail kelengkapannya.

Program ini telah mengimplementasikan 14 konsep utama dalam Pemrograman Berorientasi Objek (OOP), memastikan kode tersusun secara terstruktur, aman, dan dinamis.

## Penjelasan Kode dan Implementasi OOP

Berikut adalah rincian 14 konsep OOP yang digunakan dalam aplikasi ini beserta penjelasan dan potongan kodenya:

### 1. Class
**Penjelasan:** *Class* adalah cetakan atau rancangan dasar dari sebuah program. Di dalam proyek ini, terdapat kelas induk (`Tiket`), kelas anak (`TiketReguler` dan `TiketVIP`), serta kelas penggerak utama (`Utama`).

```java
public class Tiket { ... }
public class TiketReguler extends Tiket { ... }
public class TiketVIP extends Tiket { ... }
public class Utama { ... }
```
### 2. Object
**Penjelasan**: Object adalah hasil realisasi (instance) dari sebuah class yang memiliki wujud dan tempat di memori. Pada kode ini, objek tercipta saat menggunakan kata kunci new untuk memasukkan data pesanan ke dalam array.
```daftarPesanan[jumlahPesanan] = new TiketReguler(kursi, judul, harga);
// atau
daftarPesanan[jumlahPesanan] = new TiketVIP(fasilitas, judul, harga);
```
### 3. Atribut
**Penjelasan**: Atribut adalah variabel yang berada di dalam class untuk menyimpan status atau data objek. Pada program ini, judul, harga, kursi, dan fasilitas adalah contoh atribut.
```private String judul;
private double harga;
private String kursi;
private String fasilitas;
```
### 4. Constructor
**Penjelasan**: Constructor adalah method khusus yang otomatis berjalan pertama kali saat objek dibuat untuk memberikan nilai awal. Constructor di kelas anak menggunakan perintah super() untuk mengirim data ke kelas induk.
```public Tiket(String judul, double harga) {
    this.judul = judul;
    this.harga = harga;
}

public TiketReguler(String kursi, String judul, double harga) {
    super(judul, harga);
    this.kursi = kursi;
}
```
### 5. Mutator (Setter)
**Penjelasan**: Mutator adalah method yang berfungsi khusus untuk mengubah atau memperbarui isi data dari sebuah atribut yang disembunyikan.
```public void setJudulfilm(String judulFilm) {
    this.judulfilm = judulFilm;
}

public void setHargaDasar(double hargaDasar) {
    this.hargaDasar = hargaDasar;
}
```
### 6. Accessor (Getter)
**Penjelasan**: Accessor adalah method yang berfungsi khusus untuk mengambil, membaca, atau melihat isi data dari sebuah atribut.
```public String getJudulfilm() {
    return judulfilm;
}

public double getHargaDasar() {
    return hargaDasar;
}
```
### 7. Encapsulation
**Penjelasan**: Konsep membungkus dan mengamankan data dengan memberikan hak akses private pada atribut, sehingga data tidak bisa diubah sembarangan dari luar kelas tanpa melalui method resmi (Getter/Setter).
```private String judulfilm;
private double hargaDasar;
```
### 8. Inheritance
**Penjelasan**: Konsep pewarisan sifat. Kelas TiketReguler dan TiketVIP bertindak sebagai kelas anak yang mewarisi atribut dan method dari kelas induknya (Tiket) menggunakan kata kunci extends.
```public class TiketReguler extends Tiket { ... }

public class TiketVIP extends Tiket { ... }
```
### 9. Polymorphism
**Penjelasan**: Konsep di mana satu method bisa memiliki banyak bentuk atau hasil yang berbeda. Proyek ini menggunakan Method Overriding, yaitu menimpa method CetakInfo() milik kelas induk agar format cetakannya menyesuaikan dengan karakteristik kelas anak (menampilkan nomor kursi untuk Reguler, dan menghitung tambahan harga 50% untuk VIP).
```// Di dalam class TiketVIP (Overriding)
@Override
public String CetakInfo(){
    double hargaVIP = getHargaDasar() + (getHargaDasar() * 0.5);
    return "Film " + getJudulfilm() + "| Harga VIP: Rp" + hargaVIP + "| Tipe: VIP| Fasilitas : " + fasilitas;
}
```
### 10. Seleksi
**Penjelasan**: Logika pengambilan keputusan dalam program. Menggunakan struktur if-else untuk menentukan judul film dan harga berdasarkan angka menu yang dipilih oleh pengguna.
```if (pilihFilm == 1){
    judul = "Toy Story 5";
    harga = 45000;
} else if (pilihFilm == 2){
    judul = "Agak Lain";
    harga = 50000;
} else {
    System.out.println("Pilihan yang Diinput Tidak Valid");
    continue;
}
```
### 11. Perulangan
**Penjelasan**: Mengeksekusi blok kode secara berulang. Menggunakan while agar program terus menawarkan pesanan baru, dan menggunakan for untuk mencetak seluruh rekap pesanan di akhir transaksi.
```// Perulangan untuk input data
while (lanjutPesan == 1 && jumlahPesanan < 10) { ... }

// Perulangan untuk mencetak struk tiket
for (int i = 0; i < jumlahPesanan; i++){
    System.out.println(daftarPesanan[i].CetakInfo());
}
```
### 12. IO Sederhana
**Penjelasan**: Proses Input dan Output. Program menggunakan library Scanner untuk membaca teks angka yang diketik di keyboard, dan System.out.println untuk menampilkan antarmuka menu ke layar.
```Scanner scanner = new Scanner(System.in);
System.out.println("Sistem Pemesanan Tiket Bioskop Cinepolis");
String kursi = scanner.nextLine();
```
### 13. Array
**Penjelasan**: Struktur data yang bertindak seperti laci penyimpanan besar untuk mengelompokkan banyak data ke dalam satu variabel. Array di sini digunakan untuk menampung riwayat pesanan tiket hingga kapasitas 10 slot.
```Tiket [] daftarPesanan = new Tiket[10];
```
### 14. Error Handling
**Penjelasan**: Jaring pengaman program menggunakan blok try-catch. Berfungsi untuk menangkap kesalahan input (misalnya pengguna mengetik huruf padahal diminta mengetik angka) agar program tidak mati mendadak (crash), melainkan menampilkan peringatan.
```try {
    int pilihFilm = Integer.parseInt(scanner.nextLine());
} catch(Exception e){
    System.out.println("Error Massukan Angka Yang Benar");
    continue; // Mengulang proses input dari awal
}
```
## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: ZunioFarinbi
NPM: 2410010346
