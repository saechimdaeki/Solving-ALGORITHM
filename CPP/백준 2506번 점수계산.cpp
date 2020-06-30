#include<iostream>
using namespace std;

int main()
{
	int n,m;
	cin>>n;
	int sum(0),continuity(0);
 
	for(int i=0; i<n; i++)
	{
		cin>>m;
		if(m==1)
		{
			continuity++;
			sum+=continuity;
		}
		else continuity=0;
	}
	cout<<sum;
}
