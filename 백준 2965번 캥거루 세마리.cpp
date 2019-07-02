#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;
int k1,k2,k3;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>k1>>k2>>k3;
	if(k2-k1>k3-k2)
	cout<<k2-k1-1;
	else
	cout<<k3-k2-1;

	
}
