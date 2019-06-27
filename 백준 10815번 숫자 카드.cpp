#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;
int n,m;
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
	cin>>m;
	for(int i=0; i<m; i++)
	{
		int a,b(0),left(0),right(n-1);
		cin>>a;
		while(left<=right)
		{
			int mid((left+right)/2);
			if(v[mid]==a)
			{
				b++;
				break;
			} 
			else if(v[mid]<a)
			left=mid+1;
			else
			right=mid-1;
		}
		if(b==1)
		cout<<"1"<<" ";
		else
		cout<<"0"<<" ";
	}
}
