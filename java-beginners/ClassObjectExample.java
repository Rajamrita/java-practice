class Student {
    int id;
    String name;

    void display() {
        System.out.println(id + " " + name);
    }
}

public class ClassObjectExample {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.id = 1;
        s1.name = "Amrita";

        s1.display();
    }
}
