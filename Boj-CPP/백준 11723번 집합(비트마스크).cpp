#include<iostream>
#define endl '\n'
using namespace std;
int m,s,tmp;
string s1;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>m;
	while(m--)
	{
		cin>>s1;
		if(s1=="add")
		{
			cin>>tmp;
			tmp--; //1부터 n까지면 공간2배되니께 
			s=	(s|(1<<tmp));
		}else if(s1=="remove")
		{
			cin>>tmp;
			tmp--;
			s=(s&~(1<<tmp));
		}else if(s1=="check")
		{
			cin>>tmp;
			tmp--;
			if (s&(1<<tmp))	
				cout<<1<<endl;
			else 
			cout<<0<<endl;
		}else if(s1=="toggle")
		{
			cin>>tmp;
			tmp--;
			s=(s^(1<<tmp));
		}else if(s1=="all")
		{
			s=(1<<20)-1;
		}else if(s1=="empty")
		{
			s=0;
		}
				
	}
	
}
