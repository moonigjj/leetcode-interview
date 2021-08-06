package leetcode.easy;

/**
 * 551 .Student Attendance Record I
 *
 * You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
 *
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 *
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "PPALLP"
 * Output: true
 * Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
 * Example 2:
 *
 * Input: s = "PPALLL"
 * Output: false
 * Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 */
public class StudentAttendanceRecordI {

    public static void main(String[] args) {

        System.out.println(checkRecord("AA"));
    }


    public static boolean checkRecord(String s) {
        int a = 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i++){
            char index = arr[i];
            if ('A' == index) {
                if (++a >= 2){
                    return false;
                }
            } else if ('L' == index
                    && i < len - 2
                    && arr[i+1] == index
                    && arr[i+2] == index) {
                return false;
            }

        }

        return true;
    }
}
