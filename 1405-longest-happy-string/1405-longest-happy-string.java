class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair first = pq.poll();
            int len = sb.length();

            if (len >= 2 && sb.charAt(len - 1) == first.ch && sb.charAt(len - 2) == first.ch) {
                if (pq.isEmpty()) {
                    break;
                }

                Pair second = pq.poll();
                sb.append(second.ch);
                second.count--;

                if (second.count > 0) {
                    pq.offer(second);
                }

                pq.offer(first);
            } else {
                sb.append(first.ch);
                first.count--;

                if (first.count > 0) {
                    pq.offer(first);
                }
            }
        }

        return sb.toString();
    }

    private static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}