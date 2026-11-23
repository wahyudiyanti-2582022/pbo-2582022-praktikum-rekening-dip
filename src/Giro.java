public class Giro extends Rekening implements BisaDitarik {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15000;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo + batasOverdraft) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public String keterangan() {
        return "Giro, batas overdraft " + formatRupiah(batasOverdraft);
    }
}