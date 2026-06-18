package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak
    private String nama;
    private String nomor;
    private String email; // TAMBAHAN: Atribut email baru (Soal No. 2)

    // Constructor: Diperbarui untuk menerima parameter email (Soal No. 2)
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }

    // Getter: Cara membaca atribut dari luar class
    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }

    // TAMBAHAN: Getter untuk atribut email (Soal No. 2)
    public String getEmail() {
        return email;
    }

    // Mengubah objek menjadi satu baris teks untuk disimpan ke berkas (Soal No. 2)
    // Sekarang dipisahkan menjadi 3 bagian menggunakan tanda titik koma (;)
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }

    // Mengembalikan keterangan kontak dalam bentuk teks (Soal No. 2)
    // Sekarang memuat informasi email di dalamnya
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}