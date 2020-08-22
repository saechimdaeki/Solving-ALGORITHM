#include<cstdio>
#include<algorithm>
#include<queue>
#include<utility>
#include<vector>
#include<map>

using namespace std;

int N, M;
int grid[20][20];
int visited[20][20];

int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

map<pair<int, int>, bool> m;
vector<int> ResultVector;
vector<pair<int, int>> CityVector;
vector<pair<int, int>> LandVector;
vector<pair<int, int>> choose;

enum{land=0, city, poison};

int spread(pair<int, int>& p1, pair<int, int>& p2){
	queue<pair<int, int> > q;
   
	q.push(p1);
	q.push(p2);
	visited[p1.first][p1.second]=true;
	visited[p2.first][p2.second]=true;
	
	int tick=0, contaminated=0, i ,j;
	while(contaminated!=CityVector.size())
	{
		tick++;
		int qsz = q.size();
		for(int drv=0; drv<qsz; ++drv)
		{
			tie(i, j) = q.front();
			q.pop();
			for(int d=0; d<4; ++d)
		  	{
				int _i=i+dx[d], _j=j+dy[d];
				
				if(0<=_i&&_i<N && 0<=_j&&_j<M && visited[_i][_j]==false)
				{
					if(grid[_i][_j]==city) contaminated++;
		        	q.push({_i, _j});
		        	visited[_i][_j]=true;
				}
			}
		}
	}
	
	return tick;
}

void run(int Idx, int depth)
{
	if(depth==2){
		int i=0;
	  	for(auto it=m.begin();  i<2; ++it)
			if(it->second == true) choose[i++] = it->first;
		
		ResultVector.push_back(spread(choose[0], choose[1]));
		
		for(int i=0; i<N; ++i)
		{
			for(int j=0; j<M; ++j)
			{
				visited[i][j] = false;
			}
		}
		
		return;
	}
	
	for(int i=Idx; i<LandVector.size(); ++i)
	{
		pair<int, int> &p = LandVector[i];
		if(m[p]) continue;
		m[p]=true;
		run(i, depth+1);
		m[p]=false;
	}
}

int main(){
	choose.reserve(2);
	scanf("%d %d\n", &N, &M);
	
	for(int i=0; i<N; ++i)
	{
		for(int j=0; j<M; ++j)
		{
			scanf("%1d", &grid[i][j]);
	    	if(grid[i][j]==city) CityVector.push_back({i, j});
	     	else LandVector.push_back({i, j});
		}
	}
	
	run(0, 0);

	printf("%d", *min_element(ResultVector.begin(), ResultVector.end()));
}

