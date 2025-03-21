package src.greedy;

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g,int[] s){
        // we can only assign cookie of size s[i] if s[i]>=g[i]
        // here we don't need to multiple cookies to same child only one can
        // and that too we don't need to assign largest because it can be assigned to largest one
        // so we can do this greedily by selecting cookie size which is most approriate
        // we can do this by sorting arrays

        int n = g.length;
        int m = s.length;
        if(m==0) return 0;


        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0,r=0;
        while(l<n && r<m){
            if(g[l]<=s[r]){
                l= l+1;
            }
            r = r+1;

        }
        return l;



    }


    public static void main(String[] args) {
        int[] g = {1,3,3,4,5};
        int[] s = {4,2,1,2,1,3};

        System.out.println(findContentChildren(g,s));


    }
}
