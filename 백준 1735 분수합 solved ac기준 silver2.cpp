#include<iostream>
#define endl '\n'
using namespace std;
int a,b,c,d;
int gcd(int n1, int n2)
{
	if(n2>n1)
	return gcd(n2,n1);
	if(n1%n2==0)
	return n2;
	return gcd(n2, n1%n2);
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>c>>d;
	int under(b*d);
	int up=a*d+b*c;
	int gcdd(gcd(up,under));
	cout<<up/gcdd<<' '<<under/gcdd;
	
}
