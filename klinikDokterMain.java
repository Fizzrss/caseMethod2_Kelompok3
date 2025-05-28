import java.util.Scanner;

public class klinikDokterMain {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        linkedLiisdAntrian antrian = new linkedLiisdAntrian();
        queueTransaksi riwayat = new queueTransaksi(100);

        while (true) {
            System.out.println("\n=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama Pasien: ");
                    String nama = input.nextLine();
                    System.out.print("NIK: ");
                    String nik = input.nextLine();
                    System.out.print("Keluhan: ");
                    String keluhan = input.nextLine();
                    pasien pasien = new pasien(nama, nik, keluhan);
                    antrian.tambahAntrian(pasien);
                    System.out.println(">> Pasien masuk ke dalam antrian.");
                    break;

                case 2:
                    System.out.println("\n=== Daftar Antrian Pasien ===");
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    pasien p = antrian.layaniAntrian();
                    if (p == null) {
                        System.out.println("Tidak ada pasien dalam antrian.");
                        break;
                    }
                    System.out.println("Pasien " + p.nama + " dipanggil");
                    System.out.print("ID Dokter: ");
                    String idDokter = input.nextLine();
                    System.out.print("Nama Dokter: ");
                    String namaDokter = input.nextLine();
                    System.out.print("Durasi Layanan (jam): ");
                    int durasi = input.nextInt();
                    input.nextLine();
                    dokter d = new dokter(idDokter, namaDokter);
                    transaksiLayanan t = new transaksiLayanan(p, d, durasi);
                    riwayat.tambahTransaksi(t);
                    System.out.println(">> Pasien telah dilayani,transaksi berhasil dicatat");
                    break;

                case 4:
                    System.out.println("Sisa antrian: " + antrian.hitungAntrian() + " pasien.");
                    break;

                case 5:
                    System.out.println("\n=== Riwayat Transaksi ===");
                    riwayat.tampilkanRiwayat();
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
            input.close();
        }
    }
}
