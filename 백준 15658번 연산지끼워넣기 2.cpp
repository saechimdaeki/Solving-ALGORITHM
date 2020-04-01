#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
vector<int> v;
int n,pl,mi,mu,di;
pair<int, int> solve(vector<int> &v1,int idx, int cur, int plus,int minus, int mul, int div)
{
	if(idx==v1.size())
	return {cur,cur};
	vector<pair<int, int>> tmpv;
	if(plus>0)
	tmpv.push_back(solve(v1,idx+1,cur+v[idx],plus-1,minus,mul,div)); 
	if(minus>0)
	tmpv.push_back(solve(v1,idx+1,cur-v[idx],plus,minus-1,mul,div));
	if(mul>0)
	tmpv.push_back(solve(v1,idx+1,cur*v[idx],plus,minus,mul-1,div));
	if(div>0)
	tmpv.push_back(solve(v1,idx+1,cur/v[idx],plus,minus,mul,div-1));
	auto ans=tmpv[0];
	for(auto i:tmpv)
	{
		if(ans.first<i.first)
		ans.first=i.first;
		if(ans.second>i.second)
		ans.second=i.second;
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
	cin>>pl>>mi>>mu>>di;
	auto answer= solve(v,1,v[0],pl,mi,mu,di);
	cout<<answer.first<<endl;
	cout<<answer.second;
	
}
