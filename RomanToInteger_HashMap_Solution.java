class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanIntMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        int sum = 0;
        int length = s.length();
        if(s.length() > 0) {
        for (int i = 0; i < length; i++) {
            int currentValue = romanIntMap.get(s.charAt(i));

            if (i + 1 < s.length() && currentValue < romanIntMap.get(s.charAt(i + 1))) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
        }
        }
        return sum;
    }
}
