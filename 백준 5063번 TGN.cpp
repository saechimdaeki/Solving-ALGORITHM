#include<iostream>
#include<algorithm>
using namespace std;
int n;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int r,e,c;
		cin>>r>>e>>c;
		if(r+c<e)
		cout<<"advertise\n";
		else if(r+c>e)
		cout<<"do not advertise\n";
		else
		cout<<"does not matter\n";
		
	}
}
