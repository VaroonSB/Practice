class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();

        Arrays.sort(folder);

        list.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String prev = list.getLast();
            if (!folder[i].startsWith(prev + '/')) {
                list.add(folder[i]);
            }
        }

        return list;
    }
}

// there is a trie solution