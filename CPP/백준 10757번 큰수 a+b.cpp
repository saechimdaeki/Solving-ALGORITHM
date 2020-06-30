#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

string abcplusplus(string &a,string &b)
{
	string bts(max(a.size(),b.size()),'0');
	int forever(0);
	for(int i=0; i<bts.size(); i++)
	{
		int os=forever;
		forever=0;
		if(i<a.size())
		os+=a[a.size()-i-1]-'0';
		if(i<b.size())
		os+=b[b.size()-i-1]-'0';
		if(os>=10)
		{
			forever++;
			os-=10;
		}
		bts[bts.size()-i-1]=os+'0';
	}
	if(forever)
	bts.insert(bts.begin(),'1');
	
	return bts;
}

int main()
{
	string a,b;
	cin>>a>>b;
	string btsforever=abcplusplus(a,b);
	cout<<btsforever<<endl;
	
}

