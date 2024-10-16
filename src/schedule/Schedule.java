package schedule;

import java.util.Scanner;

public class Schedule {

    public static void main(String[] args) {
        String resp;

        Scanner sc = new Scanner(System.in);  // Declare scanner outside the loop to avoid creating multiple instances

        do {
            Schedule test = new Schedule();

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    test.addRecord();
                    break;
                case 2:
                    test.viewRecord();
                    break;
                case 3:
                    test.viewRecord();
                    test.updateRecord();
                    break;
                case 4:
                    test.viewRecord();
                    test.deleteRecord();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();  // Close scanner before exiting
                    return;      // Exit the loop and terminate the program
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            System.out.print("Do you want to continue (yes/no)? ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));

        sc.close();  // Ensure scanner is closed
    }

    public void addRecord() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter schedule ID: ");
        String sid = sc.next();
        System.out.print("Enter Course ID: ");
        String courseId = sc.next();
        System.out.print("Enter Instructor ID: ");
        String instructorId = sc.next();
        System.out.print("Enter Day of Week: ");
        String dayOfWeek = sc.next();
        System.out.print("Enter Start Time: ");
        String startTime = sc.next();
        System.out.print("Enter End Time: ");
        String endTime = sc.next();

        String sql = "INSERT INTO schedule (schedule_ID, course_ID, instructor_ID, day_of_Week, dtart_Time, end_Time) VALUES (?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, sid, courseId, instructorId, dayOfWeek, startTime, endTime);
    }

    public void viewRecord() {
        String qry = "SELECT * FROM Schedule";
        String[] hdrs = {"Schedule_ID", "Course ID", "Instructor ID", "Day of Week", "Start Time", "End Time"};
        String[] clmns = {"Schedule_ID", "Course_ID", "Instructor_ID", "Day_of_Week", "Start_Time", "End_Time"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }

    public void updateRecord() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Schedule ID: ");
        String sid = sc.next();
        System.out.print("Enter Course ID: ");
        String courseId = sc.next();
        System.out.print("Enter Instructor ID: ");
        String instructorId = sc.next();
        System.out.print("Enter Day of Week: ");
        String dayOfWeek = sc.next();
        System.out.print("Enter Start Time: ");
        String startTime = sc.next();
        System.out.print("Enter End Time: ");
        String endTime = sc.next();

        String qry = "UPDATE Schedule SET Course_ID = ?, Instructor_ID = ?, Day_of_Week = ?, Start_Time = ?, End_Time = ? WHERE Schedule_ID = ?";
        config conf = new config();
        conf.updateRecord(qry, courseId, instructorId, dayOfWeek, startTime, endTime, sid);
    }

    public void deleteRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Schedule ID to delete: ");
        String sid = sc.next();

        String qry = "DELETE FROM Schedule WHERE Schedule_ID = ?";

        config conf = new config();
        conf.deleteRecord(qry, sid);
    }
}
