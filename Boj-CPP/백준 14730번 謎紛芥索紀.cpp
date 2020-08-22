#include<iostream>
using namespace std;
int n,sum,c,k;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>c>>k;
		sum+=c*k;
	}
	cout<<sum;
}
