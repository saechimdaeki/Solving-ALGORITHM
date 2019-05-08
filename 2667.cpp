#include<cstdio>
#include<algorithm>
#include<queue>
#include<utility>
#include<tuple>
#include<vector>

using namespace std;

int n;
int map[25][25];

int dx[]={1,-1,0,0};
int dy[]={0,0,1,-1};

int BFS(int i, int j){
	queue<pair<int, int> > q;
	
	q.push({i, j});
	map[i][j]=0;
	
	int cnt=1;
	while(!q.empty())
	{
		tie(i, j)=q.front(); q.pop();
		
		for(int d=0; d<4; ++d)
		{
			int _i=i+dx[d], _j=j+dy[d];
			if(0<=_i&&_i<n && 0<=_j&&_j<n \
			&& map[_i][_j]!=0 )
			{
				q.push({_i, _j});
				map[_i][_j]=0;
				cnt++;
			}
		}
	}
	return cnt;
}

int main(){
	scanf("%d", &n);
	
	for(int i=0; i<n; ++i)
		for(int j=0; j<n; ++j)
			scanf("%1d", &map[i][j]);
	
	vector<int> v;
	for(int i=0; i<n; ++i) 
		for(int j=0; j<n; ++j)
			if(map[i][j]==1) v.push_back(BFS(i, j));
	
	printf("%d\n", v.size());
	
	sort(v.begin(), v.end());
	
	for(int& i: v) printf("%d\n", i);
}
