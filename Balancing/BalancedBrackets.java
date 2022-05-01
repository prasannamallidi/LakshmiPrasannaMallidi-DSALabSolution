import java.util.*;

public class BalancedBrackets {

	static boolean areBracketsBalanced(String expr)
	{
		Deque<Character> stack
			= new ArrayDeque<Character>();

		for (int i = 0; i < expr.length(); i++)
		{
			char eachChar = expr.charAt(i);

			if (eachChar == '(' || eachChar == '[' || eachChar == '{')
			{
				stack.push(eachChar);
				continue;
			}

			if (stack.isEmpty())
				return false;
            
			char check;
			switch (eachChar) 
            {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
			
            }
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args)
	{
		String expr1 = "([[{}]])";
        System.out.println(expr1);
		
        if (areBracketsBalanced(expr1))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
        /*
        String expr2 = "([[{}]]))";
        System.out.println(expr2);
		
        if (areBracketsBalanced(expr2))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered String do not contain Balanced Brackets");
        */
	}
}
