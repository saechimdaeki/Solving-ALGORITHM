#include<iostream>
#include<queue>
using namespace std;
int n,m;
int count;
int cheez[101][101];
int next_magma[101][101];

int circuit_x[4]={0,1,0,-1};
int circuit_y[4]={-1,0,1,0};

void external(int n1,int n2)
{
	if(0<=n1 && n1<m && 0<=n1 && n1 <=n)
	{
		if(cheez[n1][n2]==0)
		{
			cheez[n1][n2]=2;
			for(int i=0; i<4; i++)
			{
			int bts(n1+circuit_y[i]);
			int forever(n2+circuit_x[i]);
			external(bts,forever);
			}
		}
	}
}
void now_magma()
{
	for(int i=0; i<m; i++)
	{
		for(int j=0; j<n; j++)
		{
		
		if((cheez[i][j]==1)&&next_magma[i][j])
		cheez[i][j]=2;
		count++;
		for(int a=0; a<4; a++)
		{
			int bts(i+circuit_y[a]);
			int forever(j+circuit_x[a]);
			external(bts,forever);
		}
	}
	}
}
int all_magma()
{
	for(int i=0; i<m; i++)
	{
		for(int j=0; j<n; j++)
		if(cheez[i][j]==1)
		return 0;
	}
	return 1;
}


int main()
{
	
	cin>>m>>n;
	for(int i=0; i<m; i++)
	{
		for(int j=0; j<n; j++)
		cin>>cheez[i][j];
	}
	cout<<count<<endl;
}
