#include<iostream>
#include<vector>
#include<cstring>
#include<cmath>
#define endl '\n'
using namespace std;
typedef pair<int, int> pi; 
int t,n;
vector<int> v[102];
bool visited[102];

void dfs(int x)
{
	visited[x]=true;
	for(int i=0; i<v[x].size(); i++)
	{
		int cur(v[x][i]);
		if (!visited[cur])
		dfs(cur);
	}
}
int dist(pair<int, int> &p1, pair<int, int>  &p2)
{
	return abs(p1.first-p2.first)+\
	abs(p1.second-p2.second);
}



int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin>>t;
	for(int i=0; i<t; i++)
	{
		for(int j=0; j<102; j++)
		{
			v[j].clear();
			visited[j]=false;	
		}
		
		vector<pi> vv;
		//fill(vv.begin(),vv.end(),0);
		cin>>n;
		for(int j=0; j<n+2; j++)
		{
			int x,y;
			cin>>x>>y;
			vv.push_back(make_pair(x,y));
		}
		//cout<<"--------------check 1"<<endl;
		for(int j=0; j<n+2; j++)
		{
			for(int k=j+1; k<n+2; k++)
			{
				if(dist(vv[j],vv[k])<=1000)
				{
					v[j].push_back(k);
					v[k].push_back(j);
					}	
			}
		}
		//cout<<"----------------check2 "<<endl;
		dfs(0);
		if(visited[n+1]==true)
				cout<<"happy"<<endl;	
		else
			cout<<"sad"<<endl;
		
	
	}
}
