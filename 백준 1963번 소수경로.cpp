#include<iostream>
#include<algorithm>
#include<tuple>
#include<vector>
#include<cmath>
#include<queue>
#include<cstring>
#define endl '\n'
using namespace std;
int t;
bool sosoopossible[10001];
bool visited[10001];
int dist[10001];
int possible;
int change(int num, int idx, int digit)
{
	if(idx==0 && digit==0)return -2e9;
	string tmp=to_string(num);
	tmp[idx]=digit+'0';
	return stoi(tmp);
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=2; i<=10000; i++)
	{
		if(!sosoopossible[i])
		{
			for(int j=i*i; j<=10000; j+=i)
			sosoopossible[j]=true;
		}
	}
	for(int i=0; i<=10000; i++)
	sosoopossible[i]= !sosoopossible[i];
	cin>>t;
	while(t--)
	{
		int a,b;
		cin>> a>>b;
		possible=false;
		memset(dist,-1,sizeof(dist));
		memset(visited,false,sizeof(visited));
		visited[a]=true;
		dist[a]=0;
		queue<int> q;
		q.push(a);
		while(!q.empty())
		{
			int cur(q.front());
			q.pop();
			for(int i=0; i<4; i++)
			{
				for(int j=0; j<10; j++)
				{
					int nextpoint(change(cur,i,j));
					if(nextpoint!=-2e9)
					{
						if(sosoopossible[nextpoint]&&!visited[nextpoint])
						{
							possible=true;
							q.push(nextpoint);
							dist[nextpoint]=dist[cur]+1;
							visited[nextpoint]=true;
						}
					}
				}
			}
		}
		if(possible)
		cout<<dist[b]<<endl;
		else
		cout<<"Impossible"<<endl;
	}
}
