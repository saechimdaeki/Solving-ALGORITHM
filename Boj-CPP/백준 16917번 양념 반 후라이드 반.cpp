#include<iostream>
using namespace std;
int a,b,c,x,y;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>c>>x>>y;
	int ans=x*a+y*b;
	for(int i=1; i<=100000; i++)
	{
		int miniprice=2*i*c + max(0,x-i)*a+ max(0,y-i)*b;
		if(ans>miniprice)
		ans=miniprice; 
	}
	cout<<ans;
}
