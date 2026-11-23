public class SmsNotifikasi implements Notifikasi {

    @Override
    public void kirim(String nomor, String pesan) {
        System.out.printf("[SMS   %s] %s%n", nomor, pesan);
    }
}
