#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int a,b,c;
int sum;
bool visited[1500][1500];
/* 백준센세 강의자료 참고.(dfs 이중for문 내실력으론 구상못했음)  */
void dfs(int x, int y)
{
	if(visited[x][y])
	return;
	visited[x][y]=true;
	int arr[3]={x,y,sum-x-y};
	for(int i=0; i<3; i++)
	{
		for(int j=0; j<3; j++)
		{
			if(arr[i]<arr[j])
			{
				int brr[3]={x,y,sum-x-y};
				brr[i]+=arr[i];
				brr[j]-=arr[i];
				dfs(brr[0],brr[1]);
			}
		}
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>c;
	sum=a+b+c;
	if(sum%3!=0)
	{
		cout<<0;
		return 0;
	}
	dfs(a,b);
	if(visited[sum/3][sum/3])
	cout<<1;
	else
	cout<<0;
}
