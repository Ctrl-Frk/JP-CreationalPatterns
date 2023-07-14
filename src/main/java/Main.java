public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(30)
                .setAddress("Сидни")
                .build();
        mom.happyBirthday(31);
        mom.setAddress("Сидней");

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын - " + son);

        Person personWithoutAge = new PersonBuilder()
                .setName("Неизвестный")
                .setSurname("Возраст")
                .build();

        try {
            //День рождения с неизвестным возрастом
            personWithoutAge.happyBirthday(1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            //Меняем возраст на +2 года
            mom.happyBirthday(33);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            //Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            //Недопустимый возраст
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}