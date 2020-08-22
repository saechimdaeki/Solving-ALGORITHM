#include <iostream>
#include <queue>
#include <algorithm>
#define endl '\n'
#include<cstring>
using namespace std;
typedef struct
{
    int y,x;
}dir;
dir quad[8] = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, \
{1, -2}, {-1, -2}, {-2, -1} };
int t,l;
pair<int, int> p1, p2;
int grid[300][300];
bool visited[300][300];
queue<pair<int, int>> q;
void clearqueue(queue<pair<int,int>> &tempqueue)
{
	queue<pair<int,int>> empty;
	swap(tempqueue,empty);
}

int bfs(int y, int x)
{
        for(int i=0; i<300; i++)
        {
        	for(int j=0; j<300; j++)
        	grid[i][j]=987654321;
		}  
		clearqueue(q);
        q.push({y,x});
        grid[y][x] = 0;
        while (!q.empty())
        {
        	pair<int, int> cur(q.front());
            q.pop();
            if (cur.first == p2.first && cur.second == p2.second)
                return grid[cur.first][cur.second];
        	for (int i = 0; i < 8; i++)
            {
                int nexty(cur.first + quad[i].y);
                int nextx = cur.second + quad[i].x;
                if (0 <= nexty && nexty < l && 0 <= nextx && nextx < l)
                if (visited[nexty][nextx]==false)
                {
				 q.push({nexty,nextx});
                 visited[nexty][nextx] = true; 
                 grid[nexty][nextx]=min(grid[nexty][nextx],grid[cur.first][cur.second]+1);
                }
            }
        }
}
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin>>t;
        for (int i=0;i<t;i++)
        {
        	memset(visited,false,sizeof(visited));
		    cin>>l;
			cin>>p1.first>>p1.second;
            cin>>p2.first>>p2.second;
			cout<<bfs(p1.first,p1.second)<<endl;
        }
}
