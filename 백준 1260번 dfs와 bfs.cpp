#include<iostream>
#include<queue>
#include<vector>
#include<stack>
#include<cstring>
int matrix[1001][1001];
bool visited[1001];
using namespace std;
queue<int> q;
int N,M,V;

void bfs(int n)
{
	q.push(n);
	visited[n]=true;
	while(!q.empty())
	{
		n=q.front();
		q.pop();
		
		cout<<n<<" ";
		for(int i=1; i<=N; i++)
			if(matrix[n][i]&& visited[i]==false)
			{
				visited[i]=true;
				q.push(i);
			}
	}
}





void dfs(int n)
{
	
	cout<<n<<" ";
	for(int i=1; i<=N; i++)
	{
		if(matrix[n][i]&& visited[i]==false)
		{
			visited[i]=true;
			dfs(i);
		}
	}
}


int main()
{
	cin>>N>>M>>V;
	visited[V]=true;
	while(M--)
	{
		int a,b;
		cin>>a>>b;
		matrix[a][b]=1;
		matrix[b][a]=1;
	}
	dfs(V); cout<<endl;
	for(int i=0; i<=1001; i++)
	visited[i]=false;

	bfs(V); cout <<endl;
}


