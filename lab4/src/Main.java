public class Main {
    public static void main(String[] args) {
        // Создаем города
        City moscow = new City("Москва", 2561.5);
        City ulanUde = new City("Улан-Удэ", 377.0);
        City kyahta = new City("Кяхта", 28.0);
        City irkutsk = new City("Иркутск", 305.0);
        City angarsk = new City("Ангарск", 277.0);
        City chita = new City("Чита", 534.0);


        // Создаем районы
        District kyahtaDistrict = new District("Кяхтинский район");
        kyahtaDistrict.addCity(kyahta);


        District ulanUdeDistrict = new District("город Улан-Удэ");
        ulanUdeDistrict.addCity(ulanUde);


        District irkutskDistrict = new District("Иркутский район");
        irkutskDistrict.addCity(irkutsk);


        District angarskDistrict = new District("Ангарский район");
        irkutskDistrict.addCity(angarsk);


        District chitaDistrict = new District("Читинский район");
        chitaDistrict.addCity(chita);


        // Создаем субъекты РФ
        Region buryatia = new Region("Республика Бурятия", ulanUde);
        buryatia.addDistrict(ulanUdeDistrict);
        buryatia.addDistrict(kyahtaDistrict);


        Region irkutskRegion = new Region("Иркутская область", irkutsk);
        irkutskRegion.addDistrict(irkutskDistrict);
        irkutskRegion.addDistrict(angarskDistrict);


        Region zabaykalskyKrai = new Region("Забайкальский край", chita);
        zabaykalskyKrai.addDistrict(chitaDistrict);


        // Создаем государство
        Country russia = new Country("Российская Федерация", moscow);
        russia.addRegion(buryatia);
        russia.addRegion(irkutskRegion);
        russia.addRegion(zabaykalskyKrai);


        // Вывод информацию о государстве
        System.out.println(russia);
        System.out.println();


        // Выводим информацию
        russia.printCapital();
        russia.printNumberOfRegions();
        russia.printRegionalCenters();
        System.out.println("Общая площадь: " + russia.calculateTotalArea() + " км²");
    }
}
