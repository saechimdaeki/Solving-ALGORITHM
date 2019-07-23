#include<iostream>
#include<algorithm>
using namespace std;
double n,b,m;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	while(cin>>n>>b>>m)
	{
		int count(0);
		double sum(0);
		sum+=n;
		while(1)
		{
			sum+=sum*b/100;
			count++;
			if(sum>m)
			goto z;
		}
		z:
		cout<<count<<"\n";		
	}
	
	
}
