#include<iostream>
#include<algorithm>
using namespace std;
int n;
int a[51],b[51];
void ans(int num)
{
	a[1]=0,b[1]=1;
	a[2]=1,b[2]=1;
	a[3]=1,b[3]=2;
	for(int i=3; i<=num; i++)
		{
			a[i]=a[i-1]+a[i-2];
			b[i]=b[i-1]+b[i-2];	
		}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	ans(n);
	cout<<a[n]<<" "<<b[n];
}
