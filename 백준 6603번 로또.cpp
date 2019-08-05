#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
vector<int> arr;
int n;
bool abc(int a,int b)
{
	return a>b;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	while(cin>>n)
	{
		if(n==0)
		return 0;
		for(int i=0; i<n; i++)
		{
			int a;
			cin>>a;
			v.push_back(a);
		}
		for(int i=0; i<6; i++)
			arr.push_back(1);
		for(int i=0; i<n-6; i++)
			arr.push_back(0);
		sort(arr.rbegin(),arr.rend());
		do{
			for(int i=0; i<n; i++)
			{
				if(arr[i]==1)
				cout<<v[i]<<" ";
			}
			cout<<"\n";
		}while(next_permutation(arr.begin(),arr.end(),abc));
		cout<<"\n";
		v.clear();
		arr.clear();
	}
}
