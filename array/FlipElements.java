import java.util.ArrayList;
import java.util.List;


public class FlipElements {

	static List<Integer> cellComplete(int states[],int days)
	{
		//int a[] = states.clone();
		int prev = states[0];
		int i;
		while(days-- > 0)
		{
			for(i =0; i < states.length;i++)
			{
				if(i == 0)
				{
					prev = states[0];
					if(states[i+1] == 0)
						states[i] =0;
					else
						states[i] = 1;
				}
				else if(i == states.length -1)
				{
					if(prev == 0)
						states[i] = 0;
					else
						states[i] = 1;
				}
				else
				{
					
					if(prev == 0 && states[i+1] == 0)
					{
						prev = states[i];
						states[i] =0;
					}
					else if(prev == 1 && states[i+1] == 1)
					{
						prev = states[i];
						states[i] =0;
					}
					else
					{
						prev = states[i];
						states[i] =1;
					}
				}
			}
		}
		
		List<Integer> finalstate = new ArrayList<Integer>();
		for(i =0;i < states.length;i++)
			finalstate.add(states[i]);
		
		return finalstate;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int states[] = {1,0,0,0,0,1,0,0};
		List<Integer> finalState = cellComplete(states,1);
		System.out.println(finalState.toString());
	}

}
