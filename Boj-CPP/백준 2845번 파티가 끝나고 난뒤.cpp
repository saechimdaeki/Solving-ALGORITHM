#include<iostream>
#include<vector>
using namespace std;

vector<int> v;
int l,p;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>l>>p;
	v.resize(5);
	for(int i=0; i<5; i++)
	{
		cin>>v[i];
		cout<<v[i]-l*p<<" ";
	}
}
