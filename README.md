# Course Management System

A simple Java application to manage courses and student registrations. This program allows students to register for courses, drop courses, view available courses, and list their registered courses.

## Features

1. **Course Database**:
   - Store course information including:
     - Course Code
     - Title
     - Description
     - Capacity
     - Schedule
     - List of registered students

2. **Student Database**:
   - Store student information including:
     - Student ID
     - Name
     - List of registered courses

3. **Functionalities**:
   - Display all available courses with their details and available slots.
   - Allow students to register for courses if slots are available.
   - Enable students to drop courses they have registered for.
   - List all courses a student is currently registered in.

## Getting Started

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) version 8 or later.
- Any Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VS Code).

### Installation

1. Clone the repository or copy the source code.
2. Open the project in your preferred Java IDE or text editor.
3. Compile the `CourseStudentManagement.java` file.
4. Run the program.

### How to Use

1. Launch the application.
2. Use the menu to perform the following actions:
   - **1. List Courses**: Displays all available courses with details.
   - **2. Register for a Course**: Register a student for a course using their student ID and course code.
   - **3. Drop a Course**: Drop a course for a student using their student ID and course code.
   - **4. List Registered Courses**: View all courses registered by a student.
   - **5. Exit**: Exit the program.

### Sample Commands

1. **Registering a Student for a Course**:
   - Enter student ID and course code when prompted.
   - If slots are available, the registration is successful.

2. **Dropping a Course**:
   - Enter student ID and course code when prompted.
   - The course is removed from the student's registered courses if they are registered.

3. **Listing Courses**:
   - Displays all courses with their details such as title, schedule, and available slots.

4. **Viewing Registered Courses**:
   - Enter the student ID to view all their registered courses.

## Example

```plaintext
Menu:
1. List Courses
2. Register for a Course
3. Drop a Course
4. List Registered Courses
5. Exit
Choose an option: 1

Available Courses:
Code: CS101, Title: Intro to Computer Science, Description: Basics of CS, Schedule: MWF 10-11 AM, Slots: 30/30
Code: MATH101, Title: Calculus I, Description: Intro to calculus, Schedule: TTh 1-2:30 PM, Slots: 25/25
Code: ENG101, Title: English Literature, Description: Study of classic literature, Schedule: MWF 2-3 PM, Slots: 20/20

