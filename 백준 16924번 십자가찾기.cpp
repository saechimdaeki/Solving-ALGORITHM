#include<iostream>
#include<vector>
#include<tuple>
#define endl '\n'
using namespace std;
bool visited[101][101];
int n,m;
vector<string> v;
vector<tuple<int,int,int>> vt;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(v[i][j]=='*')
			{
				int tmp(0);
				for(int k=1; ; k++)
				{
					if(i+k<n && i-k >=0 && j+k<m && j-k>=0)
					{
						if(v[i+k][j]=='*'&&v[i-k][j]=='*'&&v[i][j+k]=='*'&&v[i][j-k]=='*')
						tmp=k;
						else
						break;
					}else
					break;
				}
				if(tmp>0)
				{
					vt.push_back(make_tuple(i+1,j+1,tmp));
					visited[i][j]=true;
					for(int k=1; k<=tmp; k++)
					{
						visited[i+k][j]=true;
						visited[i-k][j]=true;
						visited[i][j-k]=true;
						visited[i][j+k]=true;
					}
				}
			}
		}
	}
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(v[i][j]=='*'&&!visited[i][j])
			{
				cout<<-1;
				return 0;		
			}		
		}
	}	
	cout<<vt.size()<<endl;
	for(auto &t : vt)
	{
		int x,y,len;
		tie(x,y,len)=t;
		cout<<x<<' '<<y<<' '<<len<<endl;
	}
}
