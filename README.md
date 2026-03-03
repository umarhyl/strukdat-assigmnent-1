# OOP - Object Oriented Programming

## Mata Kuliah
Struktur Data dan Pemrograman Berorientasi Objek

## Identitas
- **Nama**: Umar
- **NRP**: 5027251005
- **Kelas**: B

---

## Materi 1 - Class & Object

### 1. Class
Pada program ini, class utama yang dipakai adalah `Mahasiswa` (abstract class), lalu diturunkan menjadi:
- `MahasiswaReguler`
- `MahasiswaBeasiswa`

Contoh class pada source code:

```java
abstract class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa() {
        this.nama = "Belum diisi";
        this.nim = "0000000";
    }

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public abstract double hitungNilaiAkhir();
}
```

### 2. Object
Object dibuat dari class turunan `Mahasiswa` di method `main`.

```java
MahasiswaReguler objekDefault = new MahasiswaReguler();
MahasiswaBeasiswa objekData = new MahasiswaBeasiswa("Bima", "2401002", 90, 84);
```

---

## Materi 2 - Constructor & Destructor

### 1. Constructor
Constructor dipakai untuk mengisi nilai awal saat object dibuat.

Contoh constructor parent (default dan ber-parameter):

```java
public Mahasiswa() {
    this.nama = "Belum diisi";
    this.nim = "0000000";
}

public Mahasiswa(String nama, String nim) {
    this.nama = nama;
    this.nim = nim;
}
```

Contoh constructor child:

```java
public MahasiswaReguler() {
    super();
    this.nilaiTugas = 0;
    this.nilaiUts = 0;
    this.nilaiUas = 0;
}

public MahasiswaReguler(String nama, String nim, double nilaiTugas, double nilaiUts, double nilaiUas) {
    super(nama, nim);
    this.nilaiTugas = nilaiTugas;
    this.nilaiUts = nilaiUts;
    this.nilaiUas = nilaiUas;
}
```

### 2. Destructor
Java tidak memiliki destructor seperti C++.
Pembersihan memori ditangani otomatis oleh Garbage Collector (GC).

---

## Materi 3 - 4 Pilar OOP

### 1. Encapsulation
Data penting disembunyikan dengan `private`, lalu diakses lewat method.

```java
private String nama;
private String nim;

public String getNama() {
    return nama;
}

public void setNama(String nama) {
    if (nama == null || nama.isBlank()) {
        throw new IllegalArgumentException("Nama tidak boleh kosong");
    }
    this.nama = nama;
}
```

### 2. Abstraction
`Mahasiswa` dibuat sebagai abstract class dan memiliki abstract method.

```java
abstract class Mahasiswa {
    public abstract double hitungNilaiAkhir();
}
```

### 3. Inheritance
Class turunan mewarisi class induk `Mahasiswa`.

```java
class MahasiswaReguler extends Mahasiswa
class MahasiswaBeasiswa extends Mahasiswa
```

Keduanya memakai constructor parent lewat `super(nama, nim)`.

### 4. Polymorphism
Method `hitungNilaiAkhir()` dioverride di masing-masing class turunan, lalu dipanggil lewat referensi `Mahasiswa`.

```java
for (Mahasiswa mahasiswa : dataMahasiswa) {
    mahasiswa.tampilkanInfo();
    System.out.printf("Nilai Akhir: %.2f%n", mahasiswa.hitungNilaiAkhir());
}
```

Ini menunjukkan runtime polymorphism: method yang dipanggil menyesuaikan tipe object aslinya.

Ringkasan yang ditampilkan program:

1. Abstraction → `abstract class Mahasiswa`
2. Encapsulation → atribut `private` + getter/setter
3. Inheritance → `MahasiswaReguler` & `MahasiswaBeasiswa` mewarisi `Mahasiswa`
4. Polymorphism → `hitungNilaiAkhir()` dioverride di class turunan