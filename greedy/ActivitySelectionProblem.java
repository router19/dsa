
/**
 * Activity Selection problem 
 * There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.

What is the maximum number of meetings that can be accommodated in the meeting room?

Input:
The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line consists of the size of the array, second line has the array containing the starting time of all the meetings each separated by a space, i.e., S [ i ]. And the third line has the array containing the finishing time of all the meetings each separated by a space, i.e., F [ i ].

Output:
In each separate line print the order in which the meetings take place separated by a space.

Constraints:
1 ≤ T ≤ 70
1 ≤ N ≤ 100
1 ≤ S[ i ], F[ i ] ≤ 100000

Example:
Input:
2
6
1 3 0 5 8 5
2 4 6 7 9 9
8
75250 50074 43659 8931 11273 27545 50879 77924
112960 114515 81825 93424 54316 35533 73383 160252  

Output:
1 2 4 5
6 7 1 
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




 public class ActivitySelectionProblem {
	 static class Meeting
	  {
		int start;
		int finish;
			Meeting(){
				this.start = 0;
				this.finish = 0;
			}
		}
	
	private static Map<Meeting,Integer> objectIndex = new HashMap<Meeting,Integer>();
	
	
	public static void main(String[] args)  {

		Scanner in = new Scanner(System.in);
		int test_cases = in.nextInt();
		for(int i = 0; i < test_cases; i++) {
			
			int len = in.nextInt();
			Meeting[] meetingArr = new Meeting[len];
			
			for(int j = 0; j < len; j++) {
				
				meetingArr[j] = new Meeting();
				meetingArr[j].start = in.nextInt();
			}
			
			for(int j = 0; j < len; j++) {
				meetingArr[j].finish = in.nextInt();
			}
			
			for (int j = 0; j < len ; j++)
				objectIndex.put(meetingArr[j], j + 1);
			
			Meeting[] meetingArr2 = new Meeting[len];
			meetingArr2 = meetingArr.clone();
			
			Arrays.sort(meetingArr, new Comparator<Meeting>() {
				public int compare(Meeting o1, Meeting o2) {
					return o1.finish - o2.finish;
				}
			});
			
			//maximumNumberOfMeeting(meetingArr,meetingArr2,len);
			maximumNumberOfMeetingUsingHashMap(meetingArr,len);
			System.out.println();
			objectIndex.clear();
		}//for test cases
		

	}//main
	
	private static void maximumNumberOfMeetingUsingHashMap(Meeting[] meetingArr, int len) {
		int i =0;
		System.out.print( objectIndex.get(meetingArr[i])+ " ");
		for(int j = i + 1; j < len ; j++) {
			if(meetingArr[j].start > meetingArr[i].finish) {
				i = j;
				System.out.print(objectIndex.get(meetingArr[i]) + " ");
			}
		}
		
	}

	public static void maximumNumberOfMeeting(Meeting[] m1,Meeting[] m2, int len) {
		int i = 0;
		System.out.print(findIndexOf(m1[i],m2) + " ");
		for(int j = i+1; j < len; j++) {
			if(m1[j].start > m1[i].finish) {
				i =j;
				System.out.print(findIndexOf(m1[i],m2) + " ");
			}
		}
	}

	private static int  findIndexOf(Meeting meeting, Meeting[] m2) {
		// TODO Auto-generated method stub
		for(int i =0; i < m2.length; i ++)
			if(meeting.equals(m2[i]))
				return i + 1;
		return -1;
	}
	
		
	

}//class
