#include<iostream>
#include<algorithm>
using namespace std;
int n,k;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;	
	long long arr[n];
	for(int i=0; i<n; i++)
	cin>>arr[i];
	sort(arr,arr+n);
	cout<<arr[k-1];
}


