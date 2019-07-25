#include<iostream>
#include<algorithm>
using namespace std;

string s;
int sum(10);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	char a=s[0];
	for(auto i: s)
	{
		if(a==i)
		sum+=5;
		else
		sum+=10;
		a=i;	
	}
	cout<<sum-5;
}
