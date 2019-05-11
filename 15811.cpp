#include<iostream>
#include<string>
#include<set>
#include<cmath>
#include<vector>

typedef long long ll;
using namespace std;

string operand1, operand2, result;

set <char> alphaset;
int alphabet[26];
bool choose[10];
bool solve;

ll xstoll(const string& s)
{
	ll result=0;
	for(int i=0; i<s.size(); ++i)
	{
		result += (alphabet[s[i]-65]) * pow(10, s.size()-i-1);
	}
	return result;
}

void dfs(int idx, vector<char>& alphavec)
{
	if(solve) return;
	if(idx==alphavec.size())
	{
		
		if(xstoll(operand1)+xstoll(operand2) == xstoll(result)) solve = true;
		return;
	}
	
	for(int i=0; i<10; i++)
	{
		if(choose[i]) continue;
		alphabet[alphavec[idx]-65] = i;
		choose[i] = true;
		dfs(idx+1 , alphavec);
		choose[i] = false;
	}
}

int main()
{
	cin >> operand1 >> operand2 >> result;
	alphaset.insert(operand1.begin(), operand1.end());
	alphaset.insert(operand2.begin(), operand2.end());
	alphaset.insert(result.begin(), result.end());
	
	vector<char> alphavec(alphaset.begin(), alphaset.end());

	dfs(0, alphavec);
	
	cout << (solve ? "YES" : "NO");
}

