#include<iostream>
#include<algorithm>
using namespace std;
int arr[4];
int main()
{
	
	int a,b;
	int zeta(0);
	int maxi(0);
	for(int i=0; i<4; i++)
	{
		cin>>a>>b;
		zeta+=b-a;
		arr[i]=zeta;
		maxi=max(arr[i],maxi);
	}
	cout<<maxi;
}
