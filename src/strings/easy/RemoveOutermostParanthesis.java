package src.strings.easy;

public class RemoveOutermostParanthesis {


    /*
        A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
        For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
        A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
        Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
        Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

        Testcase-1:
        Input : s = “(()())(())”
        Explanation : 	(()())     (())  ->  ()()  + () -> ()()()
        Output : ()()()

        Initialize an empty string
        Initialize counter variable
        Increment counter variable if ‘(‘ is current character.
        While incrementing if it goes beyond 1 and current element is ‘(‘ add that character to result string
        Similarly if you found ‘)’ decrement counter
        While decrementing if counter is still beyond 1 that means you already inside one primitive so you just need to add that ‘)’. So add it
        Once done return resultant string.

        Time Complexity - O(N)
        Space Complexity - O(1)
*/

    private static String removeOuterParanthesis(String inputString){
        StringBuilder outputString = new StringBuilder();
        int counter = 0;
        for(char ch : inputString.toCharArray()){
            if(ch=='('){
                if(counter>0) outputString.append('(');
                counter++;
            }
            else if(ch==')'){
                counter--;
                if(counter>0) outputString.append(")");
            }
        }

        return outputString.toString();
    }
    static void main() {
        String inputString= "(()())(())";
        String outputString  = removeOuterParanthesis(inputString);
        System.out.println(inputString);
        System.out.println(outputString);
    }
}
