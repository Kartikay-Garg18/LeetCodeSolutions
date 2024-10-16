class Solution {
    class Pair{
        char ch;
        int freq;
        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p,q) -> q.freq - p.freq);
        StringBuilder sb = new StringBuilder();
        if(a!=0) pq.add(new Pair('a', a));
        if(b!=0) pq.add(new Pair('b', b));
        if(c!=0) pq.add(new Pair('c', c));
        int cnt = 0;
        while(!pq.isEmpty()){
            if(sb.isEmpty()){
                sb.append(pq.peek().ch);
                if(pq.peek().freq-1 == 0){
                    pq.poll();
                } else{
                    pq.peek().freq = pq.peek().freq-1;
                }
                cnt++;
            } else{
                if(pq.peek().ch == sb.charAt(sb.length()-1)){
                    if(cnt==2){
                        Pair p = pq.poll();
                        if(pq.isEmpty()) break;
                        else{
                            sb.append(pq.peek().ch);
                            if(pq.peek().freq-1 == 0){
                                pq.poll();
                            } else{
                                pq.peek().freq = pq.peek().freq-1;
                            }
                            pq.add(p);
                        }
                        cnt = 1;
                    } else{
                        cnt++;
                        sb.append(pq.peek().ch);
                        if(pq.peek().freq-1 == 0){
                            pq.poll();
                        } else{
                            pq.peek().freq = pq.peek().freq-1;
                        }
                    }
                } else{
                    sb.append(pq.peek().ch);
                    if(pq.peek().freq-1 == 0){
                        pq.poll();
                    } else{
                        pq.peek().freq = pq.peek().freq-1;
                    }
                    cnt = 1;
                }
            }
        }
        return sb.toString();
    }
}