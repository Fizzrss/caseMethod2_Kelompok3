public class linkedLiisdAntrian {
    node head;
    node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(pasien p) {
        node nodeBaru = new node(p, null);
        if (isEmpty()) {
            head = tail = nodeBaru;
        } else {
            tail.next = nodeBaru;
            tail = nodeBaru;
        }
    }

    public pasien layaniAntrian() {
        if (isEmpty()){
            System.out.println("Antrian kosong");
           return null; 
        } 
        pasien temp = head.data;
        head = head.next;
        return temp;
    }


    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        node current = head;
        while (current != null) {
            current.data.tampilkanInformasi();
            System.out.println("--------------------");
            current = current.next;
        }
    }

    public int hitungAntrian() {
        int count = 0;
        node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
