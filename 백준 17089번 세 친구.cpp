#include<iostream>
#include<algorithm>
using namespace std;
int arr[4001][4001];
int degree[4001];
int n,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<m; i++)
	{
		int a,b;
		cin>>a>>b;
		arr[a][b]=arr[b][a]=1;
		degree[a]++;
		degree[b]++;
	}
	int answer(-1);
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=n; j++)
		{
			if(arr[i][j])
			{
				for(int k=1; k<=n; k++)
				{
					if(arr[i][k]&&arr[j][k])
					{
						int sum(degree[i]+degree[j]+degree[k]-6);
						if(answer==-1||answer>sum)
						answer=sum;
					}
				}
			}
		}
	}
	cout<<answer;
}
