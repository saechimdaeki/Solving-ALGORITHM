#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	int m(1),answer(0);
	while(true)
	{
		int a(m),b(m);
		while(a)
		{
			b+=a%10;
			a/=10;
		}
		if(m==n || b==n)
			goto z;
		m++;
	}
	z:
		if(m==n)
		cout<<"0";
		else
		cout<<m;
}
