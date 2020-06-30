#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
#define endl '\n'
using namespace std;
int n;
vector<int> v;
string s;
int arr[1003002];
bool pelindrome;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<=1003001; i++){
		arr[i]=i;
	}
	for (int i=2; i<=1003001; i++){
		if(arr[i]==0)
		continue;
		v.push_back(arr[i]);
		for(int j= i+i; j<=1003001; j+=i)
		arr[j]=0;
	}
	for (int i=0; i<v.size(); i++){
		if (v[i]>=n){
			pelindrome=true;
			s=to_string(v[i]);
			string temp=s;
			reverse(temp.begin(),temp.end());
			if(temp!=s)
			pelindrome=false;
			if(pelindrome==true)
			{
				cout<<v[i];
				return 0;
			}
		}
	}

}
