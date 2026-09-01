class Solution {
    public int orangesRotting(int[][] grid) {
        int ones=0;
        Deque<int[]> q=new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==1) ones++;
                if (grid[i][j]==2) q.offer(new int[]{i,j});
            }
        }
        if (ones==0) return 0;
        int[] row={1,0,-1,0};
        int[] col={0,1,0,-1};

        int mins=0;

        while (!q.isEmpty()) {
            int size= q.size();
            boolean rotten =false;
            for (int j = 0; j < size; j++) {
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + row[i];
                    int nc = c + col[i];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        ones--;
                        rotten=true;
                    }
                }
            }
            if (rotten) mins++;
        }
        return ones>0? -1:mins;
    }
}
