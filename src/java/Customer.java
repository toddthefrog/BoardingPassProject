public class Customer {
    private String name;
    private String email;
    private String number;
    private Genders gender;
    private int age;
    enum Genders {
        Male,
        Female,
        Other,
        Java_Developer
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getName() + "\n  age: " + getAge() + "\n  phone number: " + getNumber() + "\n  email: " + getEmail() + "\n  gender: " + getGender().toString();
    }
}
