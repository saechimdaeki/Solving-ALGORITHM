#include<iostream>
#include<algorithm>
#include<cstdio>
#include<cstring>
#include<queue>
#include<map>
#include<tuple>
#include<vector>

using namespace std;

vector<pair<int, int>> VirusVector;
vector<pair<int, int>> LandVector;
vector<int> ResultVector;
map<pair<int, int>, bool> m;

int N, M;
int grid[8][8];
int paper[8][8];
int visited[8][8];

int dx[]={1,-1,0,0};
int dy[]={0,0,1,-1};

enum{land=0, wall, virus};

int spread(int i, int j, int s){
	queue<pair<int, int> > q;
	
	q.push({i, j});
	visited[i][j]=1;
	
	int cnt=1;
	while(!q.empty())
	{
		tie(i, j)=q.front(); q.pop();
		for(int d=0; d<4; ++d)
		{
			int _i=i+dx[d], _j=j+dy[d];
			if(0<=_i&&_i<N && 0<=_j&&_j<M && paper[_i][_j]==land && visited[_i][_j]==false)
			{
				if(s==virus) paper[_i][_j]=virus;
				else paper[_i][_j]=5;
				q.push({_i, _j});
				visited[_i][_j]=true;
				cnt++;
			}
		}
	}
	return cnt;
}

void build_wall(int Idx, int depth)
{
	if(depth==3){
		for(int i=0; i<N; ++i) for(int j=0; j<M; ++j) paper[i][j]=grid[i][j];
		for(auto& p: m)
			if(p.second)
				paper[p.first.first][p.first.second]=1;
		
		for(auto& v: VirusVector) spread(v.first, v.second, virus);

		int result=0;
		for(int i=0; i<N; ++i)
			for(int j=0; j<M; ++j)
				if(paper[i][j]==0) result+=1;
		ResultVector.push_back(result);
		
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				visited[i][j]=0;
			}
		}
		return;
	}
	
	for(int i=Idx; i<LandVector.size(); ++i){
		pair<int, int> &p = LandVector[i];
		if(m[p]) continue;
		m[p]=true;
		build_wall(i, depth+1);
		m[p]=false;
	}
}

int main(){
	scanf("%d %d", &N, &M);
	
	for(int i=0; i<N; ++i){
		for(int j=0; j<M; ++j){
			scanf("%d", &grid[i][j]);
			if(grid[i][j]==2) VirusVector.push_back({i, j});
			else if(grid[i][j]==0) LandVector.push_back({i, j});
		}
	}
	build_wall(0, 0);
	
	printf("%d", *max_element(ResultVector.begin(), ResultVector.end()));
}
