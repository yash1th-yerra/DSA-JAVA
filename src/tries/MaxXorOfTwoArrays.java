package src.tries;

public class MaxXorOfTwoArrays {

    static class Node{
        static Node[] links = new Node[26];
        Node(){}
         boolean containsKey(int ind){
            return (links[ind]!=null);
        }
         Node get(int ind){
            return links[ind];
        }

         void put(int ind,Node node){
            links[ind] = node;
         }
    }

    static class Trie{
        private static Node root;
        Trie(){
            root = new Node();
        }

        public void insert(int num){
            Node node = root;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node = node.get(bit);

            }
        }


        public int getMax(int num){
            Node node = root;
            int maxNum = 0;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(node.containsKey(1-bit)){
                    maxNum = maxNum | (1<<i);
                    node = node.get(1-bit);
                }else{
                    node = node.get(bit);
                }
            }
            return maxNum;
        }

        static int maxXor(int[] arr1,int[] arr2){
            int n = arr1.length;
            int m = arr2.length;

            Trie trie = new Trie();
            for (int j : arr1) {
                trie.insert(j);
            }

            int  maxi =0;
            for (int j : arr2) {
                maxi = Math.max(maxi, trie.getMax(j));
            }
            return maxi;


        }


    }
}
