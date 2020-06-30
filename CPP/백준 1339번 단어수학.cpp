#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int n,answer;
vector<string> vs;
vector<char> letter;
vector<int> v;
char alphabet[256]; 
int calculate(vector<string> &v1, vector<char> &v2, vector<int> &v3)
{
	int sum(0);
	int m(v2.size());
	for(int i=0; i<m; i++)
	alphabet[v2[i]]=v3[i];
	for(string s:v1)
	{
		int now(0);
		for(char j:s)
		now=now*10+alphabet[j];
		sum+=now;
	}
	return sum;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	vs.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>vs[i];
		for(char j: vs[i])
		letter.push_back(j);
	}
	sort(letter.begin(),letter.end());
	letter.erase(unique(letter.begin(),letter.end()),letter.end());
	int m=letter.size();
	for(int i=9; i>9-m; i--)
	v.push_back(i);
	sort(v.begin(),v.end());
	do{
		int now=calculate(vs,letter,v);
		answer=max(answer,now);
	}while(next_permutation(v.begin(),v.end()));
	cout<<answer;
}
