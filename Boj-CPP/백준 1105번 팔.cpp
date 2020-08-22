#include<iostream>
#include<algorithm>
using namespace std;
string l,r;
long long answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>l>>r;
	if(l.length()==r.length())
	{
		bool is=false;
		for(int i=0; i<l.length(); i++)
		{
			if(l[i]!=r[i])
			is=true;
			if(is)
			continue;
			if(l[i]==r[i]&&l[i]=='8')
			answer++;
		}
	}
	cout<<answer;
}
