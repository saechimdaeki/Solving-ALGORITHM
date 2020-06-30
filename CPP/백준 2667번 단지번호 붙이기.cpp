#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

typedef struct{
	int y,x;
}quad;

quad q[4]={{-1,0},{1,0},{0,-1},{0,1}};
bool visited[26][26];
string abcd[26];
int n,count123;
vector <int > v;

void dfs(int y , int x)
{
	count123++;
	visited[y][x]=true;
	for(int i=0; i<4; i++)
	{
		int quadx=x+q[i].x;
		int quady=y+q[i].y;
		if(0 <= quadx && quadx<n && 0<=quady &&quady<n)
		{
			if(abcd[quady][quadx]=='1' && visited[quady][quadx]==false)
			dfs(quady,quadx);
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	cin>>abcd[i];
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(visited[i][j]==false && abcd[i][j]=='1')
			{
				count123=0;
				dfs(i,j);
				v.push_back(count123);
			}
		}
	}
	sort(v.begin(),v.end());
	
	cout<<v.size()<<"\n";
	for(int i=0; i<v.size();i++)
	cout<<v[i]<<"\n";
}
