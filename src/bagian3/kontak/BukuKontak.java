package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek bertipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    // Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    // SOAL NO. 1: Method mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        boolean ditemukan = false;
        for (Kontak k : daftar) {
            // Menggunakan equalsIgnoreCase agar pencarian tidak sensitif huruf besar/kecil
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("[Cari Kontak] Ditemukan: " + k.info());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("[Cari Kontak] Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // SOAL NO. 3: Method menghapus kontak berdasarkan nama, lalu simpan perubahan
    public void hapusKontak(String nama) {
        boolean berhasilHapus = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                System.out.println("-> Kontak '" + nama + "' berhasil dihapus dari list.");
                berhasilHapus = true;
                break; 
            }
        }

        if (berhasilHapus) {
            // Memanggil simpanKeBerkas agar berkas teks ikut diperbarui (Soal No. 3)
            simpanKeBerkas();
        } else {
            System.out.println("-> Gagal menghapus, kontak '" + nama + "' tidak ditemukan.");
        }
    }

    // Menyimpan seluruh kontak ke berkas, satu kontak per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // Membaca kembali kontak dari berkas ke dalam ArrayList
    // SOAL NO. 2: Diperbarui agar memecah baris menjadi TIGA bagian (nama, nomor, email)
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                // Validasi disesuaikan menjadi 3 bagian (Soal No. 2)
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}