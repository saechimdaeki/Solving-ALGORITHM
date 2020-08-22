#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
string a;
int b;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b;
	sort(a.begin(),a.end());
	int answer=-1;
	do{
		int tmp=stoi(a);
		if(a[0]!='0' && tmp<=b)
		{
			answer=max(answer,tmp);
		}
	}while(next_permutation(a.begin(),a.end()));
	cout<<answer;
}
