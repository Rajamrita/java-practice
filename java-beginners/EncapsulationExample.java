class Student {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {

        Student s = new Student();
        s.setId(10);
        System.out.println(s.getId());
    }
}