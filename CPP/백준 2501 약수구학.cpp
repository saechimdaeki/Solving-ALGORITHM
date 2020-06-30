#include<iostream>
using namespace std;
int n,k;
int num;
int ans; 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	for(int i=1; i<=n; i++)
	{
		if(n%i==0)
		{
			num++;
			if(num==k)
			{
				ans=i;
				goto z;
			}		
		}
		ans=0;
	}
	z:
	cout<<ans;
}
