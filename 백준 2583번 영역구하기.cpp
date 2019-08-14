#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#define endl '\n'
using namespace std;
int count123;
int n,m,k;
int grid[101][101];
bool visited[101][101];
vector<int> v;
class dir{
	public:
		int x,y;
};
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
void dfs(int x1,int y1)
{
	visited[x1][y1]=true;
	count123++;
	for(int i=0; i<4; i++)
	{
		int curx(x1+quad[i].x);
		int cury(y1+quad[i].y);
		if(0<=cury&&0<=curx&&curx<m&&cury<n)
		{
			if(!grid[curx][cury]&&!visited[curx][cury])
				dfs(curx,cury);
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>m>>n>>k;
	for(int i=0; i<k; i++)
	{
		int a,b,c,d;
		cin>>a>>b>>c>>d;
		for(int j=b; j<d; j++)
		{
			for(int k=a; k<c; k++)
				grid[j][k]=1;
		}
	}
	for(int i=0; i<m; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(!grid[i][j]&&!visited[i][j])
			{
				count123=0;
				dfs(i,j);
				v.push_back(count123);
			}
		}
	}
	sort(v.begin(),v.end());
	cout<<v.size()<<endl;
	for(int i=0; i<v.size(); i++)
		cout<<v[i]<<" ";
	
}
