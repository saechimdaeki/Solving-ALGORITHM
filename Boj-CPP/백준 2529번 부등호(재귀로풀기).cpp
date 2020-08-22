#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
char a[20];
vector<string> answer;
bool checked[10];
int n;
bool cmp(char x, char y, char operator_)
{
	if(operator_=='<')
		if(x>y)
			return false;
	
	if (operator_=='>')
		if(x<y)
			return false;
	return true;				
}

void solve(int idx, string num)
{
	if(idx==n+1)
	{
		answer.push_back(num);
		return;
	}
	for(int i=0; i<10; i++)
	{
		if(checked[i])
		continue;
		if(idx==0 || cmp(num[idx-1],i+'0',a[idx-1]))
		{
			checked[i]=true;
			solve(idx+1,num+to_string(i));
			checked[i]=false;
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	cin>>a[i];
	solve(0,"");
	auto ans=minmax_element(answer.begin(),answer.end());
	cout<<*ans.second<<endl;
	cout<<*ans.first;
}

