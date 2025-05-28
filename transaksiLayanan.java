package StudiKasus2;

public class transaksiLayanan {
    pasien Pasien;
    dokter Dokter;
    int durasiLayanan;
    int biaya;

    transaksiLayanan(pasien pasien, dokter dokter, int durasi){
        Pasien = pasien;
        Dokter = dokter;
        durasiLayanan = durasi;
        biaya = hitungBiaya();
    }

    public int hitungBiaya(){
        return durasiLayanan* 50000;
    }

    void tampilkanTransaksi() {
        System.out.println(Pasien.nama + "(" + durasiLayanan + " jam): RP " + biaya);
    }
}

