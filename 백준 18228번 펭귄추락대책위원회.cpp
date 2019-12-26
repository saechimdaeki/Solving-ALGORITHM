#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v;
vector<int> leftv;
vector<int> rightv;

int n,sum,check;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	for(int i=0; i<n; i++)
	{
		if(v[i]==-1)
		check=1;
		if(check==0)
		leftv.push_back(v[i]);
		else if(check==1)
		{
			rightv.push_back(v[i]);
		}
	}
	sort(leftv.begin(),leftv.end());
	sort(rightv.begin(),rightv.end());
	sum+=leftv[0];
	sum+=rightv[1];
	cout<<sum;
	
			
	
}
