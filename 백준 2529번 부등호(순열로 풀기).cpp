#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<char> oper;
vector<int> bigger,smaller;
int k;
/*  순열로 풀기  */
bool checkcmp(vector<int> &v, vector<char> &c)
{
	for(int i=0; i<c.size(); i++)
	{
		if(c[i]=='<' && v[i]>v[i+1])
		return false;
		if(c[i]=='>' &&v[i]<v[i+1])
		return false;
		
	}
	return true;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);	
	cin>>k;
	oper.resize(k);
	bigger.resize(k+1); smaller.resize(k+1);
	for(int i=0; i<k; i++)
	cin>>oper[i];
	
	for(int i=0; i<k+1; i++)
	{
		bigger[i]=9-i;
		smaller[i]=i;
	}
	do{
		if(checkcmp(smaller,oper))
			break;
	}while(next_permutation(smaller.begin(),smaller.end()));
	do{
		if(checkcmp(bigger,oper))
			break;
	}while(prev_permutation(bigger.begin(),bigger.end()));
	for(int i=0; i<bigger.size(); i++)
	cout<<bigger[i];
	cout<<endl;
	for(int i=0; i<smaller.size(); i++)
	cout<<smaller[i];
}
