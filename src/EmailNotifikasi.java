public class EmailNotifikasi implements Notifikasi {

    @Override
    public void kirim(String nomor, String pesan) {
        System.out.printf("[EMAIL %s] %s%n", nomor, pesan);
    }
}
