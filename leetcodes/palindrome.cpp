class Solution {
public:
    bool isPalindrome(int x) {
        int rem;
        long long rev=0,temp=x;
        if(x<0) return false;
        while(temp!=0)
        {
            rem=temp%10;
            rev=rev*10+rem;
            temp/=10;
        }
        return rev==x;
    }
};
