#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector <int > v;
int n;
int answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	
	for(int i=0; i<n; i++)
	cin>>v[i];
	
	sort(v.begin(),v.end());
	do{
		int tmp=0;
		for(int i=0; i<v.size()-1; i++)
			tmp+=abs(v[i]-v[i+1]);
		answer=max(answer,tmp);
		
	}while(next_permutation(v.begin(),v.end()));
	cout<<answer;
}
