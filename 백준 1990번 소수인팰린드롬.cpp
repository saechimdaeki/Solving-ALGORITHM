#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
#define endl '\n'
using namespace std;
int a,b;
vector<int> v;
bool check[10001];
string s,tmp;
int prime(int n)
{
	if(n==1)
	return 0;
	int bts=(int)sqrt(n);
	for(int i=2; i*i<=n; i++)
	{
		if(n%i==0)
		return 0;
	}
	return 1;	
} 
void pelindrome(int num)
{
	s=to_string(num);
	tmp=s;
	tmp.pop_back();
	reverse(tmp.begin(),tmp.end());
	if(s.length()==1)
	{
		v.push_back(num);
		v.push_back(stoi(s+s));
	}else{
		v.push_back(stoi(s+s));
		v.push_back(stoi(s+tmp));
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b;
	for(int i=1; i<=10000; i++)
	pelindrome(i);
	sort(v.begin(),v.end());
	for(int i=2; i<=10000; i++)
	{
		if(prime(i)==1)
		check[i]=false;
	}
	check[1]=true;
	for(int i=0; i<v.size(); i++)
	{
		bool print(true);
		if(v[i]>=a && v[i]<=b){
		for(int j=1; j*j<=v[i]; j++)
		{
			if(check[j]==false && v[i]%j==0)
			{
				print=false;
				break;				
			}
		}
		if(print)
		cout<<v[i]<<endl;
	}
	}
	
	cout<<-1;
}
