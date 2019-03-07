#include<iostream>
#include<algorithm>
#include<vector> 
using namespace std;
int main()
{
	int n,aa,bb;
	int bts(0);
	vector<int> a, b;
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>aa;
		a.push_back(aa);
	}
	for(int i=0; i<n; i++)
	{	
		cin>>bb;
		b.push_back(bb);
	}
		sort(a.begin(),a.end());
		sort(b.begin(),b.end());
		reverse(b.begin(),b.end());
		
	for(int i=0; i<n; i++)
	{
		bts+=a[i]*b[i];	
		
		
	}
	
	cout<<bts;
}

