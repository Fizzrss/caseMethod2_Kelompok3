package StudiKasus2;

public class queueTransaksi {
    transaksiLayanan[] data;
    int front, rear, size, max;

    
    queueTransaksi(int kapasitas) {
        max = kapasitas;
        data = new transaksiLayanan[kapasitas];
        front = size = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    void tambahTransaksi(transaksiLayanan t) {
        if (isFull()) {
            System.out.println("Riwayat transaksi penuh!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = t;
        size++;
    }

    void tampilkanRiwayat() {
        if (isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            data[index].tampilkanTransaksi();
        }
    }
}
