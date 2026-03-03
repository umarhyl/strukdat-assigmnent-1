abstract class Mahasiswa {
    private String nama;
    private String nrp;

    public Mahasiswa() {
        this.nama = "Belum diisi";
        this.nrp = "0000000";
    }

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama;
    }

    public abstract double hitungNilaiAkhir();

    public void tampilkanInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("NRP   : " + nrp);
    }
}

class MahasiswaReguler extends Mahasiswa {
    private final double nilaiTugas;
    private final double nilaiUts;
    private final double nilaiUas;

    public MahasiswaReguler() {
        super();
        this.nilaiTugas = 0;
        this.nilaiUts = 0;
        this.nilaiUas = 0;
    }

    public MahasiswaReguler(String nama, String nrp, double nilaiTugas, double nilaiUts, double nilaiUas) {
        super(nama, nrp);
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    @Override
    public double hitungNilaiAkhir() {
        return (0.30 * nilaiTugas) + (0.30 * nilaiUts) + (0.40 * nilaiUas);
    }
}

class MahasiswaBeasiswa extends Mahasiswa {
    private final double nilaiAkademik;
    private final double nilaiWawancara;

    public MahasiswaBeasiswa() {
        super();
        this.nilaiAkademik = 0;
        this.nilaiWawancara = 0;
    }

    public MahasiswaBeasiswa(String nama, String nrp, double nilaiAkademik, double nilaiWawancara) {
        super(nama, nrp);
        this.nilaiAkademik = nilaiAkademik;
        this.nilaiWawancara = nilaiWawancara;
    }

    @Override
    public double hitungNilaiAkhir() {
        return (0.70 * nilaiAkademik) + (0.30 * nilaiWawancara);
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("===Class & Object ===");
        MahasiswaReguler objekDefault = new MahasiswaReguler();
        MahasiswaBeasiswa objekData = new MahasiswaBeasiswa("Umar", "5027251005", 90, 84);
        objekDefault.tampilkanInfo();
        System.out.println("Object ini dibuat dari class MahasiswaReguler.");
        System.out.println("-------------------------------");
        objekData.tampilkanInfo();
        System.out.println("Object ini dibuat dari class MahasiswaBeasiswa.");
        System.out.println();

        System.out.println("=== Materi 2: Constructor & Destructor ===");
        System.out.println("Constructor default dipakai pada objekDefault (tanpa parameter).");
        System.out.println("Constructor ber-parameter dipakai pada objekData dan dataMahasiswa.");
        System.out.println("Java tidak memiliki destructor manual; memori dikelola Garbage Collector.");
        System.out.println();

        System.out.println("=== Materi 3: 4 Pilar OOP ===");
        Mahasiswa[] dataMahasiswa = {
            new MahasiswaReguler("Alya", "5027251111", 85, 80, 88),
            new MahasiswaBeasiswa("Bima", "5027251006", 90, 84)
        };

        for (Mahasiswa mahasiswa : dataMahasiswa) {
            mahasiswa.tampilkanInfo();
            System.out.printf("Nilai Akhir: %.2f%n", mahasiswa.hitungNilaiAkhir());
            System.out.println("-------------------------------");
        }

        System.out.println("Ringkasan Pilar:");
        System.out.println("1. Abstraction  -> class abstract Mahasiswa");
        System.out.println("2. Encapsulation-> atribut private + getter/setter");
        System.out.println("3. Inheritance  -> MahasiswaReguler & MahasiswaBeasiswa extends Mahasiswa");
        System.out.println("4. Polymorphism -> method hitungNilaiAkhir() di-override");
    }
}
