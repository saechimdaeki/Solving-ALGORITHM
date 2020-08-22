#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
#define endl '\n'
using namespace std;
vector<int > grid[20001];
int check[20001];  //0,1,2 를 집어넣음. 
int k,v,e;
bool status;
/* choibaekjoon inkang듣고   */
void dfs(int x, int y)
{
	check[x]=y;
	//인접리스트 순회 
	for(int i=0; i<grid[x].size(); i++)
	{
		int bts(grid[x][i]);
		if(check[bts]==0)
		dfs(bts,3-y);  //1->2, 2->1  1->(3-1)=2     2->(3-2)=1 이니까. 
	}
} 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>k;
	for(int i=0; i<k; i++)
	{
		cin>>v>>e;
		for(int j=1; j<=v; j++)
		grid[j].clear();
		memset(check,0,sizeof(check));
		for(int j=0; j<e; j++)
		{
			int a,b;
			cin>>a>>b;
			grid[a].push_back(b);
			grid[b].push_back(a);
		}
		for(int j=1; j<=v; j++)
		{
			if(check[j]==0)
			dfs(j,1);
		}
		status=true;
		for(int j=1; j<=v; j++)
		{
			for(int k=0; k<grid[j].size(); k++)
			{
				int bts(grid[j][k]);
				if(check[j]==check[bts])
				status=false;
			}
		}
		if(status)
		cout<<"YES"<<endl;
		else
		cout<<"NO"<<endl;
	}
	
}
