import java.util.*;
public class RecursiveSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GfG object = new GfG();
		System.out.println("Enter size of input stack:");
		int stackSize = scanner.nextInt();
		Stack<Integer> input = new Stack<Integer>();
		System.out.println("Enter a stack of integers");
		
		while(stackSize-- > 0) {
			input.push(scanner.nextInt());
			
		}
		System.out.println("Result after recursively sorting the stack is:");
		Stack<Integer> a = object.sort(input);
		while(!a.isEmpty())
		{
			System.out.print(a.peek() + " ");
			a.pop();
		}
	scanner.close();
	}
	

}
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s.size() == 1) return s;
		else if(!s.isEmpty() && s.size() > 1) {
		    int temp = s.pop();
		    sort(s);
		    sortedInsert(s, temp);
		}
		return s;
	}
	//helper function 
	static void sortedInsert(Stack<Integer> s, int element) {
	    if(s.isEmpty() || element > s.peek()) {
	        s.push(element);
	    }
	    else {
	        int temp = s.pop();
		    sortedInsert(s, element);
		    s.push(temp);
	    }
	}
	
}
