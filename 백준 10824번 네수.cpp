#include<iostream>
#include<algorithm>
using namespace std;
long long sum; 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	string a,b,c,d;
	cin>>a>>b>>c>>d;
	a+=b;
	c+=d;
	long long s1(stoll(a));
	long long s2(stoll(c));
	sum=s1+s2;
	cout<<sum<<"\n";
}
