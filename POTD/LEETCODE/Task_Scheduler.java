// You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.

// ​Return the minimum number of intervals required to complete all tasks.

// Date: 10 March 2024

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());
        int cycles = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
 
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.remove());
                }
            }

            for (int task : temp) {
                if (task > 1) {
                    pq.add(task - 1);
                }
            }

            cycles += pq.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
    }
}