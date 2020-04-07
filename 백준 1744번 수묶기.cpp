#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> mi,v;
int n,answer;
int one,zero;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		if(a==1)
		one++;
		else if(a>0)
		v.push_back(a);
		else if(a<0)
		mi.push_back(a);
		else 
		zero++;			
	}
	sort(v.rbegin(),v.rend());
	sort(mi.begin(),mi.end());
	
	if(v.size()%2==1)
	v.push_back(1);
	
	if(mi.size()%2==1)
	{
		if(zero>0)
		mi.push_back(0);
		else
		mi.push_back(1);
	}
	answer=one;
	
	for(int i=0; i<v.size(); i+=2)
	answer+= (v[i]*v[i+1]);
	
	for(int i=0; i<mi.size(); i+=2)
	answer+= (mi[i]*mi[i+1]);
	
	cout<<answer;
	
}
