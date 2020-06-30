#include<iostream>
#include<vector>
#include<algorithm>
#include<functional>

using namespace std;

int main()
{
	int sum(0);
	vector<int> number;
	vector<pair<int , int> > v(8);
	for(int i=0; i<8; i++)
	{
		cin>>v[i].first;
		v[i].second=i+1;
	}
	
	sort(v.begin(),v.end());
	reverse(v.begin(),v.end());
	for(int i=0; i<5; i++)
	{
		sum+=v[i].first;
		number.push_back(v[i].second);
	}
	cout<<sum<<endl;
	
	sort(number.begin(),number.end());
	for(int i=0; i<number.size(); i++)
	cout<<number[i]<<" ";
	return 0;
	
}
