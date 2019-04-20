class Solution {
    public String fractionToDecimal(int num, int denom) {
    	StringBuilder sb = new StringBuilder();
    	long numerator = num, denominator = denom;
    	if (numerator < 0 || denominator < 0) {
    		if (numerator > 0 || denominator > 0) sb.append('-');
    		numerator = Math.abs(numerator);
    		denominator = Math.abs(denominator);
    	}
        sb.append(numerator / denominator);
        numerator %= denominator;
        if (numerator != 0) sb.append('.');
        HashMap<Long, Integer> map = new HashMap<>();
        while (numerator != 0 && !map.containsKey(numerator)) {
        	map.put(numerator, sb.length());
        	numerator *= 10;
        	sb.append(numerator / denominator);
        	numerator %= denominator;
        }
        if (numerator != 0) {
        	sb.insert(map.get(numerator), "(").append(')');
        }
        return sb.toString();
    }
}
