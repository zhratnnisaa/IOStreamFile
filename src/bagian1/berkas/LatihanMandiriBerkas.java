package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiriBerkas {
    public static void main(String[] args) {
        
        // =========================================================================
        // SOAL 1: Menunjuk laporan.txt, cek keberadaan, dan tampilkan ukuran byte
        // =========================================================================
        System.out.println("=== SOAL 1 ===");
        File berkasLaporan = new File("laporan.txt");
        
        boolean apakahAda = berkasLaporan.exists();
        System.out.println("Apakah berkas 'laporan.txt' ada? : " + apakahAda);
        
        if (apakahAda) {
            System.out.println("Ukuran berkas : " + berkasLaporan.length() + " byte");
        } else {
            System.out.println("Ukuran berkas : Tidak dapat ditampilkan (berkas tidak ada).");
        }
        
        System.out.println(); // Baris kosong pembatas

        // =========================================================================
        // SOAL 2: Membuat folder 'arsip' menggunakan mkdir() beserta statusnya
        // =========================================================================
        System.out.println("=== SOAL 2 ===");
        File folderArsip = new File("arsip");
        
        if (folderArsip.mkdir()) {
            System.out.println("Pesan: Folder 'arsip' berhasil dibuat!");
        } else {
            System.out.println("Pesan: Folder 'arsip' gagal dibuat (mungkin sudah ada sebelumnya).");
        }
        
        System.out.println(); // Baris kosong pembatas

        // =========================================================================
        // SOAL 3: Membuat sementara.txt, cek sebelum & sesudah menggunakan delete()
        // =========================================================================
        System.out.println("=== SOAL 3 ===");
        File berkasSementara = new File("sementara.txt");
        
        try {
            // Membuat fisik berkas di disk
            if (berkasSementara.createNewFile()) {
                System.out.println("-> Berkas 'sementara.txt' berhasil dibuat.");
            }
            
            // Menampilkan status SEBELUM dihapus
            System.out.println("Status keberadaan SEBELUM dihapus : " + berkasSementara.exists());
            
            // Menghapus berkas
            if (berkasSementara.delete()) {
                System.out.println("-> Berkas 'sementara.txt' berhasil dihapus.");
            } else {
                System.out.println("-> Gagal menghapus berkas.");
            }
            
            // Menampilkan status SESUDAH dihapus
            System.out.println("Status keberadaan SESUDAH dihapus  : " + berkasSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O pada Soal 3: " + e.getMessage());
        }
    }
}