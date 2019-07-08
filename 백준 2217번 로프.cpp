#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> v;
int answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	sort(v.begin(),v.end());
	for(int i=0; i<n; i++)
	answer=max(answer,v[i]*(n-i));
	cout<<answer;
}
