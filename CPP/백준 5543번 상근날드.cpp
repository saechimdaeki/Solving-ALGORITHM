#include<iostream>
#include<algorithm>
using namespace std;
int arr[3];
int arr2[2];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<3; i++)
	cin>>arr[i];
	for(int i=0; i<2; i++)
	cin>>arr2[i];
	
	sort(arr,arr+3);sort(arr2,arr2+2);
	cout<<arr[0]+arr2[0]-50;
}
