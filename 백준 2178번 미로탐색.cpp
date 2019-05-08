#include<iostream>
#include<queue>
#include<cstring>
#define max 100
using namespace std;

int n,m;
int maze[max][max];
bool visited[max][max];

typedef struct{
	int y,x,path;
}dir;

int minstep(int y, int x, int path)
{
	queue<dir> q;
	int result=0;
	dir start={y,x, path};
	q.push(start);
	
	while(!q.empty())
	{
		int cury=q.front().y;
		int curx=q.front().x;
		
		int curlen=q.front().path;
		
		if(curx==m-1 &&cury==n-1)
		{
			result=curlen;
			break;
		}
		q.pop();
		visited[y][x]=true;
		
		//오른쪽 
		if(curx+1 < m &&maze[cury][curx+1]&& !visited[cury][curx+1])
		{
			dir right={cury, curx+1, curlen+1};
			visited[cury][curx+1]=true;
			q.push(right);
		 } 
		 //왼쪽 
		 if(curx-1 >=0 && maze[cury][curx-1]&& !visited[cury][curx-1])
		 {
		 	dir left={cury, curx-1, curlen+1};
		 	visited[cury][curx-1]=true;
		 	q.push(left);
		 }
		 //아래쪽
		 if(cury+1 < n && maze[cury+1][curx]&& !visited[cury+1][curx])
		 {
		 	dir down={cury+1, curx, curlen+1};
		 	visited[cury+1][curx]=true;
		 	q.push(down);
		  } 
		  //위쪽 
		  if(cury-1 >=0 &&maze[cury-1][curx] && !visited[cury-1][curx])
		  {
		  	dir up={cury-1, curx, curlen+1};
		  	visited[cury-1][curx]=true;
		  	q.push(up);
		  }
	}
	return result;
}
int main()
{
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		string abc;
		cin>>abc;
		for(int j=0; j<m; j++)
			maze[i][j]=abc[j]-'0';
	}

	cout<<minstep(0,0,1);
}
