#include<iostream>
#include<algorithm>
#define endl '\n'
#include<vector>
#include<cmath>
using namespace std;
vector<int> v;
int n,s;
int answer;
int gcd(int a,int b)
{
	if(b==0)
	return a;
	return gcd(b,a%b);
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>s;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(abs(a-s));
	}	
	for(auto i:v)
	answer=gcd(answer,i);
	cout<<answer;
	
}
