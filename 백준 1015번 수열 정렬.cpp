#include<iostream>
#include<algorithm>
#include<functional>
using namespace std;
int arr[50];
int n;
pair <int , int> v[50];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>v[i].first;
		v[i].second=i;
	}
	sort(v, v+n);
	
	for(int i=0; i<n; i++)
	arr[v[i].second]=i;
	for(int i=0; i<n; i++)
	cout<<arr[i]<<" ";
}
