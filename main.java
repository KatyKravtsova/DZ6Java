import java.util.*;

public class main {

    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("HP", 8, 512,
                "Windows 10", "серый"));
        laptops.add(new Laptop("Apple", 16, 512,
                "MacOS", "белый"));
        laptops.add(new Laptop("Asus", 32, 1024,
                "Windows 10", "черный"));
        laptops.add(new Laptop("Lenovo", 8, 256,
                "Windows 11", "красный"));
       
        
        Laptop needLaptop = requestLaptop();
        System.out.println("Необходимый ноутбук\n" + needLaptop);
        Set<Laptop> filteredLaptops = filteredLaptops(laptops, needLaptop);
        showAll(filteredLaptops);

    }

    static void showAll(Set<Laptop> laptops) {
        System.out.println("Все ноутбуки");
        for (Laptop elem : laptops) {
            System.out.println(elem);
        }
    }

    static Integer getIntegerValue(String offer, Scanner input) {
        while (true) {
            System.out.print(offer);
            String inputString = input.nextLine();
            if (inputString.equals("")) {
                return null;
            }
            try {
                int value = Integer.parseInt(inputString);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Введите положительное число!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число или нажмите ввод!");
            }
        }
    }

    static Laptop requestLaptop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Подбор ноутбука");
        System.out.print("Введите название модели или нажмите ввод: ");
        String name = input.nextLine();
        System.out.print("Введите цвет или нажмите ввод: ");
        String color = input.nextLine();
        System.out.print("Введите операционную систему или нажмите ввод: ");
        String OS = input.nextLine();
        Integer ssd = getIntegerValue("Введите объем жесткого диска SSD или нажмите ввод: ", input);
        Integer ram = getIntegerValue("Введите размер оперативной памяти RAM или нажмите ввод: ", input);
        input.close();
        return new Laptop(name, ram, ssd, OS, color);
    }

    static Set<Laptop> filteredLaptops(Set<Laptop> laptops, Laptop needLaptop) {
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop elem : laptops) {
            if (elem.compareTo(needLaptop)) {
                filteredLaptops.add(elem);
            }
        }
        return filteredLaptops;
    }

}