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
