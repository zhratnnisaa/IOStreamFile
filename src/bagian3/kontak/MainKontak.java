package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // Membuat objek pengelola dan mengisinya dengan format 3 parameter (Soal No. 2)
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@gmail.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@yahoo.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@outlook.com"));
        
        System.out.println("--- KONDISI AWAL ---");
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        
        System.out.println();
        System.out.println("--- PENGUJIAN SOAL 1 (Cari Kontak) ---");
        buku.cariKontak("Budi");  // Skenario data ada
        buku.cariKontak("Dewi");  // Skenario data tidak ada
        
        System.out.println();
        System.out.println("--- PENGUJIAN SOAL 3 (Hapus Kontak & Auto Simpan) ---");
        buku.hapusKontak("Andi"); // Menghapus Andi dan memperbarui file teks berkas
        
        System.out.println();
        System.out.println("--- VERIFIKASI DENGAN MEMBUAT OBJEK BARU ---");
        // Objek baru yang kosong, lalu memuat data terbaru dari berkas (Soal No. 2)
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak saat ini: " + bukuLain.jumlahKontak());
    }
}