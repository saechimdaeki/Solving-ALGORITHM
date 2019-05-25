#include<iostream>
#include<algorithm>
#include<cmath>
#include<functional>
using namespace std;

pair<int ,long long > p[10];
long long value(1);
int saveforvalue[3];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<10; i++)
	{
		p[i].first=i;
		p[i].second=value;
		value*=10;
	}
	for(int i=0; i<3; i++)
	{
		string s;
		cin>>s;
		if(s=="black")
		saveforvalue[i]=0;
		else if(s=="brown")
		saveforvalue[i]=1;
		else if(s=="red")
		saveforvalue[i]=2;
		else if(s=="orange")
		saveforvalue[i]=3;
		else if(s=="yellow")
		saveforvalue[i]=4;
		else if(s=="green")
		saveforvalue[i]=5;
		else if(s=="blue")
		saveforvalue[i]=6;
		else if(s=="violet")
		saveforvalue[i]=7;
		else if(s=="grey")
		saveforvalue[i]=8;
		else if(s=="white")
		saveforvalue[i]=9;
	}
	cout<<(p[saveforvalue[0]].first*10+p[saveforvalue[1]].first)*p[saveforvalue[2]].second<<"\n";
	
}
