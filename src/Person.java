/**
 * 1-ый пункт ДЗ.
 * Класс Person.
 */
public class Person {

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    /**
     * 2-й пункт ДЗ. Конструктор класса Person
     * @param fullName - ФИО
     * @param position - должность
     * @param email - email
     * @param phone - телефон
     * @param salary - зарплата
     * @param age - возраст
     */
    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //Для задания понадобиться только геттер для поля age
    public int getAge() {
        return age;
    }

    /**
     * 3-ий пункт ДЗ:
     * вывод информации об объекте.
     */
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
