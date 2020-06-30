#include<iostream>
#include<vector>
using namespace std;
vector<int> s;
int n,m,cnt;
/* 내가푼것 틀려서 백준센세 강의참고.*/
int count(int mask,vector<int> &v1)
{
	cnt=0;
	for(int i:v1)
	{
	if ((i & ((1<<26)-1-mask)) == 0) {
            cnt ++;
        }
	}
	return cnt;
}
int solve(int idx,int k,int mask, vector<int> &s1)
{
	if(k<0)
	return 0;
	if(idx==26)
	return count(mask,s1);
	int answer(0);
	int tmp(solve(idx+1,k-1,mask|(1<<idx),s1));
	if(answer<tmp)
	answer=tmp;
	if(idx!='a'-'a' && idx != 'n'-'a' && idx!='t'-'a' && idx!='i'-'a'&& idx!='c'-'a')
	{
		tmp=solve(idx+1,k,mask,s1);
		if(answer<tmp)
		answer=tmp;
		
	}
	return answer;
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	s.resize(n);
	for(int i=0; i<n; i++)
	{
		string tmp;
		cin>>tmp;
		for(char c:tmp)
		s[i] |= (1 << (c-'a'));
	}
	cout<<solve(0,m,0,s);
}
