class Solution {
public:
    int divide(int dividend, int divisor) {
      if (divisor == 0) return INT_MAX;
        if (dividend == INT_MIN && divisor == -1)
            return INT_MAX;
        return dividend / divisor;
    }
};
