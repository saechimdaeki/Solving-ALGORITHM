#include<iostream>
#include<cmath>
using namespace std;
int m,n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>m>>n;
	int flag(0),sum(0),min(0);
	for(int i=m; i<=n; i++)
	{
		if(i==((int)sqrt(i)*sqrt(i)))
		{
			sum+=i;
			if((flag==0)&&i!=0)
			{
				flag=1;min=i;
			}
		}
	}
	if(flag==0)
	cout<<"-1";
	else
	cout<<sum<<"\n"<<min;
	
}
