#include<iostream>
#include<vector>
using namespace std;
int n,s,answer;
vector<int> v;

void solution(int index, int sum)
{
	if(index==n)
	{
		if(sum==s)
		answer++;
		return;
	}	
	solution(index+1, sum+v[index]);
	solution(index+1,sum);
	
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>s;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	solution(0,0);
	if(s==0)
	answer--;
	cout<<answer;
}

