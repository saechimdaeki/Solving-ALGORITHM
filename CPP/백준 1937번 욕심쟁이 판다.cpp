#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
const int MAX = 501;
int n;
int tree[MAX][MAX];
int life[MAX][MAX];
typedef struct {
	int i, j;
}Move;
Move m[4] = { {0,1}, {0,-1}, {1,0},{-1,0} };
int pandalife(int x,int y) {
	int &days = life[x][y];
	if (days != -1)
		return days;
	days = 1;
	for (int k = 0; k < 4; k++) {
		int mx = x + m[k].i;
		int my = y + m[k].j;
		if (mx >= 0 && my >= 0 && mx < n && my < n && (tree[x][y] < tree[mx][my])) {
			days = max(days,(pandalife(mx,my) + 1));
		}
	}
	return days;
}
int main(void) {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> tree[i][j];
		}
	}
	memset(life, -1, sizeof(life));
	int answer = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int lifetime = pandalife(i, j);
			answer = max(answer,lifetime);
		}
	}
	cout << answer << endl;
	return 0;
}
