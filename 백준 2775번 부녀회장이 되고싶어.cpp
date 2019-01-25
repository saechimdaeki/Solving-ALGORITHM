#include<iostream>
using namespace std;
int boonyu[15][15];
int main()
{
	int n;
	cin>>n;
	int n2,k;
	boonyu[0][0]=1;
	for(int i=1; i<15; i++)
	{
		boonyu[0][i]=i+1;
		boonyu[i][0]=1;
	}
	for(int i=1; i<15; i++)
	{
		for(int j=1; j<15; j++)
		{
			boonyu[i][j]=boonyu[i][j-1]+boonyu[i-1][j];
		}
	}
	
	for(int i=0; i<n; i++)
	{
		cin>>n2>>k;
		cout<<boonyu[n2][k-1]<<endl;
	}
}
