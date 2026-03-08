// Abstraction: class abstract sebagai blueprint umum Hewan
abstract class Hewan {
    // Encapsulation: data disembunyikan dengan akses private
    private String nama;
    private int umur;

    // Constructor default
    public Hewan() {
        this.nama = "Hewan tanpa nama";
        this.umur = 0;
    }

    // Constructor ber-parameter
    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    // Encapsulation: validasi sebelum data diubah
    public void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama;
    }

    // Abstraction: detail perhitungan diserahkan ke class turunan
    public abstract String bersuara();

    public void tampilkanInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("Umur  : " + umur + " tahun");
    }
}

// Inheritance: Kucing mewarisi Hewan
class Kucing extends Hewan {
    private final String warnaBulu;

    public Kucing() {
        super();
        this.warnaBulu = "-";
    }

    public Kucing(String nama, int umur, String warnaBulu) {
        super(nama, umur);
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis : Kucing");
        System.out.println("Warna : " + warnaBulu);
    }

    // Polymorphism (override): implementasi khusus kucing
    @Override
    public String bersuara() {
        return "Meong meong";
    }
}

// Inheritance: Anjing mewarisi Hewan
class Anjing extends Hewan {
    private final String ras;

    public Anjing() {
        super();
        this.ras = "-";
    }

    public Anjing(String nama, int umur, String ras) {
        super(nama, umur);
        this.ras = ras;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis : Anjing");
        System.out.println("Ras   : " + ras);
    }

    // Polymorphism (override): implementasi khusus anjing
    @Override
    public String bersuara() {
        return "Guk guk";
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("[1] Class & Object");
        Kucing objekDefault = new Kucing();
        Anjing objekData = new Anjing("Bruno", 3, "Golden Retriever");

        objekDefault.tampilkanInfo();
        System.out.println("Dibuat dari class Kucing");
        System.out.println();

        objekData.tampilkanInfo();
        System.out.println("Dibuat dari class Anjing");
        System.out.println("-------------------------------\n");

        System.out.println("[2] Constructor");
        System.out.println("objekDefault pakai constructor kosong");
        System.out.println("objekData pakai constructor dengan parameter");
        System.out.println("(Di Java, memori dibersihkan otomatis oleh GC)");
        System.out.println("-------------------------------\n");

        System.out.println("[3] 4 Pilar OOP");
        // Polymorphism: satu tipe referensi (Hewan) untuk object berbeda
        Hewan[] dataHewan = {
            new Kucing("Milo", 2, "Oren"),
            new Anjing("Buddy", 4, "Husky")
        };

        for (Hewan hewan : dataHewan) {
            hewan.tampilkanInfo();
            System.out.println("Suara : " + hewan.bersuara());
            System.out.println("-------------------------------");
        }

        System.out.println("Ringkasannya:");
        System.out.println("- Abstraction: class abstract Hewan");
        System.out.println("- Encapsulation: atribut private + getter/setter");
        System.out.println("- Inheritance: Kucing dan Anjing mewarisi Hewan");
        System.out.println("- Polymorphism: method bersuara() beda hasil tiap object");
    }
}
