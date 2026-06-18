package tugas;

/**
 * Nama : Zahratunnisa
 * NPM  : 2410010299
 */
public class MainTugas {
    public static void main(String[] args) {
        String fileData = "barang.txt";
        
        // 1. Menyimpan nama kategori ke array String
        String[] kategori = {"Elektronik", "Pakaian", "Makanan & Minuman", "Alat Tulis"};
        
        System.out.println("=== KATEGORI TOKO ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println("- Kategori " + (i + 1) + ": " + kategori[i]);
        }
        System.out.println();

        // 2. Inisialisasi Gudang Pertama & Tambah 5 Barang
        Gudang gudangSatu = new Gudang(fileData);
        gudangSatu.tambahBarang(new Barang("Laptop ASUS Vivobook", 8500000, 5));
        gudangSatu.tambahBarang(new Barang("Mouse Wireless Logitech", 150000, 15));
        gudangSatu.tambahBarang(new Barang("Keyboard Mekanikal", 450000, 8));
        gudangSatu.tambahBarang(new Barang("Monitor LED 24 Inch", 1750000, 4));
        gudangSatu.tambahBarang(new Barang("Headset Gaming RGB", 320000, 10));

        System.out.println("=== PROSES GUDANG UTAMA ===");
        gudangSatu.tampilkanSemua();
        System.out.println("Total Nilai Persediaan Awal : Rp" + gudangSatu.totalNilai());
        gudangSatu.simpanKeBerkas();
        System.out.println();

        // 3. Membuat Objek Gudang Baru untuk Validasi Pembuktian Data
        System.out.println("=== VALIDASI PEMBUKTIAN PADA GUDANG BARU ===");
        Gudang gudangValidasi = new Gudang(fileData);
        gudangValidasi.muatDariBerkas();
        gudangValidasi.tampilkanSemua();
        System.out.println("Total Nilai Persediaan Validasi : Rp" + gudangValidasi.totalNilai());
    }
}