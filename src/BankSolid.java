
public class BankSolid {

    public static void main(String[] args) {

        // Membuat objek rekening
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);
        Deposito dewi = new Deposito("301", "Dewi", 5000000, 4.0);

        // Array seluruh rekening.
        Rekening[] semua = { ani, citra, budi, dewi };

        // Array rekening yang mendapatkan bunga.
        BerBunga[] berbunga = { ani, citra, dewi };

        // Array rekening yang bisa ditarik.
        BisaDitarik[] bisaDitarik = { ani, citra, budi };
        // Pengujian ISP:
// Error: incompatible types: Deposito cannot be converted to BisaDitarik.

        // Membuat objek notifikasi Email
        Notifikasi notifikasi = new EmailNotifikasi();

        // Memberikan notifikasi melalui constructor
        ProsesAkhirBulan proses = new ProsesAkhirBulan(notifikasi);

        // Membuat objek laporan
        LaporanBank laporan = new LaporanBank();

        // Menampilkan rekening awal
        laporan.cetakDaftar("========== REKENING AWAL ==========", semua);

        System.out.println();

        // Proses akhir bulan
        System.out.println("========== AKHIR BULAN ============");

        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(bisaDitarik, 50000);

        System.out.println();

        // Menampilkan rekening akhir
        laporan.cetakDaftar("========== REKENING AKHIR =========", semua);

        // Menampilkan total dana bank
        laporan.cetakTotal(semua);
    }
}
