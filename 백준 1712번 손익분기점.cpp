#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;
int a,b,c;
int count123;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>c;
	if(c-b<=0)
	cout<<"-1";
	else
	cout<<a/(c-b)+1;
}
