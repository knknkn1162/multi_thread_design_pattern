package ch2.example;

/**
 * Created by kenta_nakajima on 2017/09/10.
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "[ Person: name = " + name + ", address = " + address + "]";
    }

}
