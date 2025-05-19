class Solution {
    public String triangleType(int[] sides) {
        int a = sides[0], b = sides[1], c = sides[2];

        // Check triangle validity
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Check triangle type
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
