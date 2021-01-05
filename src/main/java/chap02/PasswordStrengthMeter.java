package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCounts = getMetCriteriaCounts(s);

        PasswordStrength passwordStrength;
        switch (metCounts) {
            case 2:
                passwordStrength = PasswordStrength.NORMAL;
                break;
            case 3:
                passwordStrength = PasswordStrength.STRONG;
                break;
            default:
                passwordStrength = PasswordStrength.WEAK;
                break;
        }
        return passwordStrength;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;

        if (meetsContaingingNumberCriteria(s)) {
            metCounts++;
        }
        if (meetsContainingUppercaseCriteria(s)) {
            metCounts++;
        }
        if (s.length() >= 8) {
            metCounts++;
        }
        return metCounts;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContaingingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
