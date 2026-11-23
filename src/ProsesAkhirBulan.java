
public class ProsesAkhirBulan {

    private final Notifikasi notifikasi;

    public ProsesAkhirBulan(Notifikasi notifikasi) {
        this.notifikasi = notifikasi;
    }

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();

            notifikasi.kirim(
                    r.getNomor(),
                    "biaya admin " + Rekening.formatRupiah(biaya)
            );
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();

            notifikasi.kirim(
                    b.getNomor(),
                    "bunga " + Rekening.formatRupiah(bunga)
            );
        }
    }

    public void autodebet(BisaDitarik[] semua, int jumlah) {
        for (BisaDitarik r : semua) {
            String hasil = r.tarik(jumlah)
                    ? Rekening.formatRupiah(jumlah) + " berhasil"
                    : "gagal";

            notifikasi.kirim(
                    r.getNomor(),
                    "autodebet " + hasil
            );
        }
    }
}
