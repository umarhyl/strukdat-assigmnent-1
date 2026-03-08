# OOP - Object Oriented Programming

## Mata Kuliah
Struktur Data dan Pemrograman Berorientasi Objek

- **Nama**: Umar
- **NRP**: 5027251005
- **Kelas**: B

---

## Class & Object

### 1. Class
**Class adalah blueprint/cetakan untuk membuat object.**

Pada program ini, class utama yang dipakai adalah `Hewan` (abstract class), lalu diturunkan menjadi:
- `Kucing`
- `Anjing`

Contoh class pada source code:

```java
abstract class Hewan {
    private String nama;
    private int umur;

    public Hewan() {
        this.nama = "Belum diisi";
        this.umur = 0;
    }

    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public abstract String bersuara();
}
```

### 2. Object
**Object adalah hasil nyata (instance) dari class.**

Object dibuat dari class turunan `Hewan` di method `main`.

```java
Kucing objekDefault = new Kucing();
Anjing objekData = new Anjing("Bruno", 3, "Golden Retriever");
```

---

## Constructor

### Constructor
**Constructor adalah method khusus yang otomatis dipanggil saat object dibuat untuk mengisi nilai awal.**

Constructor dipakai untuk mengisi nilai awal saat object dibuat.

Contoh constructor parent (default dan ber-parameter):

```java
public Hewan() {
    this.nama = "Belum diisi";
    this.umur = 0;
}

public Hewan(String nama, int umur) {
    this.nama = nama;
    this.umur = umur;
}
```

Contoh constructor child:

```java
public Kucing() {
    super();
    this.warnaBulu = "-";
}

public Kucing(String nama, int umur, String warnaBulu) {
    super(nama, umur);
    this.warnaBulu = warnaBulu;
}
```

## 4 Pilar OOP

### 1. Encapsulation
**Encapsulation adalah membungkus data agar tidak diakses langsung dari luar class.**

Data penting disembunyikan dengan `private`, lalu diakses lewat method.

```java
private String nama;
private int umur;

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
**Abstraction adalah menampilkan fitur penting dan menyembunyikan detail implementasi.**

`Hewan` dibuat sebagai abstract class dan memiliki abstract method.

```java
abstract class Hewan {
    public abstract String bersuara();
}
```

### 3. Inheritance
**Inheritance adalah pewarisan sifat/method dari class induk ke class turunan.**

Class turunan mewarisi class induk `Hewan`.

```java
class Kucing extends Hewan
class Anjing extends Hewan
```

Keduanya memakai constructor parent lewat `super(nama, umur)`.

### 4. Polymorphism
**Polymorphism adalah satu tipe referensi bisa memiliki banyak bentuk perilaku saat runtime.**

Method `bersuara()` dioverride di masing-masing class turunan, lalu dipanggil lewat referensi `Hewan`.

```java
for (Hewan hewan : dataHewan) {
    hewan.tampilkanInfo();
    System.out.println("Suara : " + hewan.bersuara());
}
```

Ini menunjukkan runtime polymorphism: method yang dipanggil menyesuaikan tipe object aslinya.

Ringkasan yang ditampilkan program:

1. Abstraction → `abstract class Hewan`
2. Encapsulation → atribut `private` + getter/setter
3. Inheritance → `Kucing` & `Anjing` mewarisi `Hewan`
4. Polymorphism → `bersuara()` dioverride di class turunan