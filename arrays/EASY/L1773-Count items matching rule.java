class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matchCount = 0;
        for (int i = 0; i < items.size(); i++) {
            matchCount += isMatch(items.get(i), ruleKey, ruleValue);
        }
        return matchCount;
    }

    static int isMatch(List item, String key, String value) {
        switch (key) {
            case "type":
                if (item.get(0).equals(value)) return 1;
                break;
            case "color":
                if (item.get(1).equals(value)) return 1;
                break;
            case  "name":
                if (item.get(2).equals(value)) return 1;
                break;
            default:
                return 0;
        }
        return 0;
    }
}