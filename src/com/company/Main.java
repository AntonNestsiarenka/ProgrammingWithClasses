package com.company;

import Utils.GenerationUtils;
import Utils.InputOutputUtils;
import Utils.MyException;
import Utils.OtherUtils;
import com.company.accountmodel.*;
import com.company.airlinemodel.Airline;
import com.company.airlinemodel.AirlineCollection;
import com.company.airlinemodel.DayOfWeek;
import com.company.bookmodel.Book;
import com.company.bookmodel.BookCollection;
import com.company.carmodel.*;
import com.company.carmodel.Person;
import com.company.countermodel.Counter;
import com.company.customermodel.Customer;
import com.company.customermodel.CustomerCollection;
import com.company.statemodel.*;
import com.company.textmodel.Sentence;
import com.company.textmodel.Text;
import com.company.textmodel.TypeOfSentence;
import com.company.textmodel.Word;
import com.company.trainmodel.Time;
import com.company.trainmodel.Train;
import com.company.travelmodel.*;
import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**********************************************************************************************************/
    /************************************** Простейшие классы и объекты ***************************************/
    /**********************************************************************************************************/

    public static void task1()
    {
        /* Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
           переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
           наибольшее значение из этих двух переменных. */
        Test1 obj = new Test1();
        obj.setX(5);
        obj.setY(-2);
        System.out.print(obj.sum() + "\n");
        System.out.print(obj.max() + "\n");
        obj.printInfo();
    }

    public static void task2()
    {
        /* Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
           конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
           класса. */
        Test2 obj1 = new Test2();
        Test2 obj2 = new Test2(15, 90);
    }

    public static void task3()
    {
        /*  Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
            из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
            номеров групп студентов, имеющих оценки, равные только 9 или 10. */
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++)
        {
            students[i] = new Student();
            students[i].setName(InputOutputUtils.inputLine("Введите имя студента: "));
            students[i].setGroupName(InputOutputUtils.inputLine("Введите имя группы студента: "));
            students[i].setProgress(GenerationUtils.createAndFill1DArrayRandom(5, 9, 10));
        }
        Student.printStudentsInfoWithHighMarks(students);
    }

    public static void task4()
    {
        /* Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
           Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
           номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
           Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
           назначения должны быть упорядочены по времени отправления. */
            Train[] trains = new Train[5];
        for (int i = 0; i < trains.length; i++)
        {
            trains[i] = new Train(InputOutputUtils.inputLine("Введите пункт назначения для поезда: "),
                    GenerationUtils.randInt(1, 1000),
                    new Time(GenerationUtils.randInt(0, 23), GenerationUtils.randInt(0, 59)));
        }
        System.out.println("Сгенерированные поезда.\n");
        Train.printInfo(trains);
        System.out.println();
        System.out.println("Поиск информации о поезде по номеру.\n");
        Train.printInfoByNumberOfTrain(trains, InputOutputUtils.inputUInt("Введите номер поезда: "));
        System.out.println();
        System.out.println("Сортировка поездов по возрастанию номера поезда.\n");
        Train.sortByNumberOfTrainAscending(trains);
        Train.printInfo(trains);
        System.out.println();
        System.out.println("Сортировка поездов по пункту назначения. При совпадении пунктов назначения сортировка по времени отправления.\n");
        Train.sortByDestinationName(trains);
        Train.printInfo(trains);
        System.out.println();
    }

    public static void task5()
    {
        /*  Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
            на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
            произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
            позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса. */
        Counter i = new Counter(0,9);
        while (true) {
            System.out.print(i.getCounter() + " ");
            try {
                i.increase();
            } catch (MyException e) {
                break;
            }
        }
    }

    public static void task6()
    {
        /* Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
           изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
           недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
           заданное количество часов, минут и секунд. */
        Date date = new Date();
        Time currentTime = new Time(date.getHours(), date.getMinutes(), date.getSeconds());
        int i = 0;
        while (i < 1000)
        {
            currentTime.printTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime.addSeconds(1);
            i++;
        }
    }

    public static void task7()
    {
        /* Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
           площади, периметра и точки пересечения медиан. */
        Triangl triangl = null;
        try {
            triangl = new Triangl(new Pair<Double, Double>(1.0, 2.0), new Pair<Double, Double>(2.0, 3.0), new Pair<Double, Double>(3.0, 2.0));
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.printf("Площадь треугольника: %f\n", triangl.areaOfATriangle());
        System.out.printf("Периметр треугольника: %f\n", triangl.trianglePerimeter());
        Pair<Double, Double> point = triangl.meridianIntersectionPoint();
        System.out.printf("Точка пересечения координат треугольника: x = %f, y = %f \n", point.getKey(), point.getValue());
    }

    public static void task8()
    {
        /*  Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
            и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
            и методами. Задать критерии выбора данных и вывести эти данные на консоль.

            Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
            Найти и вывести:
            a) список покупателей в алфавитном порядке;
            b) список покупателей, у которых номер кредитной карточки находится в заданном интервале. */
        CustomerCollection collection = new CustomerCollection();
        collection.addCustomerToCollection(new Customer());
        collection.addCustomerToCollection(new Customer("Gargun", "Alexey", "Viktorovich", "Gomel, Sovetskaya street 45", 4555688932220010L, "GFDYD154002556-551-001USD"));
        collection.addCustomerToCollection(new Customer("Ivanov", "Ivan", "Ivanovich", "Brest, Lenina street 150", 4505668930280012L, "TYHD264602357-889-002EUR"));
        collection.addCustomerToCollection(new Customer("Verdin", "Igor", "Alekseevich", "Borisov, Gromova street 55", 3305677931285013L, "UHD263502381-819-101BYN"));
        collection.addCustomerToCollection(new Customer("Lebedev", "Nikolay", "Olegovich", "Soligorsk, Shepinskaya street 12", 3121675565225019L, "SKU2635081001-509-008BYN"));
        System.out.println("Информация о всех покупателях из коллекции покупателей.");
        collection.printInfoAboutAllCustomers();
        ArrayList<Customer> col = collection.sortBySurname();
        System.out.println("Информация о всех покупателях отсортированная по фамилии.");
        CustomerCollection.printInfo(col);
        ArrayList<Customer> customers = collection.getCustomersWithCreditCardNumberInRange(2135002541003661L, 4120560236001447L);
        System.out.println("Информация о всех покупателях номера кредитных карт которых находятся в заданном диапазоне.");
        CustomerCollection.printInfo(customers);
    }

    public static void task9()
    {
        /* Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
           метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
           методами. Задать критерии выбора данных и вывести эти данные на консоль.

           Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
           Найти и вывести:
           a) список книг заданного автора;
           b) список книг, выпущенных заданным издательством;
           c) список книг, выпущенных после заданного года. */
        BookCollection collection = new BookCollection(new Book());
        collection.addBookToBookCollection(new Book("Программирование C++", new String[] {"Васильев А.Н"}, "Питер", 2017, 460, 20.5, "Мягкий"));
        collection.addBookToBookCollection(new Book("Программирование Python", new String[] {"Пол Бэри"}, "Москва", 2018, 723, 30.0, "Твердый"));
        collection.addBookToBookCollection(new Book("Изучаем Java", new String[] {"Кэти Сьера", "Берт Бейтс"}, "Эксмо", 2014, 621, 25.3, "Твердый"));
        collection.addBookToBookCollection(new Book("Приемы объектно ориентированного проектирования", new String[] {"Э. Гамма", "Р. Хелм", "Р. Джонсон", "Д. Влиссидес"}, "Питер", 2020, 390, 16.25, "Мягкий"));
        System.out.println("Информация о всех книгах из коллекции книг.\n");
        collection.printInfo();
        ArrayList<Book> booksByAuthor =collection.getBooksWithAGivenAuthor("Р. Хелм");
        System.out.println("Информация о всех книгах по заданному автору.\n");
        BookCollection.printInfo(booksByAuthor);
        ArrayList<Book> booksByPublishingHouse = collection.getBooksWithAGivenPublishingHouse("Питер");
        System.out.println("Информация о всех книгах по заданному издательству.\n");
        BookCollection.printInfo(booksByPublishingHouse);
        ArrayList<Book> booksAfterYear = collection.getBooksAfterGivenYear(2015);
        System.out.println("Информация о всех книгах выпущенных после заданного года.\n");
        BookCollection.printInfo(booksAfterYear);
    }

    public static void task10()
    {
        /* Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
           и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
           методами. Задать критерии выбора данных и вывести эти данные на консоль.

           Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
           Найти и вывести:
           a) список рейсов для заданного пункта назначения;
           b) список рейсов для заданного дня недели;
           c) список рейсов для заданного дня недели, время вылета для которых больше заданного. */
        AirlineCollection airlineCollection = new AirlineCollection(new Airline());
        airlineCollection.addAirLineToAirLineCollection(new Airline("Gomel", "Airbus A310", new Time(14, 10), new DayOfWeek[] {DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.SATURDAY}));
        airlineCollection.addAirLineToAirLineCollection(new Airline("Riga", "Boeing-747", new Time(5, 48), new DayOfWeek[] {DayOfWeek.MONDAY, DayOfWeek.FRIDAY}));
        airlineCollection.addAirLineToAirLineCollection(new Airline("Minsk", "Ty-154", new Time(20, 00), new DayOfWeek[] {DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.SUNDAY}));
        airlineCollection.addAirLineToAirLineCollection(new Airline("Kiev", "Airbus A330", new Time(17, 10), new DayOfWeek[] {DayOfWeek.TUESDAY, DayOfWeek.FRIDAY}));
        System.out.println("Информация о всех авиалиниях из коллекции авиалиний.\n");
        airlineCollection.printInfo();
        System.out.println("Информация о всех авиалиниях по заданному пункту назначения.\n");
        ArrayList<Airline> airlinesByDestinationName = airlineCollection.getAirLinesWithAGivenDestinationName("Minsk");
        AirlineCollection.printInfo(airlinesByDestinationName);
        System.out.println("Информация о всех авиалиниях по заданному дню отправления.\n");
        ArrayList<Airline> airlinesByDepartureDay = airlineCollection.getAirLinesWithAGivenDayOfWeek(DayOfWeek.MONDAY);
        AirlineCollection.printInfo(airlinesByDepartureDay);
        System.out.println("Информация о всех авиалиниях по заданному дню отправления, время отправления для которых больше заданного.\n");
        ArrayList<Airline> airlinesByDepartureDayAndAfterGivenTime = airlineCollection.getAirLinesWithAGivenDayOfWeekAndAfterGivenTime(DayOfWeek.WEDNESDAY, new Time(12, 0));
        AirlineCollection.printInfo(airlinesByDepartureDayAndAfterGivenTime);
    }

    /**********************************************************************************************************/
    /***************************************** Агрегация и композиция *****************************************/
    /**********************************************************************************************************/

    public static void task11()
    {
        /*  Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
            консоль текст, заголовок текста. */
        Text text = new Text();
        text.setHeading("Chicago");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("wordsForText.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine())
        {
            ArrayList<Word> words = new ArrayList<Word>();
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile("((\\w+[^ ]\\w+)|(\\w+))");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find())
            {
                words.add(new Word(matcher.group()));
            }
            Sentence sentence = new Sentence(TypeOfSentence.NARRATIVE, words);
            text.addSentenceToText(sentence);
        }
        text.printText();
    }

    public static void task12()
    {
        /*  Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
            менять колесо, вывести на консоль марку автомобиля. */
        Car car1 = new Car();
        Wheel[] wheels = new Wheel[] {new Wheel(), new Wheel(), new Wheel(), new Wheel()};
        Car car2 = new Car("Audi", "A6", "WAUZZZ4B05631240", 1390, 1980, 75, 30, 4, new Engine("VAG", "BAU", 2003, 514200361L, TypeOfEngine.DIESEL, 2496, 132, 370, 8.3, true), wheels, new Wheel());
        Person person1 = new Person();
        Person person2 = new Person("Valentin", "HB4126822", 88.2);
        Person person3 = new Person("Olga", "HB4522311", 60.4);
        EventHandlerForTheCar updater = new EventHandlerForTheCar(car2);
        updater.printInfo();
        OtherUtils.sleep(1000);
        person1.tryToSeatToCarAsADriver(car2);
        updater.printInfo();
        OtherUtils.sleep(1000);
        person2.tryToSeatToCarAsAPassenger(car2);
        updater.printInfo();
        OtherUtils.sleep(1000);
        person3.tryToSeatToCarAsAPassenger(car2);
        updater.printInfo();
        OtherUtils.sleep(1000);
        person1.startTheCarEngine(car2);
        OtherUtils.sleep(1000);
        updater.update();
        updater.printInfo();
        OtherUtils.sleep(1000);
        try {
            person1.ToGoOnCar(car2, 10);
        } catch (MyException e) {
            e.printStackTrace();
        }
        OtherUtils.sleep(1000);
        System.out.println("Машина поехала.\n");
        OtherUtils.sleep(1000);
        updater.update();
        updater.printInfo();
        int i = 0;
        while (i < 10000)
        {
            try {
                person1.ToGoOnCar(car2, GenerationUtils.uniform(0, 100));
            } catch (MyException e) {
                break;
            }
            OtherUtils.sleep(1000);
            updater.update();
            if (car2.getCurrentFuelTankLevel() < 10)
                car2.refill(GenerationUtils.randInt(5, 20));
            updater.printInfo();
            i++;
        }
    }

    public static void task13()
    {
        /* Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
           столицу, количество областей, площадь, областные центры. */
        VillageCity villageCity1 = new VillageCity("Довск", 2040, 1856, 3.5);
        VillageCity villageCity2 = new VillageCity("Ректа", 850, 1815, 2.3);
        VillageCity villageCity3 = new VillageCity("Дукора", 685, 1756, 1.85);
        VillageCity villageCity4 = new VillageCity("Дворец", 1420, 1740, 5.65);
        VillageCity villageCity5 = new VillageCity("Особино", 1254, 1875, 3.85);
        VillageCity villageCity6 = new VillageCity("Антоновка", 352, 1900, 2.0);
        VillageCity villageCity7 = new VillageCity("Броды", 140, 1889, 4.5);
        VillageCity villageCity8 = new VillageCity("Никитино", 1580, 1902, 5.89);
        VillageCity villageCity9 = new VillageCity("Ботвиновка", 554, 1815, 3.6);
        VillageCity villageCity10 = new VillageCity("Большевик", 2600, 1795, 7.45);
        VillageCity villageCity11 = new VillageCity("Колонск", 925, 1896, 4.6);
        VillageCity villageCity12 = new VillageCity("Пески", 1104, 1826, 5.45);

        District district1 = new District();
        district1.setDistrictCenter(new DistrictCity("Чечерск", 10523, 1652, 26.65));
        district1.addVillageCitys(villageCity1, villageCity2);
        District district2 = new District();
        district2.setDistrictCenter(new DistrictCity("Рогачев", 56402, 1689, 38.75));
        district2.addVillageCitys(villageCity3, villageCity4);
        District district3 = new District();
        district3.setDistrictCenter(new DistrictCity("Слуцк", 64215, 1610, 32.4));
        district3.addVillageCitys(villageCity5, villageCity6);
        District district4 = new District();
        district4.setDistrictCenter(new DistrictCity("Жлобин", 78562, 1720, 35.2));
        district4.addVillageCitys(villageCity7, villageCity8);
        District district5 = new District();
        district5.setDistrictCenter(new DistrictCity("Барановичи", 98240, 1605, 45.2));
        district5.addVillageCitys(villageCity9, villageCity10);
        District district6 = new District();
        district6.setDistrictCenter(new DistrictCity("Осиповичи", 51230, 1536, 32.45));
        district6.addVillageCitys(villageCity11, villageCity12);

        Region region1 = new Region();
        region1.setRegionalCenter(new RegionalCity("Гомель", 506365, 1263, 129.45));
        region1.addDistricts(district1, district2);
        Region region2 = new Region();
        region2.setRegionalCenter(new RegionalCity("Витебск", 345623, 1210, 105.6));
        region2.addDistricts(district3, district4);
        Region region3 = new Region();
        region3.setRegionalCenter(new RegionalCity("Могилев", 352140, 1325, 100.6));
        region3.addDistricts(district5, district6);

        State state = new State();
        state.setCapital(new Capital("Минск", 2000000, 1145, 586.4));
        state.addRegions(region1, region2, region3);
        System.out.printf("Столица государства: %s\n", state.getCapital());
        System.out.printf("Количество областей: %d\n", state.getNumberOfRegions());
        System.out.printf("Сумарная площадь всех населенных пунктов государства: %d км2\n", state.getPopulation());
        System.out.println("Областные центры государства:");
        state.printAllRegions();
    }

    public static void task14()
    {
        /*  Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
            счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
            всем счетам, имеющим положительный и отрицательный балансы отдельно. */
        Passport passport1 = new Passport("Иванов", "Иван", "Иванович", new GregorianCalendar(1986, 10, 3), "20156275H001PB3", "HB2563014", "Республика Беларусь, Минская область, г. Минск", "Минским РОВД", new GregorianCalendar(2016, 5, 18), new GregorianCalendar(2025, 7, 26), Sex.MAN, "BLR", "Belarus");
        passport1.addPlaceOfResidence("г. Минск, ул. Скрипникова 56, 89");
        Passport passport2 = new Passport("Дворник", "Игорь", "Дмитриевич", new GregorianCalendar(1991, 2, 15), "22636288H601PR1", "HB1203381", "Республика Беларусь, Гомельская область, г. Жлобин", "Жлобинским РОВД Гомельской области", new GregorianCalendar(2010, 11, 22), new GregorianCalendar(2022, 4, 11), Sex.MAN, "BLR", "Belarus");
        passport2.addPlaceOfResidence("г. Жлобин, ул. Шоссейная 10, 5");
        Passport passport3 = new Passport("Денисенко", "Леонид", "Михайлович", new GregorianCalendar(1980, 1, 6), "46355579H101PB2", "HB1113410", "Республика Беларусь, Минская область, г. Осиповичи", "Осиповичским РОВД Минской области", new GregorianCalendar(2015, 9, 9), new GregorianCalendar(2030, 10, 5), Sex.MAN, "BLR", "Belarus");
        passport3.addPlaceOfResidence("г. Осиповичи, ул. Набережная 12");
        Passport passport4 = new Passport("Якубовский", "Генадий", "Алексеевич", new GregorianCalendar(1988, 5, 20), "22306095H551PB4", "HB1218302", "Республика Беларусь, Витебская область, г. Орша", "Оршанским РОВД Витебской области", new GregorianCalendar(2017, 4, 25), new GregorianCalendar(2028, 6, 7), Sex.MAN, "BLR", "Belarus");
        passport4.addPlaceOfResidence("г. Орша, ул. Янки Купалы 105, 26");
        Passport passport5 = new Passport("Ивлеева", "Яна", "Викторовна", new GregorianCalendar(1995, 8, 1), "80693202H051PB3", "HB2004711", "Республика Беларусь, Гомельская область, г. Рогачев", "Рогачевским РОВД Гомельской области", new GregorianCalendar(2018, 3, 17), new GregorianCalendar(2027, 10, 20), Sex.WOMEN, "BLR", "Belarus");
        passport5.addPlaceOfResidence("г. Рогачев, ул. Темная 98, 14");
        ClientOfBank clientOfBank1 = new ClientOfBank("Иванов", "Иван", "Иванович", 32, Sex.MAN, passport1);
        ClientOfBank clientOfBank2 = new ClientOfBank("Дворник", "Игорь", "Дмитриевич", 28, Sex.MAN, passport2);
        ClientOfBank clientOfBank3 = new ClientOfBank("Денисенко", "Леонид", "Михайлович", 40, Sex.MAN, passport3);
        ClientOfBank clientOfBank4 = new ClientOfBank("Якубовский", "Генадий", "Алексеевич", 33, Sex.MAN, passport4);
        ClientOfBank clientOfBank5 = new ClientOfBank("Ивлеева", "Яна", "Викторовна", 24, Sex.MAN, passport5);
        Bank bank = new Bank("Белагропромбанк");
        bank.createAccount("USD", clientOfBank1, -1500);
        bank.createAccount("EUR", clientOfBank1, 950);
        bank.createAccount("BYN", clientOfBank2, 10000);
        bank.createAccount("USD", clientOfBank2);
        bank.createAccount("BYN", clientOfBank3, 5600);
        bank.createAccount("RUB", clientOfBank4, 300000);
        bank.createAccount("EUR", clientOfBank4, 2450);
        bank.createAccount("BYN", clientOfBank5, 8600);
        bank.createAccount("USD", clientOfBank5, 500);
        System.out.println("Общая сумма по всем счетам клиента.");
        bank.printCommonSumAllAccountsOfClient(clientOfBank1);
        System.out.println();
        System.out.println("Общая сумма по всем счетам клиента c положительным балансом.");
        bank.printCommonSumAllAccountsOfClientWithPositiveBalance(clientOfBank1);
        System.out.println();
        System.out.println("Общая сумма по всем счетам клиента c отрицательным балансом.");
        bank.printCommonSumAllAccountsOfClientWithNegativeBalance(clientOfBank1);
        System.out.println();
        System.out.println("Поисков счетов клиента.");
        ArrayList<Account> currentAccounts = bank.getAllAccountsOfClient(clientOfBank5);
        Bank.printInfoAccounts(currentAccounts);
        System.out.println();
        System.out.println("Сортировка счетов клиента.");
        currentAccounts = bank.sortAccountsOfClientByBalanceAscending(clientOfBank5);
        Bank.printInfoAccounts(currentAccounts);
        System.out.println();
        System.out.println("Сортировка всех счетов банка.");
        bank.sortAllAccountsByBalanceAscending();
        bank.printInfoAllAccounts();
    }

    public static void task15()
    {
        /* Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
           различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
           возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. */
        TravelVoucher travelVoucher1 = new TravelVoucher("Албанская сказка", "Описание тура", "Албания", "Дуррес", 14, TypeOfTravelVoucher.RECREATION, TypeOfTransport.AVIA, TypeOfFood.ALLINCLUSIVE, 655);
        TravelVoucher travelVoucher2 = new TravelVoucher("Грузинская ночь", "Описание тура", "Грузия", "Батуми", 10, TypeOfTravelVoucher.TREATMENT, TypeOfTransport.BUS, TypeOfFood.THREETIMESADAY, 445);
        TravelVoucher travelVoucher3 = new TravelVoucher("Отдых на море", "Описание тура", "Турция", "Аланья", 14, TypeOfTravelVoucher.RECREATION, TypeOfTransport.AVIA, TypeOfFood.DINNERANDSUPPER, 504);
        TravelVoucher travelVoucher4 = new TravelVoucher("Тур по Европе", "Описание тура", "Германия", "Штутгарт", 7, TypeOfTravelVoucher.EXCURSIONS, TypeOfTransport.TRAIN, TypeOfFood.NONE, 285);
        TravelVoucher travelVoucher5 = new TravelVoucher("Морской бриз", "Описание тура", "Вьетнам", "Куангнгай", 14, TypeOfTravelVoucher.RECREATION, TypeOfTransport.AVIA, TypeOfFood.BREAKFASTANDSUPPER, 852);
        TravelVoucher travelVoucher6 = new TravelVoucher("Морской круиз", "Описание тура", "Испания", "Барселона", 10, TypeOfTravelVoucher.CRUISE, TypeOfTransport.SHIP, TypeOfFood.ALLINCLUSIVE, 1140);
        TravelVoucher travelVoucher7 = new TravelVoucher("Тур в Австралию", "Описание тура", "Австралия", "Сидней", 14, TypeOfTravelVoucher.RECREATION, TypeOfTransport.AVIA, TypeOfFood.ALLINCLUSIVE, 1650);
        TravelVoucher travelVoucher8 = new TravelVoucher("Тур по Англии", "Описание тура", "Англия", "Лондон", 7, TypeOfTravelVoucher.EXCURSIONS, TypeOfTransport.AVIA, TypeOfFood.THREETIMESADAY, 570);
        TravelVoucher travelVoucher9 = new TravelVoucher("Шоппинг в турции", "Описание тура", "Турция", "Анкара", 5, TypeOfTravelVoucher.SHOPPING, TypeOfTransport.AVIA, TypeOfFood.SUPPER, 410);
        TravelVoucher travelVoucher10 = new TravelVoucher("Летний отдых на море", "Описание тура", "Египет", "Хургада", 14, TypeOfTravelVoucher.RECREATION, TypeOfTransport.AVIA, TypeOfFood.ALLINCLUSIVEPLUS, 1420);

        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setName("ViewTour");
        travelAgency.addTravelVouchers(travelVoucher1, travelVoucher2, travelVoucher3, travelVoucher4, travelVoucher5, travelVoucher6, travelVoucher7, travelVoucher8, travelVoucher9, travelVoucher10);

        ClientOfTravelAgency clientOfTravelAgency = new ClientOfTravelAgency("Курпатов", "Михаил", "Дмитриевич", 42, Sex.MAN);
        clientOfTravelAgency.setTypeOfTransportToForm(TypeOfTransport.AVIA);
        clientOfTravelAgency.setPriceToForm(1000.0);
        clientOfTravelAgency.getOffersFromTravelAgency(travelAgency);
        System.out.println("Предложения по запросу пользователя.");
        clientOfTravelAgency.printOffers();
        System.out.println("Сортировка по цене предложений пользователя.");
        clientOfTravelAgency.sortOffersByPrice();
        clientOfTravelAgency.printOffers();
        System.out.println("Сортировка по количеству дней предложений пользователя.");
        clientOfTravelAgency.sortOffersByNumberOfDays();
        clientOfTravelAgency.printOffers();
    }

    public static void main(String[] args)
    {
        task15();
    }
}