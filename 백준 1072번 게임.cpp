#include<iostream>
#include<algorithm>
using namespace std;
long long x,y,z,ans;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>x>>y;
	z=(y*100)/x;
	if(z>=99)
	{
		cout<<-1;
		return 0;
	}
	int left(0),right=(1000000000);
	while(left<=right)
	{
		int mid=(left+right)/2;
		int tmp=(100*(y+mid))/(x+mid);
		if(z>=tmp)
		{
			ans=mid+1;
			left=mid+1;
		}else{
			right=mid-1;
		}
	}
	cout<<ans;
	
}
