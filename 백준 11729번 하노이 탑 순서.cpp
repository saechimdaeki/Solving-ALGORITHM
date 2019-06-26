#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<pair < int, int> >v;
////////열혈 자료구조 책 참고하여 풀었슴......////// 
void hanoi(int n, int start , int used , int end)
{
	if(n==1)
	v.push_back({start,end});
	else
	{
		hanoi(n-1,start,end,used);
		v.push_back({start,end});
		hanoi(n-1,used,start,end);
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	hanoi(n,1,2,3);
	cout<<v.size()<<"\n";
	for(int i=0; i<v.size(); i++)
	cout<<v[i].first<<" "<<v[i].second<<"\n";
} 
