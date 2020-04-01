#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> v;
int solve(vector<int > &a)
{
	if(a.size()==2)
	return 0;
	int answer(0);
	for(int i=1; i<a.size()-1; i++)
	{
		int power(a[i-1]*a[i+1]);
		vector<int> next;
		next=a;
		next.erase(next.begin()+i);
		power+=solve(next);
		answer=max(answer,power);
	}
	return answer;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	cout<<solve(v);
}
