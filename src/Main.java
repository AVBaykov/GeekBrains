public class Main {
    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван Иванович", "Сантехник", "ivani4rulez@company.ru", "+7 916 808 80 80 ", 45_000, 53);
        persArray[1] = new Person("Путилов Аристарх Вениаминович", "Главный", "putilov.aristarh@company.ru", "+7 916 777 77 77 ", 400_000, 45);
        persArray[2] = new Person("Хаек Сэльма Агаповна", "Бухгалтер", "ivani4rulez@bk.ru", "+7 916 808 80 80 ", 70_000, 28);
        persArray[3] = new Person("Гудвин Джон Алексеевич", "Младший электрик", "goodwin@company.ru", "+7 916 808 80 80 ", 55_000, 30);
        persArray[4] = new Person("Фролов Фома Акакиевич", "Логопед", "ivani4rulez@bk.ru", "+7 916 808 80 80 ", 80_000, 41);

        for (Person p : persArray) {
            if (p.getAge() > 40) {
                System.out.println(p);
            }
        }

        /**
         * Проверка 8-ого пункта ДЗ
         */
        Animal cat = new Cat();
        Animal dog = new Dog();
        Animal cat1 = new Cat();
        Animal dog1 = new Dog();
        Animal cat2 = new Cat();
        Animal dog2 = new Dog();

        cat.run(100);
        cat.jump(1.5);
        cat.swim(5);

        dog.run(200);
        dog.jump(3);
        dog.swim(7);
    }
}
