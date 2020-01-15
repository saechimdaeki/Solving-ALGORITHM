#include<iostream>
#include<algorithm>
#include<cstring>
#define endl '\n'
using namespace std;
int t;
int arr[10];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		memset(arr,0,sizeof(arr));
		for(int i=0; i<10; i++)
		cin>>arr[i];
		sort(arr,arr+10);
		reverse(arr,arr+10);
		cout<<arr[2]<<endl;
	}

}
