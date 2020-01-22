#include<iostream>
#include<vector>
#include<algorithm>
#include<functional>
#define endl '\n'
using namespace std;
int t,a,b,cnt;

vector<int> v;
int Max(2e9);
int Min(-2e9);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	v.resize(t);
	for(int i=0; i<t; i++)
	{
		cnt=0;
		cin>>a>>b;
		vector<int> A(a);
		vector<int> B(b);
		for(int i=0; i<a; i++)
			cin>>A[i];
		for (int i=0; i<b; i++) 
			cin>>B[i];
	
		B.push_back(Max);
		B.push_back(Min);
	sort(B.rbegin(),B.rend());
	for (int j=0; j<a; j++)
	{
		int left=0; int right=B.size()-1;
		while(1)
		{
			if(left==right-1)
			{
				if (right!= B.size()-1)
				{
					cnt+=B.size()-1-right;
				}
				break;
			}
			int mid((left+right)/2);
			if(B[mid]>=A[j])
			left=mid;
			else
			right=mid;
		}
	}
	v[i]=cnt;		
	}
	
	for(int i=0; i<t; i++)
	cout<<v[i]<<endl;
}

