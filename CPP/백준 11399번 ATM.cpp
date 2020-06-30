#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
vector<int> v2;
int n,sum,tmp;

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
	{
		tmp+=v[i];
		v2.push_back(tmp);
	}
	for(int i=0; i<v2.size(); i++)
		sum+=v2[i];
		cout<<sum;
}
