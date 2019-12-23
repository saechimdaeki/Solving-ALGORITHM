#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int n;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	sort(v.begin(),v.end());
	int a(1);
	for(int i=0; i<v.size(); i++)
	{
		if(a!=v[i])
		{
			goto z;
		}
		else
		a++;
	}
	z:
		cout<<a;
}

