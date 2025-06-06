public class QueueTransaksi {
    TransaksiPengisian[] queue;
    int front, rear, size, max;

    public QueueTransaksi(int max) {
        this.max = max;
        queue = new TransaksiPengisian[max];
        front = rear = size = 0;
    }

    public void tambahTransaksi(TransaksiPengisian transaksi) {
        if (size == max) {
            System.out.println(">> Riwayat transaksi penuh.");
            return;
        }
        queue[rear] = transaksi;
        rear = (rear + 1) % max;
        size++;
        System.out.println(">> Transaksi berhasil dicatat.");
    }

    public void tampilkanRiwayat() {
        if (size == 0) {
            System.out.println(">> Tidak ada transaksi yang dicatat.");
            return;
        }

        System.out.println("--- Riwayat Transaksi ---");
        System.out.println("Daftar Transaksi:");
        int i = front;
        for (int j = 0; j < size; j++) {
            System.out.println(queue[i].kendaraan.platNomor + ": Rp " + queue[i].totalBayar);
            i = (i + 1) % max;
        }
        System.out.println("--------------------------");
    }
}

