package Student_Management;

import java.util.*;

public class StudentManager {
    private List<Students> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (getStudentById(id) != null) {
            System.out.println("Student with this ID already exists! ");
            return;
        }

        System.out.print("Enter Your Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        students.add(new Students(id, name, marks));
        System.out.println("Student added ! ");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nID    Name           Marks");
        System.out.println("----    -----------    -----");
        for (Students s : students) {
            System.out.println(s);
        }
    }

    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        Students student = getStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        scanner.nextLine(); // clear buffer
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new marks: ");
        double marks = scanner.nextDouble();

        student.setName(name);
        student.setMarks(marks);
        System.out.println("Student updated!");
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        Students student = getStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted.");
    }

    public void sortStudentsByMarks() {
        students.sort(Comparator.comparing(Students::getMarks).reversed());
        System.out.println("Students sorted by marks <high to low>");
    }

    private Students getStudentById(int id) {
        for (Students s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
