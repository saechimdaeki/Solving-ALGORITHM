#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int> v;
int arr[10];
int count123;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(10);
	for(int i=0; i<10; i++)
	cin>>v[i];
	
	for(int i=0; i<10; i++)
	arr[i]=v[i]%42;
	
	sort(arr,arr+10);
	for(int i=0; i<10; i++)
	{
		if(arr[i]!= arr[i+1])
		count123++;
	}
	cout<<count123;
}

