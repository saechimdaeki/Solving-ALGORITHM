#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v;
int n,m;
bool check[10];

void recur(int idx, int n1, int m1)
{
	if(idx==m1)
	{
		for(int i=0; i<m1; i++)
		cout<<v[i]<<' ';
		cout<<endl;
		return;
	}
	for(int i=0; i<n; i++)
	{
		if(check[i])
		continue;
		check[i]=true;
		v[idx]=i+1;
		recur(idx+1,n,m);
		check[i]=false;
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	recur(0,n,m);		
}
