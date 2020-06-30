#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n,m;
vector <int> v;

int search(int A, int B, int find)
{
	if(A>B)
	return 0;
	 else
	 {
	 	int middle((A+B)/2);
	 	
	 	if (v[middle]==find)
	 	return 1;
	 	else if(v[middle]>find)
	 	return search(A,\
		 middle-1,\
		 find);
	 	else
	 	return search(middle+1,B,find);
	 }
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int bts;
		cin>>bts;
		v.push_back(bts);
	}
	sort(v.begin(),v.end());
	cin>>m;
	for(int i=0; i<m; i++)
	{
		int bts;
		cin>>bts;
		cout<<search(0,n-1,bts)<<\
		"\n";
	}
}
 
