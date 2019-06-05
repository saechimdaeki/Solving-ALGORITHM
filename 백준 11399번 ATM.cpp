#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;

int n,inchul;
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
	for(int i=0; i<n; i++)
		for(int j=0; j<=i; j++)
			inchul+=v[j];
			
	cout<<inchul<<"\n";
	
}
