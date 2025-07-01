package src.recursion.subsequencesPatterns;

public class GenerateBinaryStrings {

    // given n and we need to build all binary string of length n
    public static void generateBinaryStrings(int n,StringBuilder sb){
        if(n==sb.length()){
            System.out.println(sb.toString());
            return ;
        }

        sb.append('0');
        generateBinaryStrings(n,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append('1');
        generateBinaryStrings(n,sb);;
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        int n = 4;
        generateBinaryStrings(n,new StringBuilder());
    }
}
