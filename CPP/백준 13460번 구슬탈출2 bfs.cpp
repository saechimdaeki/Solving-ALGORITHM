#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#include<tuple>
using namespace std;
int n,m,cnt;
/* 왜 이거쓰면 틀린지 이해불가임.  
typedef struct{
	int x, y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,-1},{0,1}};
*/
queue<pair<int, int> > red;
queue<pair<int, int > > blue;
int redx,redy,bluex,bluey,goalx,goaly;
string input;
bool visited[11][11][11][11]; //redx, redy, bluex, bluey 순서임. 
char board[11][11];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
bool timetoanswer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		cin>>input;
		for(int j=0; j<m; j++)
		{
			board[i][j]=input[j];
			if(board[i][j]=='B')
			{
				blue.push({i,j});
				bluex=i,bluey=j;
			}
			if(board[i][j]=='R')
			{
				red.push({i,j});
				redx=i,redy=j;
			}
			if(board[i][j]=='O')
			{
				goalx=i;
				goaly=j;
			}
		}
	}
	visited[redx][redy][bluex][bluey]=true;
	while(!red.empty())
	{
		int qsize(red.size());//이조건은 솔루션을 봤음 
		while(qsize--)
		{
		redx=red.front().first;
		redy=red.front().second;
		bluex=blue.front().first;
		bluey=blue.front().second;
		red.pop();blue.pop();
		if(cnt>10)
		break;
		if(redx==goalx && redy==goaly)
		{
			timetoanswer=true;
			break;
		}
		for(int i=0; i<4; i++)
		{
			    
				int nredx = redx + dx[i];
                int nredy = redy + dy[i];
                int nbluex = bluex + dx[i];
                int nbluey = bluey + dy[i];
                while (1)
                {
                    if (board[nredx][nredy] == '#') {
                        nredx -= dx[i]; nredy -= dy[i];
                        break;
                    }
                    if (board[nredx][nredy] == 'O') break;
                    nredx += dx[i]; nredy += dy[i];
                }
                while (1)
                {
                    if (board[nbluex][nbluey] == '#') {
                        nbluex -= dx[i]; nbluey -= dy[i];
                        break;
                    }
                    if (board[nbluex][nbluey] == 'O') break;
                    nbluex += dx[i]; nbluey += dy[i];
                }
                
			if(nbluex==goalx && nbluey==goaly)
			continue;
			 if (nredx == nbluex && nredy == nbluey)
                {
                    switch (i){
                    case 0: redx > bluex ? nredx++ : nbluex++; break;
                    case 1: redx < bluex ? nredx-- : nbluex--; break;
                    case 2: redy > bluey ? nredy++ : nbluey++; break;
                    case 3: redy < bluey ? nredy-- : nbluey--; break;
                    }
                }
                if(visited[nredx][nredy][nbluex][nbluey])
                continue;
                red.push({nredx,nredy});
                blue.push({nbluex,nbluey});
                visited[nredx][nredy][nbluex][nbluey]=true;
		}
	}
		if(timetoanswer)
		break;
		else
		cnt++;
	}
	if(timetoanswer)
	cout<<cnt;
	else
	cout<<-1;
} 
