package ua.edu.ucu;


class Student {

    private double gpa;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double gpa, int year) {
        this.gpa = gpa;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return gpa;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", "
                + "GPA=" + gpa + ", year=" + year + '}';
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object s) {
        if (s == null || s.getClass() != this.getClass()) {
            return false;
        }
        return s.hashCode() == this.hashCode();
    }

}
