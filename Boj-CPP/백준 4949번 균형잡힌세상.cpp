#include<iostream>
#include<algorithm>
#define endl '\n'
#include<vector>
using namespace std;



int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	while(1)
	{
		getline(cin,s);
		if(s==".")
		break;
		vector<char> v;
		bool check=true;
		int cnt1(0),cnt2(0),cnt3(0),cnt4(0); //  (  [  ) ] ÀÌ¼ø¼­ 
		for(int i=0; i<s.length(); i++)
		{
			if(s[i]=='[')
			{
				cnt2++;
				v.push_back(s[i]);	
			}
			else if (s[i]=='(')
			{
				cnt1++;
				v.push_back(s[i]);
			}
			else if (s[i]==')')
			{
				cnt3++;
				if(cnt3>cnt1)
				check=false;
				else if(v[v.size()-1]!='(')
					check=false;
				else 
				v.erase(v.begin()+v.size()-1);
			}
			else if(s[i]==']') 
			{
				cnt4++;
				if(cnt4>cnt2)
				check=false;
				else if(v[v.size()-1]!='[')
					check=false;
				else 
				v.erase(v.begin()+v.size()-1);		
			}
		}
		if(cnt2!= cnt4 || cnt1!=cnt3)
		check=false;
		if(check==false)
		{
			cout<<"no"<<endl;
		}
		else
		cout<<"yes"<<endl;
		//cout<<"no"<<endl;
		
	}
}
