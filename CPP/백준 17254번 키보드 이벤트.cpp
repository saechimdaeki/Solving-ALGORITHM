#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
struct keyboard{
	int num,sec;
	char k;
};
int n,m;
int number,second;
char ch;
bool cmp(struct keyboard &a, struct keyboard &b){
	if(a.sec==b.sec)
	return a.num<b.num;
	else
	return a.sec<b.sec;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	vector<keyboard> v;
	for(int i=0; i<m; i++)
	{
		cin>>number>>second>>ch;
		v.push_back({number,second,ch});
	}
	sort(v.begin(),v.end(),cmp);
	for(int i=0; i<v.size(); i++)
	cout<<v[i].k;
}
