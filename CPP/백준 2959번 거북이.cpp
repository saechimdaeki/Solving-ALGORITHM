#include<iostream>
#include<algorithm> 
using namespace std; 
int arr[5];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<4; i++)
	cin>>arr[i];
	sort(arr,arr+4);
	cout<<arr[0]*arr[2]<<"\n";
}
