#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v;
int n,m,k,cnt,sum;
bool check;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	cin>>m>>k;
	for(int i=0; i<n; i++)
	cin>>v[i];
	sort(v.rbegin(),v.rend());
	
	for(int i=0; i<n; i++)
	{
		sum+=v[i];
		cnt++;
		if(sum>=(m*k))
		{
			check=true;
			goto z;
		}
	}
	z:
		if(check==true)
		cout<<cnt;
		else 
		cout<<"STRESS";
}

