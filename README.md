# **Laporan Post Test 2 PBO**
## NAMA: Chandra Perdana Phang
## NIM: 2209116025

## Tema: Showroom Motorcycle Sport

## 1. Source Code

### 1.1. Class ShowroomMotorcycle


```java
package main;

import showroom.*;

import java.util.Scanner;

public class ShowroomMotorcycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("*================================*");
            System.out.println("|Selamat Datang di Showroom Motor|");
            System.out.println("*================================*");
            System.out.println("|        1. Tambah Motor         |");
            System.out.println("==================================");
            System.out.println("|        2. Hapus Motor          |");
            System.out.println("==================================");
            System.out.println("|        3. Tampilkan Motor      |");
            System.out.println("==================================");
            System.out.println("|        4. Update Motor         |");
            System.out.println("==================================");
            System.out.println("|        5. Keluar               |");
            System.out.println("==================================");

            System.out.print("Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Masukkan Data Motor");
                    System.out.print("ID: ");
                    String id = scanner.next();
                    if (Showroom.isIdExist(id)) {
                        System.out.println("Motor dengan ID " + id + " sudah ada.");
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Price: ");
                    int price = scanner.nextInt();
                    System.out.print("Cubicle Centimeter: ");
                    int cubicleCentimeter = scanner.nextInt();

                    SportMotorcycle sportMotorcycle = new SportMotorcycle(id, brand, model, year, price, cubicleCentimeter);
                    Showroom.addMotorcycle(sportMotorcycle);
                    break;
                case 2:
                    System.out.println("Masukkan ID Motor yang Ingin Dihapus");
                    System.out.print("ID: ");
                    String idToDelete = scanner.next();
                    if (Showroom.removeMotorcycle(idToDelete)) {
                        System.out.println("Motor dengan ID " + idToDelete + " telah dihapus.");
                    } else {
                        System.out.println("Motor dengan ID " + idToDelete + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    Showroom.displayShowroom();
                    break;
                case 4:
                    System.out.println("Masukkan ID Motor yang Ingin Diupdate");
                    System.out.print("ID: ");
                    String idToUpdate = scanner.next();
                    if (!Showroom.isIdExist(idToUpdate)) {
                        System.out.println("ID Motor tidak ditemukan!");
                        break;
                    }
                    System.out.print("Brand Baru: ");
                    String newBrand = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Model Baru: ");
                    String newModel = scanner.nextLine();
                    System.out.print("Tahun Baru: ");
                    int newYear = scanner.nextInt();
                    System.out.print("Harga Baru: ");
                    int newPrice = scanner.nextInt();
                    System.out.print("Cubicle Centimeter Baru: ");
                    int newCubicleCentimeter = scanner.nextInt();

                    if (Showroom.updateMotorcycle(idToUpdate, newBrand, newModel, newYear, newPrice, newCubicleCentimeter)) {
                        System.out.println("Berhasil mengupdate motor!");
                    } else {
                        System.out.println("ID Motor tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("$==============================================$");
                    System.out.println("| Terima Kasih Telah Mengunjungi Showroom Kami |");
                    System.out.println("$==============================================$");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }

        } while (choice != 5);
    }
}

```

### 1.2. Class Motorcycle
```java
package showroom;

abstract public class Motorcycle {
    private final String id;
    private String brand;
    private String model;
    private int year;
    private int price;

    public Motorcycle(String id, String brand, String model, int year, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public final String getId() {
        return id;
    }

    public final String getBrand() {
        return brand;
    }

    public final String getModel() {
        return model;
    }

    public final int getYear() {
        return year;
    }

    public final int getPrice() {
        return price;
    }

    public final void setBrand(String brand) {
        this.brand = brand;
    }

    public final void setModel(String model) {
        this.model = model;
    }

    public final void setYear(int year) {
        this.year = year;
    }

    public final void setPrice(int price) {
        this.price = price;
    }

    abstract public void displayShowroom();

}

```

### 1.3. Class SportMotorcycle
```java
package showroom;

public class SportMotorcycle extends Motorcycle {
    private int cubicleCentimeter;

    public SportMotorcycle(String id, String brand, String model, int year, int price, int cubicleCentimeter) {
        super(id, brand, model, year, price);
        this.cubicleCentimeter = cubicleCentimeter;
    }

    public final int getCubicleCentimeter() {
        return cubicleCentimeter;
    }

    public final void setCubicleCentimeter(int cubicleCentimeter) {
        this.cubicleCentimeter = cubicleCentimeter;
    }

    @Override
    public void displayShowroom() {
        System.out.println("Sport Motorcycle");
        System.out.println("ID: " + getId());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Price: " + getPrice());
        System.out.println("Cubicle Centimeter (CC): " + getCubicleCentimeter());
        System.out.println();
    }
}
```

