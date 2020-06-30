#include<iostream>
#include<stack>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
int n,width;
vector<int> v;
stack<int> s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);	
	}
	v.push_back(0);
	
	for(int i=0; i<v.size(); i++)
	{
		while(s.empty()==0 && v[s.top()]>v[i])
		{
			int tmp(s.top());
			s.pop();
			int tmpmul;
			if(s.empty()==1)
				tmpmul=i;
			else
				tmpmul=i-s.top()-1;
			width=max(width,v[tmp]*tmpmul);
		}
		s.push(i);
	}
	cout<<width;
	
}
