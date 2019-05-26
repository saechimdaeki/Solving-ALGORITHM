#include<iostream>
#include<algorithm>
using namespace std;

int main()
{
	int n;
	cin>>n;
	long long arr[n];
	long long sum(0);
	for(int i=0; i<n; i++)
	cin>>arr[i];
	sort(arr,arr+n);
	for(int i=0; i<n; i++)
	for(int j=i+1; j<n; j++)
	sum+=arr[j]-arr[i];
	cout<<sum*2;
}
