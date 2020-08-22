#include<iostream>
#include<algorithm>
using namespace std;

long long dynamic[100001];
long long arr[100001];
long long bts(0);


int main()
{
	int n;
	cin>>n;
	for(int i=0; i<n; i++)
	cin>>arr[i];
	for(int i=1; i<n; i++)
	{
		dynamic[i]=max(dynamic[i-1]+arr[i],arr[i]);
		bts=max(dynamic[i],bts);
	}
	cout<<bts<<endl;
}



