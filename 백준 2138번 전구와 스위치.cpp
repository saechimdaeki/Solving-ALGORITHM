#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int> a,b;
string s;
int n;
void change(vector<int> &v1, int idx)
{
	for(int i=idx-1; i<=idx+1; i++)
	{
		if(0<=i && i<v1.size())
		v1[i]=1-v1[i];
	}
}
pair<bool,int> solve(vector<int> v1, vector<int> v2)
{
	
	int ans(0);
	for(int i=0; i<n-1; i++)
	{
		if(v1[i]!=v2[i])
		{
			change(v1,i+1);
			ans++;
		}
	}
	if(v1==v2)
	return make_pair(true,ans);
	else
	return make_pair(false,ans);
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	a.resize(n);
	b.resize(n);
	cin>>s;
	for(int i=0; i<n; i++)
	a[i]=s[i]-'0';
	cin>>s;
	for(int i=0; i<n; i++)
	b[i]=s[i]-'0';
	auto a1=solve(a,b);
	change(a,0);
	auto a2=solve(a,b);
	if(a2.first)
	a2.second++;
	if(a1.first && a2.first)
	cout<<min(a1.second,a2.second);
	else if(a1.first)
	cout<<a1.second;
	else if(a2.first)
	cout<<a2.second;
	else
	cout<<-1;
}
