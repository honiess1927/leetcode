class Solution {
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') > 0) {
            if (isValidIPv4(IP)) return "IPv4";
            else return "Neither";
        } else {
            if (isValidIPv6(IP)) return "IPv6";
            else return "Neither";
        }
    }

    private boolean isValidIPv4(String s) {
        print("IPV4 testing: ", s);
        if (s.charAt(s.length() - 1) == '.') return false;
        String[] segs = s.split("\\.");
        if (segs.length != 4) return false;
        print("Seg correct");
        for (String seg : segs) {
            print(seg);
            if (seg.isEmpty() || seg.length() > 3) return false;
            print("Length correct");
            if (seg.length() != 1 && seg.charAt(0) == '0') return false;
            print("No trailing zero");
            if (seg.charAt(0) == '-') return false;
            try {
                int value = Integer.parseInt(seg);
                print("Format correct");
                if (value > 255 || value < 0) return false;
                print("Value correct.");
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String s) {
        if (s.isEmpty() || s.charAt(s.length() - 1) == ':') return false;
        Set<Character> validChars = new HashSet<>();
        validChars.addAll(Arrays.asList('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','A','B','C','D','E','F'));
        String[] segs = s.split(":");
        if (segs.length != 8) return false;
        for (String seg : segs) {
            print(seg);
            if (seg.isEmpty() || seg.length() > 4) return false;
            print("Length correct");
            for (char ch : seg.toCharArray()) {
                if (!validChars.contains(ch)) return false;
            }
        }
        return true;
    }

    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
