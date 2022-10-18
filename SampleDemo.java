import java.util.*;
public class SampleDemo {
static public void main(String []ar)  {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a string:");
	 String str = sc.next();
	    System.out.print(decodeString(str) +"\n");
	    sc.close();
}

//recursive function
static Stack<String> stack = new Stack<String>();
static String result = "";

static void decode(char []s, int index)  {
	if(index == s.length) {
		result = stack.peek();
		return;
	}
	
	//if character is a '['
	if(s[index] == '[');
	
	// if character is a ']'
	else if(s[index] == ']') 
	{
		String temp = stack.peek();
		stack.pop();
		
		//pop integer x from stack
		int x = Integer.valueOf(stack.peek());
		stack.pop();
		for(String j = temp;x>1;x--) 
			temp = temp + j;
		
		String temp1 = stack.isEmpty()==false?stack.peek(): "";
		if(!temp1.isEmpty() && !(temp1.charAt(0) - '0' < 10)) {
			stack.pop();
			temp1 = temp1 + temp;
			stack.add(temp1);
		}
		else {
			stack.add(temp);
		}
	}
	
	//char is a digit
	  else if (s[index] - '0' < 10) {     
	      String temp = stack.isEmpty() == false ? stack.peek() : "";
	 
	      if (!temp.isEmpty() && temp.charAt(0) - '0' < 10 && s[index - 1] - '0' < 10) {
	        stack.pop();
	        temp = temp + s[index];
	        stack.add(temp);
	      }
	      else {
	        temp = String.valueOf(s[index]);
	        stack.add(temp);
	      }     
	    }
	 
	  else if (s[index] - 'a' < 26) {     
	      String temp = stack.isEmpty() == false ? stack.peek() : "";
	 
	      if (!temp.isEmpty() && temp.charAt(0) - 'a' >= 0
	          && temp.charAt(0) - 'a' < 26) {
	        stack.pop();
	        temp = temp + s[index];
	        stack.add(temp);
	      }
	      else {
	        temp = String.valueOf(s[index]);
	        stack.add(temp);
	      }   
	    }
	 
	    // Recursive call for next index
	    decode(s, index + 1);
	  }

static String decodeString(String string) 
{
  decode(string.toCharArray(), 0);
  return result;
}
}