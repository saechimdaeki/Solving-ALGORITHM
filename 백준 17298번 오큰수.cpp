#include<iostream>
#include<algorithm>
#include<vector>
#include<stack>
#define endl '\n'
using namespace std;
int n;
vector<int > v;
vector<int> ans;
stack<int> s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	ans.resize(n);
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	s.push(0);
	for(int i=1; i<n; i++)
	{
		if(s.empty())
		s.push(i);
		while(!s.empty() && v[s.top()]<v[i]){
			ans[s.top()]=v[i];
			s.pop();
		}
		s.push(i);
	}
	while(!s.empty()){
		ans[s.top()]=-1;
		s.pop();
	}
	for(int i=0; i<n; i++)
	cout<<ans[i]<<' ';
	
}
