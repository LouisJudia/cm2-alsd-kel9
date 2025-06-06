import java.util.Scanner;

public class SPBUmain {
    public static void main(String[] args) {
        Scanner kel9 = new Scanner(System.in);
        AntrianKendaraan antrian = new AntrianKendaraan();
        QueueTransaksi riwayat = new QueueTransaksi(100);

        int pilihan;
        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = kel9.nextInt();
            kel9.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println();
                    System.out.print("Masukkan Plat Nomor: ");
                    String plat = kel9.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = kel9.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merk = kel9.nextLine();
                    Kendaraan k = new Kendaraan(plat, tipe, merk);
                    antrian.tambahAntrian(k);
                    break;

                case 2:
                    System.out.println();
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    System.out.println();
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrian.jumlahAntrian());
                    break;

                case 4:
                    System.out.println();
                    if (antrian.isEmpty()) {
                        System.out.println(">> Tidak ada kendaraan dalam antrian.");
                    } else {
                        Kendaraan dilayani = antrian.layaniAntrian();
                        System.out.print("Masukkan Jenis BBM: ");
                        String namaBBM = kel9.nextLine();
                        System.out.print("Masukkan Harga per liter: ");
                        double harga = kel9.nextDouble();
                        System.out.print("Masukkan Jumlah liter: ");
                        double liter = kel9.nextDouble();
                        kel9.nextLine();

                        BBM bbm = new BBM(namaBBM, harga);
                        TransaksiPengisian t = new TransaksiPengisian(dilayani, bbm, liter);
                        riwayat.tambahTransaksi(t);
                    }
                    break;

                case 5:
                    System.out.println();
                    riwayat.tampilkanRiwayat();
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}

