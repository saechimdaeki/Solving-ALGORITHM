#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
string s;
vector<int> n,sign;
bool mi=false;
int savenum;
int answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	sign.push_back(1);
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]=='+'|| s[i]=='-')
		{
			if(s[i]=='+')
			sign.push_back(1);
			else
			sign.push_back(-1);
			n.push_back(savenum);
			savenum=0;	
		}else{
			savenum=savenum*10+(s[i]-'0');
		}	
	}
	n.push_back(savenum);
	for(int i=0; i<n.size();i++)
	{
		if(sign[i]==-1)
		mi=true;
		if(mi)
		answer-=n[i];
		else
		answer+=n[i];
	}
	cout<<answer;
}
