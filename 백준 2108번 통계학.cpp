#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;
int arr[500000];
int most[500000];
int count[500000];
int main()
{
	double sum(0);
	int n,hangae(0),check(0),manysoo(0);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>arr[i];
		sum+=double(arr[i]);
		most[(arr[i]+4000)]++;
		
	}
	for(int i=0; i<n; i++)
	{
		if(hangae<most[arr[i]+4000])
			hangae=most[arr[i]+4000];
	}
	for(int i=0; i<8001; i++)
	{
		if(check==0 && hangae==most[i])
		{
			check=1;
			manysoo=i-4000;
		}
		else if(check==1 &&hangae==most[i])
		{
			manysoo=i-4000;
			break;
		}
	}
	cout<<floor(sum/n+0.5)<<endl;
	sort(arr,arr+n);
	cout<<arr[n/2]<<endl;
	cout<<manysoo<<endl;
	cout<<(arr[n-1]-arr[0])<<endl;
}
