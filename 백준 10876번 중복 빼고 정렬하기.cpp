#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
int n;
vector<int> v;
bool visited[100001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		if(visited[a+1000]==false)  //이 수는 절댓값이 1,000보다 작거나 같은 정수이다 주의하자;;;  
		{
			v.push_back(a);
			visited[a+1000]=true;
		}
				
	}
	sort(v.begin(),v.end());
	for(int i=0; i<v.size(); i++)
	cout<<v[i]<<' ';
		
	
}
