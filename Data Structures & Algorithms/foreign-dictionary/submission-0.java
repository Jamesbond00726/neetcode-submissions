class Solution {
    public String foreignDictionary(String[] words) {
      int n = 26;
		
		// Which characters actually exist?
		boolean[] present = new boolean[n];
		
		for (String word : words) {
			for (char c : word.toCharArray()) {
				present[c - 'a'] = true;
			}
		}
		
		// Create graph
		List<List<Integer>> adj = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		
		// Build edges
		for (int i = 0; i < words.length - 1; i++) {
			
			String s1 = words[i];
			String s2 = words[i + 1];
			if (s1.length() > s2.length() && s1.startsWith(s2)) {
				return "";
			}
			
			int len = Math.min(s1.length(), s2.length());
			
			for (int j = 0; j < len; j++) {
				
				if (s1.charAt(j) != s2.charAt(j)) {
					
					int u = s1.charAt(j) - 'a';
					int v = s2.charAt(j) - 'a';
					
					adj.get(u).add(v);
					
					break;
				}
			}
		}
		
		List<Integer> list = topologicalSort(adj, n, present);
		
		// Cycle / invalid ordering
		int characterCount = 0;
		
		for (boolean exists : present) {
			if (exists) {
				characterCount++;
			}
		}
		
		if (list.size() != characterCount) {
			return "";
		}
		
		// Build answer
		StringBuilder ans = new StringBuilder();
		
		for (int it : list) {
			ans.append((char) (it + 'a'));
		}
		
		return ans.toString();
	}
	private List<Integer> topologicalSort(List<List<Integer>> adj, int V, boolean[] present) {
		
		int[] indegree = new int[V];
		
		// Calculate indegree
		for (int i = 0; i < V; i++) {
			for (int neighbour : adj.get(i)) {
				indegree[neighbour]++;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		// Add only existing characters
		for (int i = 0; i < V; i++) {
			if (present[i] && indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		
		while (!q.isEmpty()) {
			
			int node = q.poll();
			
			list.add(node);
			
			for (int neighbour : adj.get(node)) {
				
				indegree[neighbour]--;
				
				if (present[neighbour] && indegree[neighbour] == 0) {
					q.offer(neighbour);
				}
			}
		}
		
		return list;
		
	}
}
