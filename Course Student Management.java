import java.util.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<String> registeredStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents.size();
    }

    public boolean registerStudent(String studentId) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(studentId);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String studentId) {
        return registeredStudents.remove(studentId);
    }

    public List<String> getRegisteredStudents() {
        return registeredStudents;
    }
}

class Student {
    private String id;
    private String name;
    private List<String> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void addCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

class CourseManagementSystem {
    private Map<String, Course> courses;
    private Map<String, Student> students;

    public CourseManagementSystem() {
        courses = new HashMap<>();
        students = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses.values()) {
            System.out.println("Code: " + course.getCode() + ", Title: " + course.getTitle() + ", Description: " + course.getDescription() + ", Schedule: " + course.getSchedule() + ", Slots: " + course.getAvailableSlots() + "/" + course.getCapacity());
        }
    }

    public void registerStudentForCourse(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course code.");
            return;
        }

        if (course.registerStudent(studentId)) {
            student.addCourse(courseCode);
            System.out.println("Registration successful for course: " + course.getTitle());
        } else {
            System.out.println("Registration failed. No available slots in the course.");
        }
    }

    public void dropCourseForStudent(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course code.");
            return;
        }

        if (course.removeStudent(studentId)) {
            student.dropCourse(courseCode);
            System.out.println("Dropped course: " + course.getTitle());
        } else {
            System.out.println("Failed to drop course. Student was not registered in this course.");
        }
    }

    public void listStudentCourses(String studentId) {
        Student student = students.get(studentId);

        if (student == null) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.println("\nCourses registered by " + student.getName() + ":");
        for (String courseCode : student.getRegisteredCourses()) {
            Course course = courses.get(courseCode);
            System.out.println("Code: " + course.getCode() + ", Title: " + course.getTitle());
        }
    }
}

public class CourseStudentManagement {
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        // Add some courses
        cms.addCourse(new Course("CS101", "Intro to Computer Science", "Basics of CS", 30, "MWF 10-11 AM"));
        cms.addCourse(new Course("MATH101", "Calculus I", "Intro to calculus", 25, "TTh 1-2:30 PM"));
        cms.addCourse(new Course("ENG101", "English Literature", "Study of classic literature", 20, "MWF 2-3 PM"));

        // Add some students
        cms.addStudent(new Student("S001", "Alice"));
        cms.addStudent(new Student("S002", "Bob"));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. List Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. List Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cms.listCourses();
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter the course code to register: ");
                    String courseCode = scanner.next();
                    cms.registerStudentForCourse(studentId, courseCode);
                    break;
                case 3:
                    System.out.print("Enter your student ID: ");
                    studentId = scanner.next();
                    System.out.print("Enter the course code to drop: ");
                    courseCode = scanner.next();
                    cms.dropCourseForStudent(studentId, courseCode);
                    break;
                case 4:
                    System.out.print("Enter your student ID: ");
                    studentId = scanner.next();
                    cms.listStudentCourses(studentId);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
