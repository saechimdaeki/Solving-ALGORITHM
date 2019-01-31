#include<iostream>
#include<cstring>
using namespace std;

int main()
{
	string a;
	cin>>a;//문자열입력 
	int abc(0);//크로아티아 수저장위한 
	for(int i=0; i<a.length(); i++)
	{
		abc++;
		switch(a[i])
		{
			case 'c':
				if(i !=a.length()-1 && (a[i+1]=='='||a[i+1]=='-'))
				i++;
				break;
				
			case 'd':
				if(i!=a.length()-1&&a[i+1]=='-')
				i++;
				if(i<a.length()-2&&a[i+1]=='z'&&a[i+2]=='=')
				i+=2;
				break;
			case 'l':
				if(i!=a.length()-1&&a[i+1]=='j')
					i++;
					break;
			case 'n':
				if(i!=a.length()-1&&a[i+1]=='j')
					i++;
					break;
			case 's':
				if(i!=a.length()-1 &&a[i+1]=='=')
					i++;
					break;
			case 'z':
				if(i!=a.length()-1&&a[i+1]=='=')
					i++;
					break;				
					
		}
	}
	cout<<abc;
}
