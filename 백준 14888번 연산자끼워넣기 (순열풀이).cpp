#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v,oper,answer;
int n,tmp;
int calculate(vector<int> &a, vector<int> &b)
{
	int ans=a[0];
	for(int i=1; i<n; i++)
	{
		if(b[i-1]==0)
		ans=ans+a[i];
		else if(b[i-1]==1)
		ans=ans-a[i];
		else if(b[i-1]==2)
		ans=ans*a[i];
		else
		ans=ans/a[i];
	}
	return ans;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	for(int i=0; i<4; i++)
	{
		cin>>tmp;
		for(int j=0; j<tmp; j++)  //+:0, -:1, x:2, /:3
		oper.push_back(i);
	}
	sort(oper.begin(),oper.end());
	do{
		int bts(calculate(v,oper));
		answer.push_back(bts);
	}while(next_permutation(oper.begin(),oper.end()));
	
	auto abcd=minmax_element(answer.begin(),answer.end());
	cout<<*abcd.second<<endl;
	cout<<*abcd.first;
	
}
