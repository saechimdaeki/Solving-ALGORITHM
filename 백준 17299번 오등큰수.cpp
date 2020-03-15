#include<iostream>
#include<algorithm>
#include<stack>
#include<vector>
using namespace std;
int n;
int arr[1000001];
vector<int> v,answer;
stack<int> s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n); answer.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i];
		arr[v[i]]++;
	}
	//오큰수와 동일 (최백준센세 강의);  
	s.push(0);
	for(int i=1; i<n; i++)
	{
		if(s.empty())
		s.push(i);
		while(!s.empty()&&arr[v[s.top()]]<arr[v[i]])
		{
			answer[s.top()]=v[i];
			s.pop();
		}
		s.push(i);
	}
	while(!s.empty())
	{
		answer[s.top()]=-1;
		s.pop();
	}
	for(int i=0; i<n; i++)
	cout<<answer[i]<<' ';
}
