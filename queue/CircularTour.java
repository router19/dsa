/*
Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.

  The amount of petrol that every petrol pump has.
  Distance from that petrol pump to the next petrol pump.

Calculate the first point from where a truck will be able to complete the circle (The truck will stop at each
petrol pump and it has infinite capacity). Expected time complexity is O(n). Assume for 1-litre petrol, the truck
can go 1 unit of distance.

For example, let there be 4 petrol pumps with amount of Petrol and distance to next petrol pump value pairs as
{4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where 
the truck can make a circular tour is 2nd petrol pump. Output should be “start = 1” (index of 2nd petrol pump).

 
TIME COMPLEXITY 
 Time Complexity: Seems to be more than linear at first look. If we consider the items between start and end 
 as part of a circular queue, we can observe that every item is enqueued at most two times to the queue.
 The total number of operations is proportional to the total number of enqueue operations.
 Therefore the time complexity is O(n).

Auxiliary Space: O(1)
 */

public class CircularTour {

	static class petrolPump 
    { 
        int petrol; 
        int distance; 
          
        // constructor 
        public petrolPump(int petrol, int distance)  
        { 
            this.petrol = petrol; 
            this.distance = distance; 
        } 
        
    }
	static int printTour(petrolPump a[], int n)
	{
		int start =0 ,end =1;

		int curr_petrol = a[start].petrol - a[start].distance;
		
		while(end != start || curr_petrol < 0)
		{
			while(curr_petrol < 0 && start !=end)
			{
				curr_petrol -= a[start].petrol - a[start].distance;
				
				start = (start + 1) % n;
				
				if(start == 0)
					return -1;
			}
			
			curr_petrol += a[end].petrol - a[end].distance;
			
			end = (end + 1) %n;
		}
		return start;
	}
	public static void main(String[] args) {
		
		petrolPump[] arr = {new petrolPump(6, 4), 
                new petrolPump(3, 6), 
                new petrolPump(3, 3)}; 


		int start = printTour(arr, arr.length); 


		System.out.println(start == -1 ? "No Solution" : "Start = " + start);  
	}

}
