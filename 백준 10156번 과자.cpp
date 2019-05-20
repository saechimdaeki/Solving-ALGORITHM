#include<iostream>
#include<algorithm>
using namespace std;
int k,n,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>k>>n>>m;
	if(k*n>m)
	cout<<k*n-m<<"\n";
	else
	cout<<"0"<<"\n";
}
