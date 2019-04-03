#include<iostream>
#include<vector>
using namespace std;

int main()
{
	int n;
	cin>>n;
	vector<vector <char> > v(26, vector<char>(0));
	for(int i=0; i<n; i++)
	{
		string name;
		cin>>name;
		v[int(name[0]-97)].push_back('a');
	}
	string result;
	for(int i=0; i<26; i++)
		if(v[i].size()>=5)
			result+=char(i+97);
			
			if(result.empty())
				cout<<"PREDAJA"<<endl;
				else
				cout<<result<<endl;
				
}
