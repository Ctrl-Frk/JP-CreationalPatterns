public class Person {
    protected final String name;
    protected final String surname;
    private Integer age;
    private String address;

    protected Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday(int age) {
        if (!hasAge()) {
            throw new IllegalStateException("Возраст неизвестен");
        } else if ((age - getAge()) != 1) {
            throw new IllegalArgumentException("В день рождения возраст увеличивается только на +1 год :)");
        } else {
            this.age = age;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAge(0)
                .setAddress(getAddress());
    }

    public String toString() {
        String result = "'" + name + " " + surname;
        StringBuilder sb = new StringBuilder(result);
        if (hasAge()) {
            sb.append(" ").append(age).append("(лет)");
        }
        if (hasAddress()) {
            sb.append(" из города ").append(address);
        }
        sb.append("'");
        return sb.toString();
    }
}
