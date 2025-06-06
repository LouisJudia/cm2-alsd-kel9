public class AntrianKendaraan {
    NodeKendaraan front, rear;
    int size;

    public AntrianKendaraan() {
        front = rear = null;
        size = 0;
    }

    public void tambahAntrian(Kendaraan k) {
        NodeKendaraan newNode = new NodeKendaraan(k);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(">> Kendaraan masuk ke dalam antrian.");
    }

    public Kendaraan layaniAntrian() {
        if (front == null) {
            System.out.println(">> Tidak ada kendaraan dalam antrian.");
            return null;
        }

        Kendaraan k = front.kendaraan;
        System.out.println("Petugas melayani " + k.platNomor);
        front = front.next;
        if (front == null) rear = null;
        size--;
        return k;
    }

    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("--- Antrian Kendaraan ---");
        NodeKendaraan current = front;
        while (current != null) {
            current.kendaraan.tampilkanInformasi();
            System.out.println("-------------------------");
            current = current.next;
        }
    }

    public int jumlahAntrian() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public static class NodeKendaraan {
        Kendaraan kendaraan;
        NodeKendaraan next;

        public NodeKendaraan(Kendaraan kendaraan) {
            this.kendaraan = kendaraan;
            this.next = null;
        }
    }
}
