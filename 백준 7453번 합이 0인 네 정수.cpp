#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> A,B,C,D;
int n;
vector<int> front,behind;
long long answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	A.resize(n);B.resize(n);C.resize(n);D.resize(n);
	for(int i=0; i<n; i++)
		cin>>A[i]>>B[i]>>C[i]>>D[i];
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
		{
			front.push_back(A[i]+B[j]);
			behind.push_back(C[i]+D[j]);	
		}	
	sort(behind.begin(),behind.end());
	for(int i:front)
	{
		auto tmp=equal_range(behind.begin(),behind.end(),-i);
		answer+=tmp.second-tmp.first;
	}
	cout<<answer;
}
