#include<iostream>
#define endl '\n'
#include<vector>
using namespace std;
int a,b,sum;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.reserve(1000);
	cin>>a>>b;
	int abcd(0);
	for(int i=1; i<=1000; i++)
	{
		for(int j=1; j<=i; j++)
		{
			v[abcd]=i;
			if(abcd>1000)
			goto z;
			abcd++;
		}
	}
	z:
	for(int i=a-1; i<b; i++)
	sum+=v[i];
	
	
	cout<<sum;
}
