import java.io.*;
import java.util.*;

class Food implements Serializable {
    int itemno;
    int quantity;
    float price;

    Food(int itemno, int quantity) {
        this.itemno = itemno;
        this.quantity = quantity;
        switch (itemno) {
            case 1:
                price = quantity * 50;
                break;
            case 2:
                price = quantity * 60;
                break;
            case 3:
                price = quantity * 70;
                break;
            case 4:
                price = quantity * 30;
                break;
        }
    }
}

class Singleroom implements Serializable {
    String name;
    String contact;
    String gender;
    ArrayList<Food> food = new ArrayList<>();

    Singleroom() {
        this.name = "";
    }

    Singleroom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}

class Doubleroom extends Singleroom {
    String name2;
    String contact2;
    String gender2;

    Doubleroom() {
        this.name = "";
        this.name2 = "";
    }

    Doubleroom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}

class NotAvailable extends Exception {
    NotAvailable(String mes) {
        super(mes);
    }
}

class holder implements Serializable {
    Doubleroom luxury_doubleroom[] = new Doubleroom[10];
    Doubleroom deluxe_doubleroom[] = new Doubleroom[20];
    Singleroom luxury_singleroom[] = new Singleroom[10];
    Singleroom deluxe_singleroom[] = new Singleroom[20];
}

