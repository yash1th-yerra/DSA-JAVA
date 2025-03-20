package src.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NMeetingsInRoom {


    // given two arrays start and end with size n , representing startTime and endTime of meetings
    // we need to maximize the no of meetings accommodated in a single room
    // start = [0,3,1,5,5,8]
    // end = [5,4,2,9,7,9]

    // if we follow the same order we'll get (start,end) -> (0,5),(8,9) -> 2 meetings which is not maximum
    // so we need to select meetings that end quicker
    // that is we are greedy about endTime
    // 1. so we need to sort meeting by endTime
    // 2. maintain counter variable to count meetings
    // 3. to maintain the order they are conducted (if needed) by taking some data structure

    // after sorting
    // start = [1,3,0,5,5,8]
    // end = [2,4,5,7,9,9]
    // 1. first we'll definitely add first meeting into data structure and initialize count = 1
    // 2. then we'll loop thorugh meeting and check if start time of meeting is greater than or not with vacateTime(which is nothing but the last meeting's endTime)
    // 3. if so increment count, update vacateTime and add meeting order into datastructure


    static class Meeting{
        int start,end, order;

        Meeting(int start ,int end ,int order){
            this.order = order;
            this.start = start;
            this.end = end;
        }
    }


    public static int findMaxMeetings(int[] start,int [] end){
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meetings.add(new Meeting(start[i],end[i],i+1));
        }


        meetings.sort((a, b) -> a.end - b.end );
        List<Integer> order = new ArrayList<>();
        int count = 1,vacateTime = meetings.get(0).end;
        order.add(meetings.get(0).order);
        for(Meeting meeting : meetings){
            if(meeting.start>vacateTime){
                count++;
                vacateTime=meeting.end;
                order.add(meeting.order);
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1 = {2, 4, 6, 7, 9, 9};
        System.out.println(findMaxMeetings(start1, end1)); // Output: 4

        int[] start2 = {10, 12, 20};
        int[] end2 = {20, 25, 30};
        System.out.println(findMaxMeetings(start2, end2)); // Output: 1

        int[] start3 = {1, 2};
        int[] end3 = {100, 99};
        System.out.println(findMaxMeetings(start3, end3)); // Output: 1
    }

}
