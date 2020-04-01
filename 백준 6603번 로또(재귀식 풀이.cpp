#include<iostream>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> input,lotto;
int n;

void solution(vector<int> &v , int idx, int cnt)
{
	if(cnt==6)
	{
		for(auto i:lotto)
		cout<<i<<' ';
		cout<<endl;
		return;
	}
	if(v.size()==idx)
	return;
	lotto.push_back(v[idx]);
	solution(v,idx+1,cnt+1); //선택
	lotto.pop_back();
	solution(v,idx+1,cnt);//선택 x  
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	while(1)
	{
		cin>>n;
		if(n==0)
		break;
		input.resize(n);
		for(int i=0;i<n;i++)
		cin>>input[i];
		solution(input,0,0);
		cout<<endl;
	}
}
