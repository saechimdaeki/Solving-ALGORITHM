#include<iostream>
#include<algorithm>
using namespace std;
int arr[6];
int n,sum;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<5; i++)
	{
		cin>>arr[i];
		if(arr[i]==n)
		sum++;	
	}
	cout<<sum;
	
	
}
