// Given a string n, your task is to find whether it contains an additive sequence or not. A string n contains an additive sequence if its digits can make a sequence of numbers in which every number is addition of previous two numbers. You are required to complete the function which returns true if the string is a valid sequence else returns false. For better understanding check the examples.
// Note: A valid string should contain at least three digit to make one additive sequence. 

// Date: 26 March 2024

class Solution {
    public boolean isAdditiveSequence(String n) {
        // code here
        for(int i=0;i<n.length()/2;i++){
            for(int j=i+1;j<n.length()-1;j++){
                String a = n.substring(0,i+1);
                String b = n.substring(i+1,j+1);
                String c = n.substring(j+1);
                if(help(a,b,c))return true;
            }
        }
        return false;
    }
    static String findSum(String a,String b){
        int i=a.length()-1,j=b.length()-1;
        StringBuilder ans = new StringBuilder();
        int carry=0;
        while(i>=0 && j>=0){
            int sum = (a.charAt(i)-'0')+(b.charAt(j)-'0')+carry;
            ans.append((char)sum%10);
            carry=sum/10;
            i--;
            j--;
        }
        while(i>=0){
            int sum = (a.charAt(i)-'0')+carry;
            ans.append((char)sum%10);
            carry=sum/10;
            i--;
        }
        while(j>=0){
            int sum = (b.charAt(j)-'0')+carry;
            ans.append((char)sum%10);
            carry=sum/10;
            j--;
        }
        if(carry!=0){
            ans.append((char)(carry+'0'));
        }
        StringBuilder temp = ans.reverse();
        return temp.toString();
    }
    static boolean help(String a,String b,String c){
        String sum = findSum(a,b);
        int i=0,j=0;
        while(i<c.length() && j<sum.length()){
            if(c.charAt(i)!=sum.charAt(j))return false;
            i++;
            j++;
        }
        if(j!=sum.length())return false;
        if(i==c.length())return true;
        c=c.substring(i);
        return help(b,sum,c);
    }
   
}
