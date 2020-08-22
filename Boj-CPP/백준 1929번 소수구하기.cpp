#include<iostream>
#include <cstdio>
#include <cstring>
using namespace std;
int arr[1000001];
int main()
{
	int m,n;
	cin>>m>>n;
	int count(0);
	for(int i=2; i<=n; i++)
	{
		if(arr[i]==1)
		continue;
		if(i>=m)
		{
			cout<<i<<"\n";
			count++;
		}
		
		for(long long a=(long long) i*i; a<=n; a+=i)
		arr[a]=1;
	}
	cout<<count;
}
