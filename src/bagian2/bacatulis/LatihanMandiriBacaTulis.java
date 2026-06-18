package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LatihanMandiriBacaTulis {
    public static void main(String[] args) {
        String namaBerkas = "hari.txt";

        // =========================================================================
        // SOAL 1: Tulis 5 nama hari ke hari.txt, lalu baca kembali dan tampilkan
        // =========================================================================
        System.out.println("=== SOAL 1: Menulis & Membaca 5 Hari ===");
        
        // Proses Menulis (Overwrite)
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            penulis.println("Senin");
            penulis.println("Selasa");
            penulis.println("Rabu");
            penulis.println("Kamis");
            penulis.println("Jumat");
            System.out.println("-> Berhasil menulis 5 nama hari ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }

        // Proses Membaca Kembali
        System.out.println("Isi berkas saat ini:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println("- " + baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
        System.out.println(); // Pembatas halaman


        // =========================================================================
        // SOAL 2: Tambahkan (append) 2 nama hari lagi, lalu tampilkan seluruh isinya
        // =========================================================================
        System.out.println("=== SOAL 2: Menambahkan (Append) 2 Hari ===");
        
        // Proses Menambah data (menggunakan parameter true pada FileWriter)
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas, true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("-> Berhasil menambahkan 2 hari baru (Sabtu & Minggu).");
        } catch (IOException e) {
            System.out.println("Gagal menambah data berkas: " + e.getMessage());
        }

        // Tampilkan seluruh isi berkas setelah ditambah
        System.out.println("Isi berkas terbaru:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println("- " + baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
        System.out.println(); // Pembatas halaman


        // =========================================================================
        // SOAL 3: Baca berkas hari.txt lalu hitung jumlah baris di dalamnya
        // =========================================================================
        System.out.println("=== SOAL 3: Menghitung Jumlah Baris ===");
        
        int jumlahBaris = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            while (pembaca.readLine() != null) {
                jumlahBaris++; // Tambah 1 setiap kali membaca satu baris yang tidak null
            }
            System.out.println("Jumlah baris yang ada di dalam berkas '" + namaBerkas + "' adalah: " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Gagal menghitung baris berkas: " + e.getMessage());
        }
    }
}