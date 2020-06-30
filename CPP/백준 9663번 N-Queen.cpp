#include<iostream>
using namespace std;
int answer;
bool check[16][16];
int n;
bool checking(int row, int cal)
{
	for(int i=0; i<n; i++)
	{
		if(i==row)
		continue;
		if(check[i][cal])
		return false;
	}
	int x(row-1),y(cal-1);
	while(x>=0 && y>=0)
	{
		if(check[x][y])
		return false;
		x--;y--;	
	}
	x=row-1; y=cal+1;
	while(x>=0 && y<n)
	{
		if(check[x][y])
		return false;
		x--; y++;
	}
	return true;
	
	
}

void solve(int row)
{
	if(row==n)
	answer++;
	for(int i=0; i<n; i++)
	{
		check[row][i]=true;
		if(checking(row,i))
		solve(row+1);
		check[row][i]=false;
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	solve(0);
	cout<<answer;
}