class Hotel {
    static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);

    static void CustDetails(int i, int rn) throws NotAvailable {
        // try {
            String name, contact, gender;
            String name2 = null, contact2 = null;
            String gender2 = "";
            System.out.print("\nEnter customer name: ");
            name = sc.nextLine();
            while (!name.matches("[a-zA-Z]+")) {
                System.out.print("Enter valid customer name (Must be string only): ");
                name = sc.nextLine();
            }
            System.out.print("Enter contact number: ");
            contact = sc.nextLine();
            while (!contact.matches("\\d{10}")) {
                System.out.print("Enter valid contact number (Must have 10 digits): ");
                contact = sc.nextLine();
            }
            for (int j = 0; j < hotel_ob.luxury_doubleroom.length; j++) {
                if (hotel_ob.luxury_doubleroom[j] != null) {
                    if (hotel_ob.luxury_doubleroom[j].contact.equals(contact)) {
                        throw new NotAvailable("CONTACT ALREADY EXISTS.");
                    }
                }
            }
            for (int j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                if (hotel_ob.deluxe_doubleroom[j] != null) {
                    if (hotel_ob.deluxe_doubleroom[j].contact.equals(contact)) {
                        throw new NotAvailable("CONTACT ALREADY EXISTS.");
                    }
                }
            }
            for (int j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                if (hotel_ob.luxury_singleroom[j] != null) {
                    if (hotel_ob.luxury_singleroom[j].contact.equals(contact)) {
                        throw new NotAvailable("CONTACT ALREADY EXISTS.");
                    }
                }
            }
            for (int j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                if (hotel_ob.deluxe_singleroom[j] != null) {
                    if (hotel_ob.deluxe_singleroom[j].contact.equals(contact)) {
                        throw new NotAvailable("CONTACT ALREADY EXISTS.");
                    }
                }
            }
            System.out.print("Enter gender [male/female]: ");
            gender = sc.nextLine();
            while (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
                System.out.print("Enter valid gender [male/female]: ");
                gender = sc.nextLine();
            }
            if (i < 3) {
                System.out.print("Enter second customer name: ");
                name2 = sc.nextLine();
                while (!name2.matches("[a-zA-Z]+")) {
                    System.out.print("Enter valid second customer name: ");
                    name2 = sc.nextLine();
                }
                System.out.print("Enter contact number: ");
                contact2 = sc.nextLine();
                while (!contact2.matches("\\d{10}")) {
                    System.out.print("Enter valid contact number: ");
                    contact2 = sc.nextLine();
                }
                for (int j = 0; j < hotel_ob.luxury_doubleroom.length; j++) {
                    if (hotel_ob.luxury_doubleroom[j] != null) {
                        if (hotel_ob.luxury_doubleroom[j].contact2.equals(contact2)) {
                            throw new NotAvailable("CONTACT ALREADY EXISTS.");
                        }
                    
                    }
                }
                for (int j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] != null) {
                        if (hotel_ob.deluxe_doubleroom[j].contact2.equals(contact2)) {
                            throw new NotAvailable("CONTACT ALREADY EXISTS.");
                        }
                    }
                }
                for (int j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                    if (hotel_ob.luxury_singleroom[j] != null) {
                        if (hotel_ob.luxury_singleroom[j].contact.equals(contact2)) {
                            throw new NotAvailable("CONTACT ALREADY EXISTS.");
                        }
                    }
                }
                for (int j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                    if (hotel_ob.deluxe_singleroom[j] != null) {
                        if (hotel_ob.deluxe_singleroom[j].contact.equals(contact2)) {
                            throw new NotAvailable("CONTACT ALREADY EXISTS.");
                        }
                    }
                }
                System.out.print("Enter gender [male/female]: ");
                gender2 = sc.nextLine();
                while (!(gender2.equalsIgnoreCase("male") || gender2.equalsIgnoreCase("female"))) {
                    System.out.print("Enter valid gender [male/female]: ");
                    gender2 = sc.nextLine();
                }
            }

            switch (i) {
                case 1:
                    hotel_ob.luxury_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                    break;
                case 2:
                    hotel_ob.deluxe_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                    break;
                case 3:
                    hotel_ob.luxury_singleroom[rn] = new Singleroom(name, contact, gender);
                    break;
                case 4:
                    hotel_ob.deluxe_singleroom[rn] = new Singleroom(name, contact, gender);
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
        // } catch (Exception e) {
            // System.out.println(e.getMessage());
        // }
    }

    static void bookroom(int i) {
        int luxuryDouble = 0, luxurySingle = 0, deluxeDouble = 0, deluxeSingle = 0;
        int j;
        int rn;
        switch (i) {
            case 1:
                System.out.print("\nLuxury Double Rooms Available: ");
                for (j = 0; j < hotel_ob.luxury_doubleroom.length; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null) {
                        System.out.print(j + 1 + ",");
                        luxuryDouble++;
                    }
                }
                if (luxuryDouble == 0) {
                    System.out.println("No available rooms!");
                } else {
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        sc.nextLine();
                        rn--;
                        if (hotel_ob.luxury_doubleroom[rn] != null)
                            throw new NotAvailable("\nRoom Not Available !");
                        CustDetails(i, rn);
                        System.out.println("\nRoom Booked Successfully");
                    } catch (NotAvailable e) {
                        System.out.println(e.getMessage());
                        return;
                    } catch (Exception e) {
                        System.out.println("\nInvalid Room Number!!");
                        return;
                    }
                }
                break;
            case 2:
                System.out.print("\nDeluxe Double Rooms Available: ");
                for (j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null) {
                        System.out.print(j + 11 + ",");
                        deluxeDouble++;
                    }
                }
                if (deluxeDouble == 0) {
                    System.out.println("No available rooms!");
                } else {
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        sc.nextLine();
                        rn = rn - 11;
                        if (hotel_ob.deluxe_doubleroom[rn] != null)
                            throw new NotAvailable("\nRoom Not Available !");
                        CustDetails(i, rn);
                        System.out.println("\nRoom Booked Successfully");
                    } catch (NotAvailable e) {
                        System.out.println(e.getMessage());
                        return;
                    } catch (Exception e) {
                        System.out.println("\nInvalid Room Number!!");
                        return;
                    }
                }
                break;
            case 3:
                System.out.print("\nLuxury Single Rooms Available: ");
                for (j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                    if (hotel_ob.luxury_singleroom[j] == null) {
                        System.out.print(j + 31 + ",");
                        luxurySingle++;
                    }
                }
                if (luxurySingle == 0) {
                    System.out.println("No available rooms!");
                } else {
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        sc.nextLine();
                        rn = rn - 31;
                        if (hotel_ob.luxury_singleroom[rn] != null)
                            throw new NotAvailable("\nRoom Not Available !");
                        CustDetails(i, rn);
                        System.out.println("\nRoom Booked Successfully");
                    } catch (NotAvailable e) {
                        System.out.println(e.getMessage());
                        return;
                    } catch (Exception e) {
                        System.out.println("\nInvalid Room Number!!");
                        return;
                    }
                }
                break;
            case 4:
                System.out.print("\nDeluxe Single Rooms Available: ");
                for (j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                    if (hotel_ob.deluxe_singleroom[j] == null) {
                        System.out.print(j + 41 + ",");
                        deluxeSingle++;
                    }
                }
                if (deluxeSingle == 0) {
                    System.out.println("No available rooms!");
                } else {
                    System.out.print("\nEnter room number: ");
                    try {
                        rn = sc.nextInt();
                        sc.nextLine();
                        rn = rn - 41;
                        if (hotel_ob.deluxe_singleroom[rn] != null)
                            throw new NotAvailable("\nRoom Not Available !");
                        CustDetails(i, rn);
                        System.out.println("\nRoom Booked Successfully");
                    } catch (NotAvailable e) {
                        System.out.println(e.getMessage());
                        return;
                    } catch (Exception e) {
                        System.out.println("\nInvalid Room Number!!");
                        return;
                    }
                }
                break;
            default:
                System.out.println("\nChoose Valid Room!!");
                break;
        }
    }

    static void features(int i) {
        switch (i) {
            case 1:
                System.out.println("\n************************************************************");
                System.out.println("*                   Room Details                           *");
                System.out.println("************************************************************");
                System.out.println("*  Number of double beds: 1                                *");
                System.out.println("*  AC: Yes                                                 *");
                System.out.println("*  Free breakfast: Yes                                     *");
                System.out.println("*  Charge per day: 4000                                    *");
                System.out.println("************************************************************");
                break;
            case 2:
                System.out.println("\n************************************************************");
                System.out.println("*                   Room Details                           *");
                System.out.println("************************************************************");
                System.out.println("*  Number of double beds : 1                               *");
                System.out.println("*  AC : No                                                 *");
                System.out.println("*  Free breakfast : Yes                                    *");
                System.out.println("*  Charge per day : 3000                                   *");
                System.out.println("************************************************************");
                break;
            case 3:
                System.out.println("\n************************************************************");
                System.out.println("*                   Room Details                           *");
                System.out.println("************************************************************");
                System.out.println("*  Number of single beds : 1                               *");
                System.out.println("*  AC : Yes                                                *");
                System.out.println("*  Free breakfast : Yes                                    *");
                System.out.println("*  Charge per day : 2200                                   *");
                System.out.println("************************************************************");
                break;
            case 4:
                System.out.println("\n************************************************************");
                System.out.println("*                   Room Details                           *");
                System.out.println("************************************************************");
                System.out.println("*  Number of single beds : 1                               *");
                System.out.println("*  AC : No                                                 *");
                System.out.println("*  Free breakfast : Yes                                    *");
                System.out.println("*  Charge per day : 1200                                   *");
                System.out.println("************************************************************");
                break;
            default:
                System.out.println("\nChoose Valid Room!!");
                break;
        }
    }

    static void availability(int i) {
        int j, count = 0;
        switch (i) {
            case 1:
                for (j = 0; j < 10; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null)
                        count++;
                }
                System.out.println("\n************************************************************");
                System.out.println("*                Room Availability                         *");
                System.out.println("************************************************************");
                System.out.println("*  Number of rooms available : " + count + "                           *");
                System.out.println("************************************************************");

                break;
            case 2:
                for (j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null)
                        count++;
                }
                System.out.println("\n************************************************************");
                System.out.println("*                Room Availability                         *");
                System.out.println("************************************************************");
                System.out.println("*  Number of rooms available : " + count + "                           *");
                System.out.println("************************************************************");
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                    if (hotel_ob.luxury_singleroom[j] == null)
                        count++;
                }
                System.out.println("\n************************************************************");
                System.out.println("*                Room Availability                         *");
                System.out.println("************************************************************");
                System.out.println("*  Number of rooms available : " + count + "                           *");
                System.out.println("************************************************************");
                break;
            case 4:
                for (j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                    if (hotel_ob.deluxe_singleroom[j] == null)
                        count++;
                }
                System.out.println("\n************************************************************");
                System.out.println("*                Room Availability                         *");
                System.out.println("************************************************************");
                System.out.println("*  Number of rooms available : " + count + "                           *");
                System.out.println("************************************************************");
                break;
            default:
                System.out.println("\nChoose Valid Room!!");
                break;
        }
    }

    static void bill(int rn, int rtype) {
        double amount = 0;
        String list[] = { "Sandwich", "Pasta", "Noodles", "Coke" };
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch (rtype) {
            case 1:
                amount += 4000;
                System.out.println("\nRoom Charge - " + 4000);
                System.out.println("\n***************");
                System.out.println("Food Charges:- ");
                System.out.println("***************");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.luxury_doubleroom[rn].food) {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }

                break;
            case 2:
                amount += 3000;
                System.out.println("Room Charge - " + 3000);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.deluxe_doubleroom[rn].food) {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            case 3:
                amount += 2200;
                System.out.println("Room Charge - " + 2200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.luxury_singleroom[rn].food) {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            case 4:
                amount += 1200;
                System.out.println("Room Charge - " + 1200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.deluxe_singleroom[rn].food) {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- " + amount);
    }

    static void deallocate(int rn, int rtype) {
        String w;
        switch (rtype) {
            case 1:
                if (hotel_ob.luxury_doubleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.luxury_doubleroom[rn].name);
                else {
                    System.out.println("\nRoom Already Empty!!");
                    return;
                }
                System.out.print("\nDo you want to checkout (y/n)?");
                w = sc.nextLine();
                if (w.equalsIgnoreCase("y")) {
                    bill(rn, rtype);
                    hotel_ob.luxury_doubleroom[rn] = null;
                    System.out.println("\nRoom Deallocated succesfully");
                } else {
                    System.out.println("\nRoom Deallocation Unsuccesfull");
                }
                break;
            case 2:
                if (hotel_ob.deluxe_doubleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.deluxe_doubleroom[rn].name);
                else {
                    System.out.println("\nRoom Already Empty!!");
                    return;
                }
                System.out.print("\nDo you want to checkout (y/n)?");
                w = sc.nextLine();
                if (w.equalsIgnoreCase("y")) {
                    bill(rn, rtype);
                    hotel_ob.deluxe_doubleroom[rn] = null;
                    System.out.println("\nRoom Deallocated succesfully");
                } else {
                    System.out.println("\nRoom Deallocation Unsuccesfull");
                }
                break;
            case 3:
                if (hotel_ob.luxury_singleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.luxury_singleroom[rn].name);
                else {
                    System.out.println("\nRoom Already Empty!!");
                    return;
                }
                System.out.print("\nDo you want to checkout (y/n)?");
                w = sc.nextLine();
                System.out.println("ww" + w + "w");
                if (w.equalsIgnoreCase("y")) {
                    bill(rn, rtype);
                    hotel_ob.luxury_singleroom[rn] = null;
                    System.out.println("\nRoom Deallocated succesfully");
                } else {
                    System.out.println("\nRoom Deallocation Unsuccesfull");
                }
                break;
            case 4:
                if (hotel_ob.deluxe_singleroom[rn] != null)
                    System.out.println("Room used by " + hotel_ob.deluxe_singleroom[rn].name);
                else {
                    System.out.println("\nRoom Already Empty!!");
                    return;
                }
                System.out.print("\nDo you want to checkout (y/n)?");
                w = sc.nextLine();
                if (w.equalsIgnoreCase("y")) {
                    bill(rn, rtype);
                    hotel_ob.deluxe_singleroom[rn] = null;
                    System.out.println("\nRoom Deallocated succesfully");
                } else {
                    System.out.println("\nRoom Deallocation Unsuccesfull");
                }
                break;
            default:
                System.out.println("\nEnter valid Choice");
                break;
        }
    }

    static boolean updateFoodItem(ArrayList<Food> foodList, int itemno, int quantity) {
        for (Food food : foodList) {
            if (food.itemno == itemno) {
                food.quantity += quantity;
                switch (itemno) {
                    case 1:
                        food.price += quantity * 50;
                        break;
                    case 2:
                        food.price += quantity * 60;
                        break;
                    case 3:
                        food.price += quantity * 70;
                        break;
                    case 4:
                        food.price += quantity * 30;
                        break;
                }
                return true;
            }
        }
        return false;
    }

    static void order(int rn, int rtype) {
        int i, q;
        String wish;
        try {
            switch (rtype) {
                case 1:
                    if (hotel_ob.luxury_doubleroom[rn] == null) {
                        System.out.println("\nRoom not booked");
                        return;
                    }
                    break;
                case 2:
                    if (hotel_ob.deluxe_doubleroom[rn] == null) {
                        System.out.println("\nRoom not booked");
                        return;
                    }
                    break;
                case 3:
                    if (hotel_ob.luxury_singleroom[rn] == null) {
                        System.out.println("\nRoom not booked");
                        return;
                    }
                    break;
                case 4:
                    if (hotel_ob.deluxe_singleroom[rn] == null) {
                        System.out.println("\nRoom not booked");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid room type");
                    return;
            }

            do {
                System.out.println("\n************************************************************");
                System.out.println("*                            Menu                          *");
                System.out.println("************************************************************");
                System.out.println("*  1. Sandwich                                     Rs.50   *");
                System.out.println("*  2. Pasta                                        Rs.60   *");
                System.out.println("*  3. Noodles                                      Rs.70   *");
                System.out.println("*  4. Coke                                         Rs.30   *");
                System.out.println("************************************************************");
                System.out.print("Enter your choice: ");
                i = sc.nextInt();
                sc.nextLine();
                if (i <= 0 || i > 4) {
                    throw new Exception();
                }
                System.out.print("\nQuantity- ");
                q = sc.nextInt();
                sc.nextLine();
                boolean itemFound;
                switch (rtype) {
                    case 1:
                        itemFound = updateFoodItem(hotel_ob.luxury_doubleroom[rn].food, i, q);
                        if (!itemFound) {
                            hotel_ob.luxury_doubleroom[rn].food.add(new Food(i, q));
                        }
                        System.out.println("\nFood Ordered Successfully");
                        break;
                    case 2:
                        itemFound = updateFoodItem(hotel_ob.deluxe_doubleroom[rn].food, i, q);
                        if (!itemFound) {
                            hotel_ob.deluxe_doubleroom[rn].food.add(new Food(i, q));
                        }
                        System.out.println("\nFood Ordered Successfully");
                        break;
                    case 3:
                        itemFound = updateFoodItem(hotel_ob.luxury_singleroom[rn].food, i, q);
                        if (!itemFound) {
                            hotel_ob.luxury_singleroom[rn].food.add(new Food(i, q));
                        }
                        System.out.println("\nFood Ordered Successfully");
                        break;
                    case 4:
                        itemFound = updateFoodItem(hotel_ob.deluxe_singleroom[rn].food, i, q);
                        if (!itemFound) {
                            hotel_ob.deluxe_singleroom[rn].food.add(new Food(i, q));
                        }
                        System.out.println("\nFood Ordered Successfully");
                        break;
                }
                System.out.print("\nDo you want to order anything else (y/n)?");
                wish = sc.nextLine();
                if (wish.equalsIgnoreCase("n")) {
                    wish = "n";
                }
                while (!(wish.equalsIgnoreCase("y") || wish.equalsIgnoreCase("n"))) {
                    System.out.println("Invalid Option");
                    System.out.print("\nDo you want to order anything else (y/n)?");
                    wish = sc.nextLine();
                    if (wish.equalsIgnoreCase("n")) {
                        wish = "n";
                    }
                }
            } while (wish.equalsIgnoreCase("y"));
        } catch (NullPointerException e) {
            System.out.println("\nRoom not booked");
        } catch (Exception e) {
            System.out.println("Cannot be done");
        }
    }

    static void viewBookings() {
        int luxuryDoubleBookings = 0, luxurySingleBooking = 0, deluxeDoubleBookings = 0, deluxeSingleBookings = 0;
        System.out.println("************************************************************");
        System.out.println("*                       Bookings                           *");
        System.out.println("************************************************************");
        System.out.println("*  Luxury Double Rooms:                                    *");
        for (int i = 0; i < hotel_ob.luxury_doubleroom.length; i++) {
            if (hotel_ob.luxury_doubleroom[i] != null) {
                Doubleroom room = hotel_ob.luxury_doubleroom[i];
                System.out.println("\n=>Room " + (i + 1));
                System.out.println(
                        "Customer 1: " + room.name + ", Contact: " + room.contact + ", Gender: " + room.gender);
                System.out.println(
                        "Customer 2: " + room.name2 + ", Contact: " + room.contact2 + ", Gender: " + room.gender2);
                System.out.println("-----------------------------------------------------------");
                luxuryDoubleBookings++;
            }
        }
        if (luxuryDoubleBookings == 0) {
            System.out.println("     No bookings");
        }

        System.out.println("************************************************************");
        System.out.println("*  Deluxe Double Rooms:                                    *");
        for (int i = 0; i < hotel_ob.deluxe_doubleroom.length; i++) {
            if (hotel_ob.deluxe_doubleroom[i] != null) {
                Doubleroom room = hotel_ob.deluxe_doubleroom[i];
                System.out.println("\n=>Room " + (i + 11));
                System.out.println(
                        "Customer 1: " + room.name + ", Contact: " + room.contact + ", Gender: " + room.gender);
                System.out.println(
                        "Customer 2: " + room.name2 + ", Contact: " + room.contact2 + ", Gender: " + room.gender2);
                System.out.println("-----------------------------------------------------------");
                deluxeDoubleBookings++;
            }
        }
        if (deluxeDoubleBookings == 0) {
            System.out.println("     No bookings");
        }

        System.out.println("************************************************************");
        System.out.println("*  Luxury Single Rooms:                                    *");
        for (int i = 0; i < hotel_ob.luxury_singleroom.length; i++) {
            if (hotel_ob.luxury_singleroom[i] != null) {
                Singleroom room = hotel_ob.luxury_singleroom[i];
                System.out.println("\n=>Room " + (i + 31));
                System.out
                        .println("Customer: " + room.name + ", Contact: " + room.contact + ", Gender: " + room.gender);
                System.out.println("-----------------------------------------------------------");
                luxurySingleBooking++;
            }
        }
        if (luxurySingleBooking == 0) {
            System.out.println("     No bookings");
        }

        System.out.println("************************************************************");
        System.out.println("*  Deluxe Single Rooms:                                    *");
        for (int i = 0; i < hotel_ob.deluxe_singleroom.length; i++) {
            if (hotel_ob.deluxe_singleroom[i] != null) {
                Singleroom room = hotel_ob.deluxe_singleroom[i];
                System.out.println("\n=>Room " + (i + 41));
                System.out
                        .println("Customer: " + room.name + ", Contact: " + room.contact + ", Gender: " + room.gender);
                System.out.println("-----------------------------------------------------------");
                deluxeSingleBookings++;
            }
        }
        if (deluxeSingleBookings == 0) {
            System.out.println("     No bookings");
        }
        System.out.println("************************************************************");
    }
}

class write implements Runnable {
    holder hotel_ob;

    write(holder hotel_ob) {
        this.hotel_ob = hotel_ob;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fout = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error in writing " + e);
        }

    }

}

public class hotelManagement {
    public static void main(String[] args) {

        try {
            File f = new File("backup");
            if (f.exists()) {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (holder) ois.readObject();
                ois.close();
            }
            Scanner sc = new Scanner(System.in);
            int ch, ch2;
            String wish;
            boolean runCondition = true;
            System.out.println("************************************************************");
            System.out.println("*               WELCOME TO HOTEL MANAGEMENT SYSTEM         *");
            System.out.print("************************************************************");

            do {
                System.out.println("\n************************************************************");
                System.out.println("*               MAIN MENU - OPTIONS                        *");
                System.out.println("************************************************************");
                System.out.println("*                                                          *");
                System.out.println("*  1. Display room details                                 *");
                System.out.println("*  2. Display room availability                            *");
                System.out.println("*  3. Book Room                                            *");
                System.out.println("*  4. Order food                                           *");
                System.out.println("*  5. Checkout                                             *");
                System.out.println("*  6. View all room bookings                               *");
                System.out.println("*  7. Exit                                                 *");
                System.out.println("*                                                          *");
                System.out.println("************************************************************");
                System.out.print("Enter your choice: ");

                try {
                    ch = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    ch = -1;
                }
                switch (ch) {
                    case 1:
                        System.out.println("\n************************************************************");
                        System.out.println("*                Choose Room Type                          *");
                        System.out.println("************************************************************");
                        System.out.println("*  1. Luxury Double Room                                   *");
                        System.out.println("*  2. Deluxe Double Room                                   *");
                        System.out.println("*  3. Luxury Single Room                                   *");
                        System.out.println("*  4. Deluxe Single Room                                   *");
                        System.out.println("************************************************************");
                        System.out.print("Enter your choice: ");
                        try {
                            ch2 = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            ch2 = -1;
                        }
                        Hotel.features(ch2);
                        break;
                    case 2:
                        System.out.println("\n************************************************************");
                        System.out.println("*                Choose Room Type                          *");
                        System.out.println("************************************************************");
                        System.out.println("*  1. Luxury Double Room                                   *");
                        System.out.println("*  2. Deluxe Double Room                                   *");
                        System.out.println("*  3. Luxury Single Room                                   *");
                        System.out.println("*  4. Deluxe Single Room                                   *");
                        System.out.println("************************************************************");
                        System.out.print("Enter your choice: ");
                        try {
                            ch2 = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            ch2 = -1;
                        }
                        Hotel.availability(ch2);
                        break;
                    case 3:
                        System.out.println("\n************************************************************");
                        System.out.println("*                Choose Room Type                          *");
                        System.out.println("************************************************************");
                        System.out.println("*  1. Luxury Double Room                                   *");
                        System.out.println("*  2. Deluxe Double Room                                   *");
                        System.out.println("*  3. Luxury Single Room                                   *");
                        System.out.println("*  4. Deluxe Single Room                                   *");
                        System.out.println("************************************************************");
                        System.out.print("Enter your choice: ");
                        try {
                            ch2 = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            ch2 = -1;
                        }
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("\nRoom Number -");
                        try {
                            ch2 = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("\nPlease Enter Valid Choice!!");
                            break;
                        }
                        if (ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.order(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.order(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.order(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.order(ch2 - 1, 1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("\nRoom Number -");
                        try {
                            ch2 = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("\nPlease Enter Valid Choice!!");
                            break;
                        }
                        if (ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.deallocate(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.deallocate(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.deallocate(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.deallocate(ch2 - 1, 1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:
                        Hotel.viewBookings();
                        break;
                    case 7:
                        runCondition = false;
                        break;
                    default:
                        System.out.println("\nPlease Enter Valid Choice!!");
                        break;

                }
                if (runCondition == false) {
                    break;
                }
                System.out.print("\nContinue (y/n): ");
                wish = sc.nextLine();
                if (wish.equals("n")) {
                    runCondition = false;
                }
                while (!(wish.equalsIgnoreCase("y") || wish.equalsIgnoreCase("n"))) {
                    System.out.println("Invalid Option");
                    System.out.print("\nContinue (y/n): ");
                    wish = sc.nextLine();
                    if (wish.equalsIgnoreCase("n")) {
                        runCondition = false;
                    }
                }

            } while (runCondition);

            Thread t = new Thread(new write(Hotel.hotel_ob));
            t.start();
            sc.close();
        } catch (Exception e) {
            System.out.println("Not a valid input");
        }
    }
}