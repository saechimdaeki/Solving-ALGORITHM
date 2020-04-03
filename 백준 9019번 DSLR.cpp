#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#include<cstring>
#define endl '\n'
using namespace std;
int t;
int a,b;
bool visited[10001];
int dist[10001],start[10001];
char methodsave[10001];
void bfs(int sp, int ep)
{
	queue<int> q;
	visited[sp]=true;
	dist[sp]=0;
	q.push(sp);
	while(!q.empty())
	{
		int cur(q.front());
		q.pop();
		if(cur==ep)
		return; 
		//D연산
		int next=(cur*2)%10000; 
		if(!visited[next])
		{
			q.push(next);
			visited[next]=true;
			dist[next]=dist[cur]+1;
			methodsave[next]='D';
			start[next]=cur; 
		}
		//s연산 
		next=cur-1;
		if(next==-1) next=9999;
		if(!visited[next])
		{
			q.push(next);
			visited[next]=true;
			dist[next]=dist[cur]+1;
			methodsave[next]='S';
			start[next]=cur;	
		}
		//L연산 
		next=(cur%1000)*10+(cur/1000);
		if(!visited[next])
		{
			q.push(next);
			visited[next]=true;
			dist[next]=dist[cur]+1;
			methodsave[next]='L';
			start[next]=cur;
		}
		//R연산	
		next=(cur/10)+(cur%10)*1000;
		if(!visited[next])
		{
			q.push(next);
			visited[next]=true;
			dist[next]=dist[cur]+1;
			methodsave[next]='R';
			start[next]=cur;
		}
	}	
}

void output()
{
	string answer="";
	while(b!=a)
	{
		answer+=methodsave[b];
		b=start[b];
	}
	reverse(answer.begin(),answer.end()); 
	cout<<answer;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	while(t--)
	{
	
		cin>>a>>b;
		memset(visited,false,sizeof(visited));
		memset(dist,0,sizeof(dist));
		memset(start,0,sizeof(start));
		memset(methodsave,0,sizeof(methodsave));
		bfs(a,b);
		output();
		cout<<endl;
	}
}
