package programmers.notool_단어_변환;

import java.util.*;

class Solution {
	static List<Integer> arr;
	static boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		arr = new ArrayList<>();

		dfs(begin, target, words, 0);
		if (arr.size() == 0)
			return 0;
		Collections.sort(arr);
		return arr.get(0);
	}

	public void dfs(String begin, String target, String[] words, int cnt) {
		if (begin.equals(target)) {
			arr.add(cnt);
			return;
		}
		if (cnt > words.length)
			return;
		for (int i = 0; i < words.length; i++) {
			if (!visited[i] && similar(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, cnt + 1);
				visited[i] = false;
			}
		}
	}

	public boolean similar(String begin, String word) {
		int cnt = 0;
		for (int i = 0; i < word.length(); i++) {
			if (begin.charAt(i) != word.charAt(i))
				cnt++;
		}
		return cnt == 1;
	}
}