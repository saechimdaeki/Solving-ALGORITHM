#include<iostream>
#include<algorithm>
using namespace std;
int n,m,answer;
bool nochoice[201][201];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<m; i++)
	{
		int a,b;
		cin>>a>>b;
		nochoice[a][b]=nochoice[b][a]=true;		
	}		
	for(int i=1; i<=n-2; i++)
	{
		for(int j=i+1; j<=n-1; j++)
		{
			for(int k=j+1; k<=n; k++)
			{
				if(nochoice[i][j]||nochoice[j][k]||nochoice[k][i])
				continue;
				answer++;
			}
		}
	}
	cout<<answer;
}
