#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int arr[21][21];
int n;
int ans=2e9+1;
vector<int> v;
/*  백준센세 인강듣고 순열로풀기  */
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)	
			cin>>arr[i][j];
	v.resize(n);
	for(int i=0; i<n; i++)
	v[i]=i;
	do{
		bool ok(true);
		int sum(0);
		for(int i=0; i<n-1; i++)
		{
			if(arr[v[i]][v[i+1]]==0)
			ok=false;
			else
			sum+=arr[v[i]][v[i+1]];
		}
		if(ok&&arr[v[n-1]][v[0]]!=0){
			sum+=arr[v[n-1]][v[0]];
			ans=min(ans,sum);
		}
	}while(next_permutation(v.begin(),v.end()));
	cout<<ans;		
}
