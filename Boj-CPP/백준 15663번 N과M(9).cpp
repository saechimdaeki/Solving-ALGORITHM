#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v,v2;
int n,m;
bool check[10];
vector<vector<int> > arr;
void recur(int idx, int n1, int m1)
{
	if(idx==m1)
	{
		vector<int> tmp;
		for(int i=0; i<m1; i++)
			tmp.push_back(v2[v[i]]);
		arr.push_back(tmp);
		return;
	}
	for(int i=0; i<n; i++)
	{
		if(check[i])
		continue;
		check[i]=true;
		v[idx]=i;
		recur(idx+1,n,m);
		check[i]=false;
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);v2.resize(n);
	for(int i=0; i<n; i++)
	cin>>v2[i];
	sort(v2.begin(),v2.end());
	recur(0,n,m);
	sort(arr.begin(),arr.end()); //sort안할시 출력초과결과초래 
	arr.erase(unique(arr.begin(),arr.end()),arr.end());  //중복제거 (choi baekjoon inkang) 
	for (auto i: arr)
	{
		for (int j=0; j<m; j++)
		{
			cout<<i[j]<<' ';
		}
		cout<<endl;
	}
				
}
