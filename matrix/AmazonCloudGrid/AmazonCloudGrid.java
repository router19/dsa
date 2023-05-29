package AmazonCloudGrid;
import java.util.*;
public class AmazonCloudGrid {
	
	static boolean checkserver(List<List<Integer> > table) 
	{
		for(int rows=0;rows<table.size();rows++)
        {
        	for(int col=0;col<table.get(rows).size();col++)
        	{
        		if(table.get(rows).get(col) == 0)
        			return false;
        	}
         }
		
		return true;
	}
	
	static void createTable(List<List<Integer> > grid,List<List<Boolean> > table)
	{
		for(List lists : grid)
		{
			List<Boolean> temp = new ArrayList<Boolean>();
			Iterator itr = lists.iterator();
			while(itr.hasNext())
			{
				temp.add(((int)itr.next()==1));
			}
			table.add(temp);
		}
	}
	
	static void updateTable(List<List<Integer> > grid,List<List<Boolean> > table)
	{
		for(int i = 0;i < grid.size();i++)
		{
			for(int j =0; j < grid.get(i).size();j++)
			{
				if(grid.get(i).get(j) == 1)
				{
					List<Boolean> temp = table.get(i);
					temp.set(j, true);
				}
			}
		}
	}
	static int minimumHours(int rows, int columns, List<List<Integer> > grid)
	    {
	     
		List<List<Boolean>> table = new ArrayList<List<Boolean>>();//list to hold 2d matrix
		createTable(grid, table);
		int hours = 0;
		for(hours =0;!checkserver(grid);hours++) {
		 
		 for(int i=0;i <grid.size();i++)
		 {
			 for(int j=0;j<grid.get(i).size();j++)
			 {
				 if(grid.get(i).get(j) ==1 && table.get(i).get(j))
				 {
					 if(i-1 >= 0)
					{
					 List<Integer> list = grid.get(i-1);
					 list.set(j, 1);
					 
					 }
					if(i+1 <rows)
					 {
					  List<Integer> list = grid.get(i+1);
					  list.set(j, 1);
						 
					 }
					if(j-1 >=0)
					{
						List<Integer> list = grid.get(i);
						 list.set(j-1, 1);
					}
					if(j+1 <columns)
					{
						List<Integer> list = grid.get(i);
						 list.set(j+1, 1);
					}
				 }
			 }
		 }
		 updateTable(grid, table);
		 System.out.println("After "+(hours+1) + " iteration --> Matrix is ");
		 display(grid);
		 System.out.println();
		 System.out.println();
		}
		
		
		 return hours;
	    }
	
	static void display(List<List<Integer>> grid)
	{
		for(int i=0;i<grid.size();i++)
        {
        	for(int col=0;col<grid.get(i).size();col++)
        	{
        		System.out.print(grid.get(i).get(col) + " ");
        	}
        	System.out.println();
        }
	}
	public static void main(String args[])
	{
		Integer[][] data = {
	            { 0, 1, 1, 0, 1 },
	            { 0, 1, 0, 1, 0 },
	            { 0, 0, 0, 0, 1 },
	            { 0, 1, 0, 0, 0 },
	            { 0, 0, 0, 0, 0 }
	        };
	       
	       
        List<List<Integer>> table = new ArrayList<List<Integer>>();//list to hold 2d matrix
       
        for (Integer[] row : data) {//iterate each row of 2d array
            //table.add( Arrays.asList(row));//convert 1d array into list and then add it to list of list
        	List<Integer> temp = Arrays.asList(row);
        	table.add(temp);
        }
        
        //System.out.println(table.size());
//        for(int rows=0;rows<table.size();rows++)
//        {
//        	for(int col=0;col<table.get(rows).size();col++)
//        	{
//        		System.out.print(table.get(rows).get(col) + " ");
//        	}
//        	System.out.println();
//        }
        
        System.out.println(minimumHours(5, 5, table));
	}

}