### 1.4. Class Showroom
```java
package showroom;

import java.util.ArrayList;

public class Showroom {
    private static final ArrayList<Motorcycle> motorcycles = new ArrayList<Motorcycle>();

    public static void addMotorcycle(Motorcycle motorcycle) {
        motorcycles.add(motorcycle);
    }

    public static boolean isIdExist(String id) {
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void displayShowroom() {
        for (Motorcycle motorcycle : motorcycles) {
            motorcycle.displayShowroom();   
        }
    }

    public static boolean updateMotorcycle(String id, String newBrand, String newModel, int newYear, int newPrice, int newCubicleCentimeter) {
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getId().equals(id)) {
                if (motorcycle instanceof SportMotorcycle) {
                    SportMotorcycle sportMotorcycle = (SportMotorcycle) motorcycle;
                    sportMotorcycle.setBrand(newBrand);
                    sportMotorcycle.setModel(newModel);
                    sportMotorcycle.setYear(newYear);
                    sportMotorcycle.setPrice(newPrice);
                    sportMotorcycle.setCubicleCentimeter(newCubicleCentimeter);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeMotorcycle(String id) {
        Motorcycle motorcycleToRemove = null;
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getId().equals(id)) {
                motorcycleToRemove = motorcycle;
                break;
            }
        }
        if (motorcycleToRemove != null) {
            motorcycles.remove(motorcycleToRemove);
            return true;
        }
        return false;
    }
}
```

## 2. Penjelasan Program

### 2.1. Class ShowroomMotorcycle
Class ini berfungsi sebagai main class yang akan dijalankan oleh program. Class ini akan menampilkan menu-menu yang tersedia dan menerima input dari user untuk memilih menu yang diinginkan. Class ini juga akan memanggil method-method yang ada di class Showroom untuk melakukan operasi-operasi yang diperlukan.

### 2.2. Class Motorcycle
Class ini merupakan class abstract yang berisi atribut-atribut yang dimiliki oleh semua jenis motor. Class ini juga berisi method abstract yang akan diimplementasikan oleh class-class turunannya.

### 2.3. Class SportMotorcycle
Class ini merupakan class turunan dari class Motorcycle yang berisi atribut-atribut yang dimiliki oleh motor sport. Class ini juga mengimplementasikan method abstract yang ada di class Motorcycle.

### 2.4. Class Showroom
Class ini berisi method-method yang akan digunakan oleh class ShowroomMotorcycle untuk melakukan operasi-operasi yang diperlukan. Class ini juga berisi atribut motorcycles yang merupakan ArrayList yang berisi semua motor yang ada di showroom.

## 3. Screenshot Program

### 3.1 Tampilan Menu
![image](https://github.com/Syzinx/postest2_pbo/assets/126861865/44b7cbc2-1a4e-4fcc-8d05-3544fbbb0206)

Pada tampilan menu, user dapat memilih menu yang diinginkan dengan memasukkan angka yang sesuai dengan menu yang diinginkan. Jika user memasukkan angka yang tidak sesuai dengan menu yang tersedia, maka akan muncul pesan "Pilihan tidak tersedia".

### 3.2 Tampilan Menu 1 / Tambah Motor
![image](https://github.com/Syzinx/postest2_pbo/assets/126861865/75ebcb99-7965-4392-9bad-75d040d816c8)

Pada menu ini, user akan diminta untuk memasukkan data-data motor yang ingin ditambahkan. Jika user memasukkan ID motor yang sudah ada, maka akan muncul pesan "Motor dengan ID <ID> sudah ada.".

### 3.3 Tampilan Menu 2 / Hapus Motor
![image](https://github.com/Syzinx/postest2_pbo/assets/126861865/e1cbbc02-3ab1-404b-912b-47d5512d7805)


Pada menu ini, user akan diminta untuk memasukkan ID motor yang ingin dihapus. Jika motor dengan ID yang dimasukkan tidak ditemukan, maka akan muncul pesan "Motor dengan ID <ID> tidak ditemukan.".

### 3.4 Tampilan Menu 3 / Tampilkan Motor
![image](https://github.com/Syzinx/postest2_pbo/assets/126861865/1779d66e-4009-4df4-9dc7-ea23f6638727)

Pada menu ini, semua motor yang ada di showroom akan ditampilkan.

### 3.5 Tampilan Menu 4 / Update Motor
![image](https://github.com/Syzinx/postest2_pbo/assets/126861865/0fffa6af-8541-45a2-9eb6-a6d0dff94f34)

Pada menu ini, user akan diminta untuk memasukkan ID motor yang ingin dihapus. Jika motor dengan ID yang dimasukkan tidak ditemukan, maka akan muncul pesan "Motor dengan ID <ID> tidak ditemukan.".

### 3.6 Tampilan Menu 5 / Keluar

Pada menu ini, program akan berhenti.


