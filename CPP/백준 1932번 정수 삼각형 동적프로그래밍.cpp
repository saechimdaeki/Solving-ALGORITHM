#include<iostream>
using namespace std;

int max(int a, int b)
{
	return a>b ? a: b;
}

int arr[500][500];
int dynamic[500][500];
	
int main()
{
	int n;
	cin>>n;
	int ac(0);
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=i;j++)
			cin>>arr[i][j];	
	}	
	
	for(int i=0; i<=n; i++)
	{
		for(int j=1; j<=i; j++)	
		{
		dynamic[i][j]=arr[i][j]+max(dynamic[i-1][j],dynamic[i-1][j-1]);
		if(dynamic[i][j]>ac)
		ac=dynamic[i][j];
		}
	}
	
	printf("%d",ac);
}
