#include<iostream>
#include<algorithm>
using namespace std;
int bonus;
int sum,n;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	cin>>s;
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]=='O')
		{
			sum+=i+1+bonus;
			bonus++;	
		}
		else
		{
			bonus=0;
		}
	}
	cout<<sum;
}
