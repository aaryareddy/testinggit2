// Design a Trie  ( Very hard)
class Trie {
    TrieNode root;
        class TrieNode{
            
            TrieNode[] children;
            boolean endOfTheWord;
            
            public TrieNode(){
                children= new TrieNode[26];
                endOfTheWord = false;
            }
        }

        /** Initialize your data structure here. */
        public Trie() {
                root = new TrieNode();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            
            TrieNode cur = root;
            
            for(int i=0;i<word.length();i++){
               char ch = word.charAt(i);
                
                TrieNode node = cur.children[ch-'a'];
                 
                if(node==null){
                    node = new TrieNode();
                    cur.children[ch-'a'] =node;
                }
                
                cur=node;
            }
            
             cur.endOfTheWord= true;
             return;
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            
            TrieNode cur = root;
              
            for(int i=0; i<word.length();i++){
                char ch = word.charAt(i);
        
                 TrieNode node = cur.children[ch-'a'];
                
                if(node==null)
                    return false;
                
                cur = node;
            }
            
            return cur.endOfTheWord;
            
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(prefix.length()==0)
                return true;
            
            TrieNode cur= root;
            
            for(int i=0; i<prefix.length();i++){
                char ch =prefix.charAt(i);
                
                TrieNode node = cur.children[ch-'a'];
                if(node==null)
                    return false;
                
                if(i< prefix.length()-1 && node==null)
                    return false;
                
                cur=node;
        }
    
        
        return true;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     * 
     * Only Lowercase alphabet characters are accepted in the Trie as input
     * 'insert' arguments are expected to have 1 <= size <= 2147483647  
     * 'startsWith' arguments are expected to have 1 <= size <= 2147483647   
     * 'search' arguments are expected to have 1 <= size <= 2147483647  
     */


    // Test Case -1 
    ["Trie","insert","search","search","startsWith","insert","search","startsWith"]
    [[],["python"],["python"],["py"],["py"],["py"],["py"],["py"]]

    //Expected answer -1 
    [null,null,true,false,true,null,true]

    // Test Case -2
    ["Trie","startsWith"]
    [[],["z"]]

    // Expected answer -2
    [null,false]

    // Test Case -3
    ["Trie","startsWith","search"]
    [[],["a"],["xyz"]]

    // Expected answer -3 
    [null,false,false]

    // Test Case -4
    ["Trie","insert","search","startsWith"]
    [[],["java"],["ja"],["ja"]]

    // Expected answer -4
    [null,null,false,true]


//Add two Linked lists (Medium)
/**
 * Definition for singly-linked list.
 * public class Node {
 *     int val;
 *     Node next;
 *     Node(int x){
 *        val = x; 
 *     }
 * }
 */

// Inputs are two linked lists which represent non- negative integers
// The digits are stored in reverse order.
//ach of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
class Solution {
    public Node addTwoLinkedLists(Node l1, Node l2) {
        
        Node a = l1,b=l2;
        
        Node dummy = new Node(0);
        Node prev = dummy;
        
        int carry=0;
        
        while(a!=null && b!=null){
            int digit1 = a.val;
            int digit2= b.val;
            
            int temp = digit1 + digit2+carry;
            
            int res = temp%10;
            carry = temp/10;
            
            Node cur = new Node(res);
            prev.next=cur;
            prev=cur;
            
            a=a.next;
            b=b.next;
        }
        
        while(a!=null){
            int temp = a.val+carry;
            int res = temp%10;
            carry = temp/10;
            
            Node cur = new Node(res);
            prev.next=cur;
            prev=cur;
            
            a=a.next;
        }
        
        while(b!=null){
            int temp = b.val+carry;
            int res = temp%10;
            carry = temp/10;
            
            Node cur = new Node(res);
            prev.next=cur;
            prev=cur;
            
            b=b.next;
        }
        
        if(carry!=0){
            Node cur = new Node(carry);
            prev.next = cur;
            prev=cur;
        }
        
        return dummy.next;
    }
}

//Test Case -1 
[2,7,3]
[5,5,4]

//Expected answer -1
[7,2,8]

// Test Case -2
[1,8,9]
[3,8,9]

//Expected answer-2
[4,6,9,1]

// Test case -3
[]
[3,8,9]

//Expected answer -3
[3,8,9]

//Test Case -4
[6,9,3,2,9]
[0,9]

//Expected answer -4    
[6,8,4,2,9]

//Test case -5
[7,6,5,2]
[3,4,5,8]

//Expected answer -5
[0,1,1,1,1]

//Test Case -6
[0]
[6,5,4]

//Expected answer -6
[6,5,4]



// Search a given element in a LinkedList (Easy)
// All the elements in the linkedlist are unique
// 0 <= length of the linkedlist <= 10^5
/**
 * Definition for singly-linked list.
 * public class Node {
 *     int val;
 *     Node next;
 *     Node(int x){
 *        val = x; 
 *     }
 * }
 */

 class Solution{

    public boolean SearchElement(Node head, int x){

        if(head==null)
            return false;

        Node cur = head;  
        while (cur != null) 
        { 
            if (cur.val == x) 
                return true;    //node found 
            cur = cur.next; 
        } 
        return false;    //data not found 
    }
 }

 // Test Case 1
 [1,2,3,4,5,6,7]
 [1]

 //Expected answer 1
 [true]

 // Test Case 2
 []
 10

 // Expected answer 2
 [false]

  // Test Case 3
  [3,7,4,1]
  [7]
 
  //Expected answer 3
  [false]




  // Hop to the end index

  class Solution {
    public boolean canHop(int[] nums) {
       
        if(nums.length==1)
            return true;
        
     return helper(nums,nums.length-2, nums.length-1);
                
        }
    
    public boolean helper(int[] nums,int pos, int res){
        
        if(pos==0 && pos+nums[pos]>=res)
            return true;
        
        else if(pos>0 && pos + nums[pos]>=res){
           return helper(nums,pos-1,pos);
        }
        
        else if(pos>0 && pos+nums[pos]<res){
           return helper(nums,pos-1,res);
        }
        
        return false;
    }
    
}

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.
// Test case 1
[2,3,1,1,4]

// Expected answer
[true]

// Test Case 2
[0]

//Expected answer 2
[true]

// Test Case 3
[8]

//Expected answer 3
[true]

// test case 4
[3,0,8,2,0,0,1]

// Expected answer 4
[true]

// test case 5
[0,0,0,0,0]

// Expected answer 5
false

// Test case 6
[6,5,4,3,2,1,0,8]

// Expected answer 6
false
