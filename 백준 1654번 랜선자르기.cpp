#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
long long k,n,save;
vector<int> v;
long long start=1,endd;
bool solve(int n1)
{
	int answer(0);
	for(int i=0; i<v.size(); i++)
	answer+=(v[i]/n1);
	if(answer>=n)
	return true;
	else
	return false;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>k>>n; //k개가지고있고 n만들어야함
	v.resize(k);
	for(int i=0; i<k; i++)
		cin>>v[i];
	endd=*max_element(v.begin(),v.end());
	while(start<=endd)
	{
		long long mid((start+endd)/2);
		if(solve(mid))
		{
			if(save<mid)
			save=mid;
			start=mid+1;	
		}else{
			endd=mid-1;
		} 
	}
	cout<<save;	
}
